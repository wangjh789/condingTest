package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 셔틀버스2 {
    static class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            String answer = "";
            PriorityQueue<Integer> memberQue = new PriorityQueue<>();
            for(String time : timetable)memberQue.offer(timeToInt(time));
            Queue<Integer> busQue = new LinkedList<>();
            int start = 60*9;
            for(int i =0;i<n;i++) busQue.offer(start+ t*i);
            while(!busQue.isEmpty()){
                int time = busQue.poll();
                int count = 0;
                while(count < m &&!memberQue.isEmpty() && memberQue.peek() <= time ){
                    if(busQue.isEmpty() && count == m-1){ //내가 타야할떄
                       return intToTime(memberQue.peek()-1);
                    }
                    count++;
                    memberQue.poll();
                }
                if(busQue.isEmpty()){
                    return intToTime(time);
                }
            }
            return answer;
        }

        private int timeToInt(String time){
            String[] split = time.split(":");
            return Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
        }

        private String intToTime(int time){
            String hour = String.valueOf(time/60).length()==1 ?"0"+ String.valueOf(time/60):String.valueOf(time/60);
            String min =String.valueOf(time%60).length()==1 ?"0"+ String.valueOf(time%60):String.valueOf(time%60);
            return hour+":"+min;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10,60,45,new String[]{
                "23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"
        }));
    }
}
