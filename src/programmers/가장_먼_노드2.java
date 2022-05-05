package programmers;

import java.util.*;

public class 가장_먼_노드2 {
    static class Solution {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            int[] dist = new int[n];
            Map<Integer, List<Integer>> map = new HashMap<>();
            boolean[] visited = new boolean[n];
            int max = 0;
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[0] = 0;
            visited[0] = true;
            for(int i =0;i<n;i++) map.put(i,new ArrayList<>());
            for(int[] ed:edge){
                map.get(ed[0]-1).add(ed[1]-1);
                map.get(ed[1]-1).add(ed[0]-1);
            }
            Queue<Integer> que = new LinkedList<>();
            que.offer(0);
            while(!que.isEmpty()){
                int cur = que.poll();
                for(int i =0;i<map.get(cur).size();i++){
                    int next = map.get(cur).get(i);
                    if(!visited[next]) {
                        visited[next] = true;
                        dist[next] = dist[cur]+1;
                        max = Math.max(dist[next],max);
                        que.offer(next);
                    }
                }
            }
            for(int d : dist) if(max == d)answer++;

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(6,
                new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
