package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 나_잡아_봐라 {

	static class Solution{
		class Pos{
			int c;
			int b;
			int time;
			Pos(int c,int s,int time){
				this.c = c;
				this.b =s ;
				this.time = time;
			}
		}
		public int solution(int c,int b){ //C, C + 1, C + 3, C + 6,   B – 1, B + 1, 2 * B
			Queue<Pos> que = new LinkedList<>();
			que.offer(new Pos(c,b,0));
			while(!que.isEmpty()){
				Pos cur = que.poll();

				if(cur.b == cur.c){
					return cur.time;
				}else if(cur.time > 200_000){
					return -1;
				}
				if(cur.b > 0){
					que.offer(new Pos(cur.c+cur.time+1,cur.b-1,cur.time+1));
				}
				if(cur.b-1 <= 200_000){
					que.offer(new Pos(cur.c+cur.time+1,cur.b+1,cur.time+1));
				}
				if(cur.b * 2 <= 200_000){
					que.offer(new Pos(cur.c+cur.time+1,cur.b*2,cur.time+1));
				}
			}
			return -1;
		}

		public static void main(String[] args) {
			Solution sol = new Solution();
			System.out.println(sol.solution(11,2));

		}
	}
}
