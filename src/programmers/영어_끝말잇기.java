package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {
    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = new int[]{0,0};
            Set<String> log = new HashSet<>();
            for(int i =0;i< words.length;i++){
                if(!isValid(i,words) || log.contains(words[i])){
                    int turn = i%n+1;
                    int round = i/n+1;
                    return new int[]{turn,round};
                }else log.add(words[i]);
            }
            return answer;
        }
        private boolean isValid(int idx,String[] words){
            if(words[idx].length()<2) return false;
            if(idx > 0){
                return words[idx].charAt(0) == words[idx - 1].charAt(words[idx - 1].length()-1);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(3, new String[]{
                "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
        })));
    }
}
