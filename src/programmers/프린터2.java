package programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터2 {
    static class Solution {
        class Task{
            int idx;
            int priority;

            public Task(int idx, int priority) {
                this.idx = idx;
                this.priority = priority;
            }
        }
        public int solution(int[] priorities, int location) {
            int answer = 0;
            PriorityQueue<Integer> order = new PriorityQueue<>((o1, o2) -> o2-o1);
            Queue<Task> queue = new LinkedList<>();
            for(int i =0;i<priorities.length;i++) {
                queue.offer(new Task(i, priorities[i]));
                order.offer(priorities[i]);
            }
            int count = 0;
            while(!queue.isEmpty()){
                while(!order.isEmpty() && !queue.isEmpty() && order.peek() != queue.peek().priority){
                    //뽑아야하는 우선순위 나올때까지 계속 돌림
                    queue.offer(queue.poll());
                }
                count++;
                Task poll = queue.poll();
                order.poll();
                if(poll.idx == location)return count;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{2, 1, 3, 2},2));
    }
}
