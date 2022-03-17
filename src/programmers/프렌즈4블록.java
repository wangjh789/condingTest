package programmers;

import java.util.*;

public class 프렌즈4블록 {
	static class Solution {
		public int solution(int m, int n, String[] board) {
			int answer = 0;
			char[][] chars = new char[m][n];
			for(int i =0;i<m;i++){
				chars[i] = board[i].toCharArray();
			}
			while(true){
				Set<List<Integer>> remove = new HashSet<>();
				for(int i=0;i<m-1;i++){
					for(int j=0;j<n-1;j++){
						if(chars[i][j] == '.') continue;
						Set<List<Integer>> temp = new HashSet<>();
						char target = chars[i][j];
						boolean flag = true;

						for(int a= i;a<i+2;a++){
							for(int b = j;b<j+2;b++){
								List<Integer> tmp = new ArrayList<>();
								if(target != chars[a][b]){
									flag = false;
									break;
								}
								tmp.add(a);
								tmp.add(b);
								temp.add(tmp);
							}
							if(!flag)break;
						}
						if (flag)remove.addAll(temp);
					}
				}
				if(remove.isEmpty()) break;

				for(List<Integer> r : remove){
					chars[r.get(0)][r.get(1)] = '.';
					answer++;
				}
				for(int j =0;j<n;j++){
					Stack<Character> st = new Stack<>();
					for(int i =0;i<m;i++){
						if(chars[i][j] == '.') continue;
						st.push(chars[i][j]);
					}
					for(int i =m-1;i>=0;i--){
						if(!st.isEmpty()) chars[i][j] = st.pop();
						else chars[i][j] = '.';
					}
				}
//				for(char[] line : chars){
//					System.out.println(Arrays.toString(line));
//				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(6,6,new String[]{
				"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"
		}));

	}
}
