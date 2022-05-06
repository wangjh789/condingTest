package programmers;

import java.util.HashMap;
import java.util.Map;

public class 스킬트리2 {
    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            Map<Character,Integer> map = new HashMap<>();
            for(int i =0;i<skill.length();i++)
                map.put(skill.charAt(i),i);
            for(String target : skill_trees){
                boolean possible = true;
                int idx = 0;
                for(char ch : target.toCharArray()){
                    if(map.containsKey(ch)){
                        if(map.get(ch) == idx) idx++;
                        else{
                            possible = false;
                            break;
                        }
                    }
                }
                if(possible) answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
