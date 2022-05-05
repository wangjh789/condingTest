package programmers;

import java.util.Arrays;

public class 조이스틱2 {
    static class Solution {
        int answer =Integer.MAX_VALUE;
        public int solution(String name) {
            boolean[] visited = new boolean[name.length()];
            int remain = name.length();
            for(int i =0;i<name.length();i++) {
                if(name.charAt(i)=='A'){
                    visited[i] = true;
                    remain--;
                }
            }
            dfs(name,visited,remain,0,0);

            return answer;
        }
        void dfs(String name,boolean[] visited,int remain,int idx,int count){
            if(!visited[idx]){
                count += changeAlpha(name.charAt(idx));
                visited[idx] = true;
                remain--;
            }
            if(remain == 0){
                answer = Math.min(answer,count);
//                System.out.println(Arrays.toString(visited) +" "+count);
                return;
            }
            // 왼쪽으로 이동
            int[] nextLeft = moveLeft(idx,visited);
            dfs(name,Arrays.copyOf(visited,visited.length),remain,nextLeft[0],count+nextLeft[1]);
            //오른쪽으로 이동
            int[] nextRight = moveRight(idx,visited);
            dfs(name,Arrays.copyOf(visited,visited.length),remain,nextRight[0],count+nextRight[1]);

        }

        private int changeAlpha(char target){
            return Math.min(target-'A','Z'-target+1);
        }
        private int[] moveLeft(int idx,boolean[] visited){ //다음 타켓을 왼쪽으로 찾아감
            int count =0;
            while(true){
                count++;
                idx--;
                if(idx<0) idx+=visited.length;
                if(!visited[idx]) return new int[]{idx,count};
            }
        }
        private int[] moveRight(int idx,boolean[] visited){
            int count =0;
            while(true){
                count++;
                idx++;
                if(idx >= visited.length) idx = 0;
                if(!visited[idx]) return new int[]{idx,count};
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("JEROEN"));
    }
}
