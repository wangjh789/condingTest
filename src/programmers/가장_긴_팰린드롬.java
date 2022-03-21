package programmers;

public class 가장_긴_팰린드롬 {
	static class Solution {
		public int solution(String s) {
			if(s.length() == 0) return 0;
			int answer = 0;
			for(int i =0;i<s.length();i++){
				answer = Math.max(getNum(s,i),answer);
				if(i+1<s.length() && s.charAt(i)==s.charAt(i+1))
					answer = Math.max(getNum2(s,i,i+1),answer);
			}
			return answer;
		}
		int getNum(String s,int idx){
			int ans = 1;
			int left = idx-1;
			int right = idx+1;
			while(left>=0 && right<s.length()){
				if(s.charAt(left) != s.charAt(right)) break;
				ans+=2;
				left--;
				right++;
			}
			return ans;
		}
		int getNum2(String s, int left,int right){
			int ans =2;
			left--;
			right++;
			while(left>=0 && right<s.length()){
				if(s.charAt(left) != s.charAt(right)) break;
				ans+=2;
				left--;
				right++;
			}
			return ans;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("abbb"));

	}
}
