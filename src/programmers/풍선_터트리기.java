package programmers;

import java.util.Arrays;

public class 풍선_터트리기 {
	static class Solution {
		public int solution(int[] a) {
			int answer = 0;
			int[] leftMemo = new int[a.length];
			int[] rightMemo = new int[a.length];
			leftMemo[0] = a[0];
			rightMemo[a.length-1] = a[a.length-1];
			for(int i=1;i<a.length;i++){
				leftMemo[i] = Math.min(leftMemo[i-1],a[i] );
			}
			for(int i=rightMemo.length-2;i>=0;i--){
				rightMemo[i] = Math.min(rightMemo[i+1],a[i]);
			}
			for(int i =0;i<a.length;i++){
				boolean leftMin =false;
				boolean rightMin = false;
				if(i > 0 && leftMemo[i-1] < a[i]) leftMin = true;
				if(i <a.length-1 && rightMemo[i+1] < a[i]) rightMin = true;
				if(!(leftMin && rightMin)) answer++;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}));

	}
}
