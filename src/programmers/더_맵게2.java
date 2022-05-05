package programmers;

import java.util.PriorityQueue;

public class 더_맵게2 {
    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int sco : scoville) queue.offer(sco);
            while(queue.peek() < K){
                if(queue.size() < 2) return -1;
                answer++;
                int a = queue.poll();
                int b = queue.poll();
                queue.offer(a+b*2);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 3, 9, 10, 12},7));
    }
}
