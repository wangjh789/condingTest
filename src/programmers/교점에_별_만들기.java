package programmers;

import java.util.*;

public class 교점에_별_만들기 {
	static class Solution {
		public String[] solution(int[][] line) {
			List<String> answer = new ArrayList<>();
			int minX = Integer.MAX_VALUE;
			int maxX = Integer.MIN_VALUE;
			int minY = Integer.MAX_VALUE;
			int maxY = Integer.MIN_VALUE;
			Set<int[]> set = new HashSet<>();
			for(int i =0;i< line.length;i++){
				for(int j =i+1;j<line.length;j++){
					int[] a = line[i];
					int[] b = line[j];
					if(a[0]*b[1] - a[1]*b[0] == 0) continue;
					float x = (float)(a[1]*b[2] - a[2]*b[1])/(a[0]*b[1] - a[1]*b[0]);
					float y = (float)(a[2]*b[0] - a[0]*b[2])/(a[0]*b[1] - a[1]*b[0]);
					if(x-(int)x == 0 && y-(int)y==0){
						maxX = Math.max(maxX,(int)x);
						minX = Math.min(minX,(int)x);
						maxY = Math.max(maxY,(int)y);
						minY = Math.min(minY,(int)y);

						set.add(new int[]{(int)y,(int)x});
					}
				}
			}
			char[][] ans = new char[maxY - minY+1][maxX - minX+1];
			for(char[] a : ans) Arrays.fill(a,'.');
//			for(int[] s :set){
//				System.out.println(Arrays.toString(s));
//			}
//			System.out.println(minX+" "+maxX+" "+minY+" "+maxY);
			for(int[] t : set){
				t[1] += (maxX - minX +1)/2 ;
				t[0]  = Math.abs(t[0]-(maxY-minY + 1)/2);
			}

			for(int[] s :set){
				ans[s[0]][s[1]] = '*';
			}
			for(char[] a :ans){
				answer.add(String.valueOf(a));
			}

			return answer.stream().map(i->i).toArray(String[]::new);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1, -1, 0}, {2, -1, 0}
//		{1, -1, 0}, {2, -1, 0}, {4, -1, 0}
//		{0, 1, -1}, {1, 0, -1}, {1, 0, 1}
//		{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
		System.out.println(Arrays.toString(sol.solution(new int[][]{
				{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
		})));

	}
}
