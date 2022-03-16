package programmers;

import java.util.*;

public class 셔틀버스 {
	static class Solution {
		public String solution(int n, int t, int m, String[] timetable) {
			String answer = "";
			PriorityQueue<Integer> memberQue = new PriorityQueue<>();
			Queue<Integer> busQue = new LinkedList<>();
			int bus = 60*9; //9시 분으로 변환
			for(int i = 0;i<n;i++){
				busQue.offer(bus + t*i);
			}
			for(String time: timetable){
				String[] tmp = time.split(":");
				memberQue.offer(Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]));
			}
			System.out.println(busQue);
			int value = -1;
			while(!busQue.isEmpty()){
				int time = busQue.poll(); //버스 도착시간
				int count = 0;
				//인원수 대로 먼저온 멤버가 버스에 탐
				while(!memberQue.isEmpty() && memberQue.peek() <= time && count < m){
					if(busQue.isEmpty() && count == m-1){ //버스를 탈 수 있는 마지막 기회일 때
						value = memberQue.poll()-1;
						break;
					}
					memberQue.poll();
					count++;
				}
				if(value==-1 && busQue.isEmpty()){
					value = time;
				}
			}

			return parseToTime(value);
		}
		String parseToTime(int value){
			int hour = value/60;
			String strHour = hour<10 ? "0"+hour : hour+"";
			int min = value%60;
			String strMin = min< 10 ? "0"+min:min+"";
			return strHour+":"+strMin;
		}
	}


	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(1,1,5,
				new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));

	}
}
