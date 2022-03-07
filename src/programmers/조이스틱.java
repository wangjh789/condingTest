package programmers;

import java.util.Arrays;

public class 조이스틱 {
	static class Solution {
		int answer;
		public int solution(String name) {
			answer = Integer.MAX_VALUE;
			char[] a = new char[name.length()];
			Arrays.fill(a,'A');
			getAnswer(name,a,0,1,0);

			return answer;
		}
		void  getAnswer(String name,char[] chars,int idx,int level,int count){
			count += getMinChange(name.charAt(idx)); //현재 idx 에서 최소 움직여 target 에 맞춤
			chars[idx] = name.charAt(idx); // 최신화 해줌

			if(String.valueOf(chars).equals(name)){ //한번씩 다 돌았다면
				answer = Math.min(answer,count);
				return ;
			}
			int[] left = getLeftMove(name,chars,idx);
			int[] right = getRightMove(name, chars, idx);
			getAnswer(name,Arrays.copyOf(chars,chars.length),left[1],level+1,count+left[0]);
			getAnswer(name,Arrays.copyOf(chars,chars.length),right[1],level+1,count+right[0]);
		}
		int getMinChange(char target){
			return Math.min(target-'A', 'Z'-target+1);
		}
		int[] getRightMove(String name,char[] chars,int idx){ //왼쪽으로 얼마나 움직여야 하는지
			idx = idx+1 >= chars.length?0:idx+1;
			int count = 1;
			while(chars[idx] == name.charAt(idx)){
				idx = idx+1 >= chars.length?0:idx+1;
				count++;
			}
			return new int[]{count,idx};
		}
		int[] getLeftMove(String name,char[] chars,int idx){ //오른쪽으로 얼마나 움직여야 하는지
			idx = idx-1 < 0?chars.length-1:idx-1;
			int count = 1;
			while(chars[idx] == name.charAt(idx)){
				idx = idx-1 < 0?chars.length-1:idx-1;
				count++;
			}
			return new int[]{count,idx};
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("JEROEN"));

	}
}
