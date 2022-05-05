package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 뉴스_클러스터링2 {
    static class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;
            Map<String, int[]> map = new HashMap<>();
            for(int i =0;i<str1.length()-1;i++){
                if(Character.isAlphabetic(str1.charAt(i))
                        && Character.isAlphabetic(str1.charAt(i+1))){
                    String t = String.valueOf(Character.toUpperCase(str1.charAt(i)))+
                            String.valueOf(Character.toUpperCase(str1.charAt(i+1)));
                    if(!map.containsKey(t))
                        map.put(t,new int[]{0,0});
                    map.get(t)[0]++;
                }
            }
            for(int i =0;i<str2.length()-1;i++){
                if(Character.isAlphabetic(str2.charAt(i))
                        && Character.isAlphabetic(str2.charAt(i+1))){
                    String t = String.valueOf(Character.toUpperCase(str2.charAt(i)))+
                            String.valueOf(Character.toUpperCase(str2.charAt(i+1)));
                    if(!map.containsKey(t))
                        map.put(t,new int[]{0,0});
                    map.get(t)[1]++;
                }
            }
            int val1 = 0;
            int val2 = 0;
            for(Map.Entry<String,int[]> entry:map.entrySet()){
                int[] value = entry.getValue();
                val1 += Math.max(value[0],value[1]);
                val2 += Math.min(value[0],value[1]);
            }
            return (val2*65536)/val1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("FRANCE","french"));
        System.out.println(sol.solution("handshake","shake hands"));
    }
}
