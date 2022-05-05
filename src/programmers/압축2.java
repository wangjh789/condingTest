package programmers;

import java.util.*;

public class 압축2 {
    static class Solution {
        public int[] solution(String msg) {
            List<Integer> answer = new ArrayList<>();
            Map<String,Integer> map = new HashMap<>();
            char a = 'A';
            for(int i=0;i<26;i++) map.put(String.valueOf((char)(a+i)),i+1);
            int idx = 0;
            while(idx < msg.length()){
                int term = 0;
                while(idx+term < msg.length()){
                    if(!map.containsKey(msg.substring(idx,idx+term+1)))
                        break;
                    term++;
                }
                answer.add(map.get(msg.substring(idx,idx+term)));
                if(idx+ term <msg.length()){
                    map.put(msg.substring(idx,idx+term+1),map.size()+1);
                }
                idx+=term;
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution("TOBEORNOTTOBEORTOBEORNOT")));
    }
}
