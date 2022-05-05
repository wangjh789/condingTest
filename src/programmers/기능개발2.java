package programmers;

import java.util.*;

public class 기능개발2 {
    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> answer = new ArrayList<>();
            Queue<Integer> que = new LinkedList<>();
            for(int i =0;i<progresses.length;i++){
                int remain = (100-progresses[i])%speeds[i]==0?
                        (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i]+1;
                que.offer(remain);
            }
            while(!que.isEmpty()){
                int day = que.poll();
                int count = 1;
                while(!que.isEmpty() && que.peek()<=day){
                    que.poll();
                    count++;
                }
                answer.add(count);
            }
            return answer.stream().mapToInt(i->i).toArray();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1}
        )));
    }
}
