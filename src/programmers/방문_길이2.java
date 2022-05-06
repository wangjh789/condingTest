package programmers;

public class 방문_길이2 {
    static class Solution {
        int[] dy = new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        int LEN = 11;
//        'U', 'D', 'R', 'L'
        public int solution(String dirs) {
            int answer = 0;
            boolean[][][] visited = new boolean[LEN][LEN][4];// 상하좌우
            int y = 5;
            int x = 5;
            for(char dir : dirs.toCharArray()){
                int ny = y;
                int nx = x;
                if(dir == 'U'){
                    ny++;
                    if(valid(ny,nx)){
                        if(!visited[y][x][0]){
                            answer++;
                            visited[y][x][0] = true;
                        }
                        visited[ny][nx][1] = true;
                        y = ny;
                        x = nx;
                    }
                }else if(dir == 'D'){
                    ny--;
                    if(valid(ny,nx)){
                        if(!visited[y][x][1]){
                            answer++;
                            visited[y][x][1] = true;
                        }
                        visited[ny][nx][0] = true;
                        y = ny;
                        x = nx;
                    }
                }else if(dir == 'L'){
                    nx--;
                    if(valid(ny,nx)){
                        if(!visited[y][x][2]){
                            answer++;
                            visited[y][x][2] = true;
                        }
                        visited[ny][nx][3] = true;
                        y = ny;
                        x = nx;
                    }
                }else{
                    nx ++;
                    if(valid(ny,nx)){
                        if(!visited[y][x][3]){
                            answer++;
                            visited[y][x][3] = true;
                        }
                        visited[ny][nx][2] = true;
                        y = ny;
                        x = nx;
                    }
                }
            }
            return answer;
        }
        private boolean valid(int y,int x){
            return !(y >= LEN || y<0 || x>= LEN || x <0);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("LULLLLLLU"));
    }
}
