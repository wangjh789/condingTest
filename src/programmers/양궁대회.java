package programmers;

import java.util.Arrays;

public class 양궁대회 {
	static class Solution {
		int[] answer;
		int maxDiff;
		public int[] solution(int n, int[] info) {
			answer = new int[11];
			maxDiff =-100;

			dfs(info,new int[11],n,n-1);
			return maxDiff==-100? new int[]{-1}:answer;
		}
		boolean check(int[] arr){
			for(int i =10;i>=0;i--){
				if(answer[i] < arr[i]) return true;
				else if(answer[i] > arr[i]) return false;
			}
			return false;
		}
		void dfs(int[] a,int[] r,int n,int idx){
			if(idx == -1 || n == 0){
				int val = cal(a,r);
				r[10] += n;
				if(val>0 && val >= maxDiff){
					if(val == maxDiff){
						if(check(r)) {
							System.out.println(Arrays.toString(answer)+" "+Arrays.toString(r));
							answer = Arrays.copyOf(r, 11);
						}
					}
					else{
						maxDiff =val;
						answer = Arrays.copyOf(r,11);
					}
				}
				r[10] -= n;
				return;
			}
			if(n >= a[idx]+1){ //화살이 남아있는 경우
				r[idx] = a[idx]+1;
				dfs(a,r,n-(a[idx]+1),idx-1);
			}
			r[idx] = 0;
			dfs(a,r,n,idx-1);
		}
		int cal(int[] a,int[] r){
			int a_val = 0;
			int r_val = 0;
			for(int i=0;i<10;i++){
				if(a[i]==0 && r[i]==0) continue;
				if(a[i] >= r[i]){
					a_val += (10-i);
				}else r_val += (10-i);
			}
			return r_val - a_val;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(9, new int[]
				{0,0,1,2,0,1,1,1,1,1,1})));

	}
}
