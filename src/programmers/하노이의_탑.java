package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의_탑 {
	static class Solution {
		List<int[]> ans;
		public int[][] solution(int n) {
			ans = new ArrayList<>();
			int[][] answer = {};
			move(1,3,n);
//			for(int[] a : ans) System.out.println(Arrays.toString(a));
			return ans.toArray(new int[0][]);
		}
		void move(int cur,int target,int n){
			if(n == 1){
				ans.add(new int[]{cur,target});
			}else{
				int tmp = 0;
				for(int i=1;i<4;i++)
					if(i != cur && i!= target){
						tmp = i; break;
					}
				move(cur,tmp,n-1);
				ans.add(new int[]{cur,target});
				move(tmp,target,n-1);
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.deepToString(sol.solution(3)));

	}
}
