package programmers;

import java.util.*;

public class 불량_사용자2 {
    static class Solution {
        Set<Set<String>> userSet;
        public int solution(String[] user_id, String[] banned_id) {
            int answer = 0;
            userSet = new HashSet<>();
            boolean[] used = new boolean[user_id.length];
            dfs(user_id,banned_id,used,0,new HashSet<>());
//            System.out.println(userSet);

            return userSet.size();
        }
        void dfs(String[] user_id,String[] banned_id,boolean[] used,int idx,Set<String> set){
            if(idx == banned_id.length){
                userSet.add(new HashSet<>(set));
                return;
            }
            for(int i =0;i<user_id.length;i++){
                if(!used[i] && matched(banned_id[idx],user_id[i])){
                    set.add(user_id[i]);
                    used[i] = true;
                    dfs(user_id, banned_id, used, idx+1, set);
                    used[i] = false;
                    set.remove(user_id[i]);
                }
            }
        }
        private boolean matched(String ban,String id){
            if(ban.length() != id.length()) return false;
            for(int i =0;i<ban.length();i++){
                if(ban.charAt(i) == '*') continue;
                if(ban.charAt(i) != id.charAt(i)) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
                new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"*rodo", "*rodo", "******"}
        ));
    }
}
