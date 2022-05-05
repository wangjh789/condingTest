package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class 이중우선순위큐2 {
    static class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(String oper : operations){
                System.out.println(oper+" "+queue);
                String[] word = oper.split(" ");
                if(word[0].equals("I")) queue.offer(Integer.parseInt(word[1]));
                else if(word[0].equals("D") && queue.size()>0){
                   if(word[1].equals("-1")) //최솟값
                       queue.poll();
                   else{ //최댓값 삭제
                       Stack<Integer> st = new Stack<>();
                       while(queue.size()>1) st.push(queue.poll());
                       queue.poll();
                       while(!st.isEmpty()) queue.offer(st.pop());
                   }
                }
            }
            if(!queue.isEmpty()){
                Stack<Integer> st = new Stack<>();
                while(queue.size()>1) st.push(queue.poll());
                int max = queue.peek();
                while(!st.isEmpty()) queue.offer(st.pop());
                answer[0] = max;
                answer[1] = queue.peek();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(
                sol.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
    }
}
