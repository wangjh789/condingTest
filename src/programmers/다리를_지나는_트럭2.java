package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭2 {
    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0;i<bridge_length;i++) queue.offer(0);
            int totalC = 0;
            int totalW = 0;
            int idx = 0;
            while(idx < truck_weights.length){
                int tmp = queue.poll();
                if(tmp != 0) {
                    totalC--;
                    totalW-=tmp;
                }
                if(totalW + truck_weights[idx] <= weight && totalC < bridge_length){
                    totalC++;
                    totalW+= truck_weights[idx];
                    queue.offer(truck_weights[idx]);
                    idx++;
                }else{
                    queue.offer(0);
                }
                answer++;
            }
            answer+= bridge_length;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2,10,new int[]{7,4,5,6}));
    }
}
