package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크_컨트롤러2 {
    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            Arrays.sort(jobs,(o1, o2) -> {
                if(o1[0]!=o2[0]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            });
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
            int idx = 0;
            int time = 0;
            while(idx < jobs.length){
                if(queue.isEmpty()){ //대기중인 일이 없을때
                    time = jobs[idx][0];
                }else{
                    int[] target = queue.poll();
                    time+= target[1];
                    answer += time-target[0];
                }
                while(idx < jobs.length && time >= jobs[idx][0]){
                    queue.offer(jobs[idx++]);
                }
            }
            while(!queue.isEmpty()){
                int[] target = queue.poll();
                time+= target[1];
                answer += time-target[0];
            }
            return answer/ jobs.length;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{
                {0, 3}, {1, 9}, {2, 6}
        }));
    }
}
