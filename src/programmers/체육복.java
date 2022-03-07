package programmers;

import java.util.Arrays;

public class 체육복 {
	static class Solution {
		public int solution(int n, int[] lost, int[] reserve) {
			int answer = 0;
			int[] check = new int[n];
			Arrays.fill(check,1);
			for (int j : lost) check[j - 1]--;
			for (int j : reserve) check[j - 1]++;
			if(check[0] == 2 && check[1] == 0){ //첫번쨰 경우
				check[0]--;
				check[1]++;
			}
			for(int i=1;i<check.length-1;i++){
				if(check[i] == 2){
					if(check[i-1] ==0){
						check[i-1]++;
						check[i]--;
					}else if(check[i+1] == 0){
						check[i+1]++;
						check[i]--;
					}
				}
			}
			if(check[check.length-1]==2 && check[check.length-2]==0){
				check[check.length-1]--;
				check[check.length-2]++;
			}

			for(int i : check){
				if(i != 0) answer++;
			}
//			System.out.println(Arrays.toString(check));
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5,new int[]{2, 4},new int[]{3}));

	}
}
