package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 주차_요금_계산2 {
    static class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer;
            Map<String,Integer> total = new HashMap<>();
            Map<String,Integer> park = new HashMap<>();
            for(String record : records){
                String[] words = record.split(" ");
                String num = words[1];
                int time = timeToInt(words[0]);
                if(words[2].equals("IN")){ //입차
                    park.put(num,time);
                }else{ //출차
                    int start = park.remove(num);
                    int val = time - start;
                    total.put(num,total.getOrDefault(num,0)+val);
                }
            }
            System.out.println(total+" "+park);
            for(Map.Entry<String,Integer> remain : park.entrySet()){
                int val = timeToInt("23:59") - remain.getValue();
                total.put(remain.getKey(),
                        total.getOrDefault(remain.getKey(),0)+val);
            }
            List<Map.Entry<String,Integer>> list = new ArrayList<>(total.entrySet());
            list.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));
            answer = new int[list.size()];
            int idx = 0;
            for(Map.Entry<String,Integer> target : list){
                int cost = fees[1];
                int time = target.getValue();
                time -= fees[0]; //기본 요금 계산
                if(time > 0) {
                    cost += time % fees[2] == 0 ? time / fees[2] * fees[3] : (time / fees[2] + 1) * fees[3];
                }
                answer[idx++] = cost;
            }

            return answer;
        }
        private int timeToInt(String time){
            String[] word = time.split(":");
            return Integer.parseInt(word[0])*60 + Integer.parseInt(word[1]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{180, 5000, 10, 600},
                new String[]{
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"})));
    }
}
