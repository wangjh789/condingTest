package programmers;

import java.util.*;

public class 모두_0으로_만들기2 {
    static class Solution {
        long answer = 0;
        public long solution(int[] a, int[][] edges) {
            if(Arrays.stream(a).sum() !=0)return -1;
            long[] longA = new long[a.length];
            Map<Integer,List<Integer>> map = new HashMap<>();
            boolean[] clear = new boolean[a.length];
            for(int i =0;i<a.length;i++) {
                longA[i] = a[i];
                map.put(i, new ArrayList<>());
            }
            for(int[] edge : edges){
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }
            while(map.size() >1){
                List<Map.Entry<Integer,List<Integer>>> list = new ArrayList<>(map.entrySet());
                list.sort((o1, o2) -> o1.getValue().size()-o2.getValue().size());
//                System.out.println(list);
                Map.Entry<Integer, List<Integer>> entry = list.get(0);
                int cur = entry.getKey();
                int target = entry.getValue().get(0);
                answer+=Math.abs(longA[cur]);
                longA[target]+=longA[cur];
                longA[cur] = 0;
                for(int node : entry.getValue()){
                    map.get(node).remove(Integer.valueOf(cur));
                }
                map.remove(cur);
                clear[cur] = true;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
                new int[]{-5,0,2,1,2},
                new int[][]{{0,1},{3,4},{2,3},{0,3}}));
    }
}
