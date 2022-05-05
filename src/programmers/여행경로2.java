package programmers;

import java.util.*;

public class 여행경로2 {
    static class Solution {
        String[] answer;
        public String[] solution(String[][] tickets) {
            answer = null;
            String[] tmp = new String[tickets.length+1];
            String start = "ICN";
            tmp[0] = start;
            dfs(tickets,1,new boolean[tickets.length],start,tmp);


            return answer;
        }
        private void dfs(String[][] tickets,int depth,boolean[] visited,String cur,String[] arr){
            if(depth == visited.length){
                for(int i =0;i<visited.length;i++){
                    if(!visited[i]){
                        if(arr[tickets.length-1].equals(tickets[i][0])){
                            arr[tickets.length] = tickets[i][1];
                            if(answer == null) answer = Arrays.copyOf(arr,arr.length);
                            else {
                                if(compareArray(arr,answer)<0)
                                    answer = Arrays.copyOf(arr,arr.length);
                            }
                            arr[tickets.length] = null;
                        }
                    }
                }
                return;
            }
            for(int i =0;i< tickets.length;i++){
                if(!visited[i]&&tickets[i][0].equals(cur)){
                    visited[i] = true;
                    arr[depth] = tickets[i][1];
                    dfs(tickets, depth+1, visited, tickets[i][1], arr);
                    visited[i] = false;
                }
            }
        }
        private int compareArray(String[] a, String[] b){
            for(int i =0;i<a.length;i++){
                if(!a[i].equals(b[i])){
                    return a[i].compareTo(b[i]);
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[][]{
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
        })));
    }
}
