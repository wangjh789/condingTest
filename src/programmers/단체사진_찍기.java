package programmers;

import java.util.ArrayList;
import java.util.List;

public class 단체사진_찍기 {
	static class Solution {
		boolean[] used;
		int answer;
		public int solution(int n, String[] data) {
			answer = 0;
			char[] members = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
			used = new boolean[members.length];
			dfs(members,new StringBuilder(),data);
			return answer;
		}

		void dfs(char[] members, StringBuilder sb,String[] data){
			if(sb.length() == members.length){
				if(check(sb,data)){
					answer++;
				}
				return;
			}
			for(int i=0;i< members.length;i++){
				if(!used[i]){
					used[i] = true;
					sb.append(members[i]);
					dfs(members,sb, data);

					used[i] = false;
					sb.deleteCharAt(sb.length()-1);
				}
			}
		}
		boolean check(StringBuilder sb, String[] data){
			for(String d : data){
				char targetA = d.charAt(0);
				char targetB = d.charAt(2);
				char cond = d.charAt(3);
				int val = Integer.parseInt(d.charAt(4)+"");
				int tmp = Math.abs(sb.indexOf(String.valueOf(targetA)) - sb.indexOf(String.valueOf(targetB)));
//				System.out.println(val + " "+tmp);
				switch (cond){
					case '=' :
						if(val != tmp-1) return false;
						break;
					case '<' :
						 if(val <= tmp-1) return false;
						break;
					case '>' :
						if(val >= tmp-1) return false;
						break;
 				}
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(2,new String[]{"N~F=0", "R~T>2"}));

	}
}
