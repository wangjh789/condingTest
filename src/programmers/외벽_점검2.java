package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 외벽_점검2 {
    static class Solution {
        List<int[]> orders = new ArrayList<>();
        public int solution(int n, int[] weak, int[] dist) {
            int answer = Integer.MAX_VALUE;
            dfs(dist,new boolean[dist.length],new int[dist.length],0);
            for(int idx =0;idx<weak.length;idx++){
                Queue<Integer> weakList = new LinkedList<>();
                for(int i =idx;i<weak.length;i++){
                    weakList.add(weak[i]);
                }
                for(int i=0;i<idx;i++){
                    weakList.add(n+weak[i]);
                }
                for(int[] order : orders){
                    Queue<Integer> queue = new LinkedList<>(weakList);
                    int num = 0;
                    while(num < order.length){
                        int range = queue.peek() + order[num];
                        while(!queue.isEmpty() && range >= queue.peek()){
//                        System.out.println(range+" "+queue.peek());
                            queue.poll();
                        }
                        if(queue.isEmpty()) {
                            answer = Math.min(answer,num+1);
                            break;
                        }
                        num++;
                    }
                }
//                System.out.println("-----------------------"+(num+1));
            }
            return answer==Integer.MAX_VALUE?-1:answer;
        }
        private void dfs(int[] dist,boolean[] used,int[] arr,int idx){
            if(idx== dist.length){
                orders.add(Arrays.copyOf(arr,arr.length));
                return;
            }
            for(int i =0;i< dist.length;i++){
                if(!used[i]){
                    used[i] = true;
                    arr[idx] = dist[i];
                    dfs(dist, used, arr, idx+1);
                    used[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(12,new int[]{10,12},new int[]{1,2}));
    }
}
