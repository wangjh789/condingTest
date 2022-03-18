package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 광고_삽입 {
	static class Solution {
		public String solution(String play_time, String adv_time, String[] logs) {
			int playSec = strToSec(play_time);
			int advSec = strToSec(adv_time);
			int[] adv = new int[100*60*60];
			for(String log :logs){
				String[] l = log.split("-");
				int start = strToSec(l[0]);
				int end = strToSec(l[1]);
				for(int i=start;i<end;i++){
					adv[i]++;
				}
			}
			long sum = 0;
			for(int i =0;i<advSec;i++){
				sum += adv[i];
			}
			long max = sum;
			int idx = 0;
			for(int i = advSec;i<playSec;i++){
				sum += (adv[i] - adv[i-advSec]);
				if(max  < sum){
					max = sum;
					idx = i-advSec+1;
				}
			}
			return secToStr(idx);
		}
		String secToStr(int time){
			int hour = time/(60*60);
			time%=(60*60);
			int min = time/60;
			time%=60;
			int sec = time;
			return String.valueOf(hour < 10 ? "0" + hour : hour) + ':' + (min < 10 ? "0" + min : min) + ':' + (sec < 10 ? "0" + sec : sec);
		}
		int strToSec(String t){
			String[] arr = t.split(":");
			return Integer.parseInt(arr[0])*60*60 + Integer.parseInt(arr[1])*60 +
					Integer.parseInt(arr[2]);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("50:00:00","50:00:00",new String[]{
				"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"
		}));

	}
}
