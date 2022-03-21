package programmers;

import java.util.Arrays;

public class n_2_배열_자르기 {
	static class Solution {
		public int[] solution(int n, long left, long right) {
			int[] answer = new int[(int) (right-left+1)];
			StringBuilder sb = new StringBuilder();
			long startLine =  left/n; //left 라인이 걸려있는
			long endLine = right/n; //right 라인이 걸려있는
			int idx = 0;
			if(startLine == endLine) { //같은 라인에 걸려있을 경우
				for(int i = (int)(left%n); i<= right%n; i++){
					System.out.println("t");
					int value = i+1;
					if(i <= startLine) value = (int) startLine+1;
					answer[idx++] = value;
				}
			}else{
				for(int i = (int)(left%n); i< n; i++){
					int value = i+1;
					if(i <= startLine) value = (int) startLine+1;
					answer[idx++] = value;
				}
				startLine++;
				while(startLine<endLine){
					for(int i = 0; i< n; i++){
						int value = i+1;
						if(i <= startLine) value = (int) startLine+1;
						answer[idx++] = value;
					}
					startLine++;
				}
				for(int i = 0; i<=right%n; i++){
					int value = i+1;
					if(i <= startLine) value = (int) startLine+1;
					answer[idx++] = value;
				}
				// 시작 라인부터
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(4, 0, 7)));

	}
}
