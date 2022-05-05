package programmers;

import java.util.Arrays;

public class 단어_변환2 {
    static class Solution {
        int answer = Integer.MAX_VALUE;
        public int solution(String begin, String target, String[] words) {
            boolean[] visited = new boolean[words.length];
            boolean initFlag = false;
            for (String word : words) {
                if (word.equals(target)) {
                    initFlag = true;
                    break;
                }
            }
            if(!initFlag) return 0;
            dfs(words,0,visited,begin,target);

            return answer;
        }
        private void dfs(String[] word,int depth,boolean[] visited,String cur,String target){
            if(depth == word.length-1) return;
            if(cur.equals(target)) {
                answer = Math.min(depth,answer);
                return;
            }
            for(int i=0;i< word.length;i++){
                if(!visited[i] && canChange(cur,word[i])){
                    visited[i] = true;
                    dfs(word, depth+1, visited, word[i], target);
                    visited[i] = false;
                }
            }
        }
        private boolean canChange(String cur,String target){
            int idx = 0;
            int count = 0;
            while(idx < cur.length()){
                if(cur.charAt(idx) != target.charAt(idx)) count++;
                if(count >1) return false;
                idx++;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("hit","cog",new String[]{
                "hot", "dot", "dog", "lot", "log", "cog"
        }));
    }
}
