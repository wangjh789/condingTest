package programmers;

import java.util.Arrays;
import java.util.Stack;

public class 표_편집 {
	static class Solution {
		boolean[] live;
		int count;
		public String solution(int n, int k, String[] cmd) {
			StringBuilder answer = new StringBuilder();
			live = new boolean[n]; //삭제된 행
			count = n;
			int step = 0;
			Arrays.fill(live,true);
			Stack<Integer> st = new Stack<>(); //undo 를 위한 st
			for(String c : cmd){
				String[] comm = c.split(" ");
				if(comm[0].equals("U")){
					step -= Integer.parseInt(comm[1]);
//					k = moveUp(k,Integer.parseInt(comm[1]));
				}else if(comm[0].equals("D")){
					step += Integer.parseInt(comm[1]);
//					k = moveDown(k,Integer.parseInt(comm[1]));
				}else if(comm[0].equals("C")){ //삭제
					if(step > 0){
						k = moveDown(k,step);
					}else{
						k = moveUp(k,step*-1);
					}
					step = 0;

					count--;
					st.push(k);
					live[k] = false;
					if(moveDown(k,1) < k){ //맨 마지막 행을 삭제했을 경우
						k = moveUp(k,1);
					}else{
						k = moveDown(k,1);
					}
				}else{ //undo
					if(step > 0){
						k = moveDown(k,step);
					}else{
						k = moveUp(k,step*-1);
					}
					step = 0;

					count++;
					int revive = st.pop();
					live[revive] = true;
				}
			}
			for(boolean t : live){
				answer.append(t?'O':'X');
			}

			return answer.toString();
		}
		int moveUp(int idx,int step){
			step %= count;
			while(step != 0){
				step--;
				idx--;
				if(idx < 0) idx = live.length-1; //맨 위에 있을 경우
				while(!live[idx]){ //해당 인덱스가 이미 삭제된 경우
					idx--;
					if(idx < 0) idx = live.length-1; //맨 위에 있을 경우
				}
			}
			return idx;
		}
		int moveDown(int idx,int step){
			step %= count;
			while(step != 0){
				step--;
				idx++;
				if(idx == live.length) idx = 0; //맨 위에 있을 경우
				while(!live[idx]){ //이동한 인덱스가 이미 삭제된 경우
					idx++;
					if(idx == live.length) idx = 0; //맨 위에 있을 경우
				}
			}
			return idx;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(8,2,
				new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));

	}
}
