package programmers;

public class N으로_표햔2 {
    static class Solution {
        int answer;
        public int solution(int N, int number) {
            answer = 9;
            dfs(N,number,0,0);

            return answer>8?-1:answer;
        }
        private void dfs(int N,int number,int depth,int current){
            if(depth > 8) return;
            if(number == current){
                answer = Math.min(answer,depth);
                return;
            }
            int tmp = 0;
            for(int i =0;i<8;i++){
                if(i+depth <8){
                    tmp = tmp*10+N;
                    dfs(N, number, depth+i+1, current+tmp);
                    dfs(N, number, depth+i+1, current-tmp);
                    dfs(N, number, depth+i+1, current/tmp);
                    dfs(N, number, depth+i+1, current*tmp);
                }

            }
        }

        public static void main(String[] args) {
            Solution sol = new Solution();
            System.out.println(sol.solution(5,12));
        }
    }

}
