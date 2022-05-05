package programmers;

import java.util.*;

public class 카드_짝_맞추기2 {
    static class Solution {
        int N = 4;
        int[] dy = new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        List<List<Integer>> orders = new ArrayList<>();
        List<Integer> type;
        public int solution(int[][] board, int r, int c) {
            int answer = Integer.MAX_VALUE;
            Set<Integer> set = new HashSet<>();
            for(int i =0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(board[i][j] != 0) set.add(board[i][j]);
                }
            }
            type = new ArrayList<>(set);
            getOrders(new boolean[type.size()],new ArrayList<>());
            for(List<Integer> order : orders){ //찾아야되는 순서대로
//                System.out.println("순서 : "+order);
                int[][] copy = new int[N][N];
                for(int i =0;i<N;i++){
                    for(int j=0;j<N;j++){
                        copy[i][j] = board[i][j];
                    }
                }
                int[] cur = new int[]{r,c};
                int move = 0;
                Queue<Integer> queue = new LinkedList<>(order);
                while(!queue.isEmpty()){
                    int target = queue.poll(); //타켓
                    move+= searchTarget(copy,target,cur); //첫번째 카드 찾음
                    move++; //엔터
//                    System.out.println("첫번째 카드 : "+target+" /"+cur[0]+" "+cur[1]+" / move: "+move);
                    copy[cur[0]][cur[1]] = 0;
                    move+= searchTarget(copy,target,cur); //두번쨰 카드 찾음
                    move++; //엔터
//                    System.out.println("두번째 카드 : "+target+" /"+cur[0]+" "+cur[1]+" / move: "+move);
                    copy[cur[0]][cur[1]] = 0;
//                    System.out.println("---------");
                }
                answer = Math.min(answer,move);
//                System.out.println("순서 : "+order+" total move : "+move);
//                System.out.println("-------------------");
            }
            return answer;
        }

        private int searchTarget(int[][] board, int target, int[] pos) {
            Queue<Step> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            visited[pos[0]][pos[1]] = true;
            queue.offer(new Step(pos[0],pos[1],0));
            while(!queue.isEmpty()){
                Step cur = queue.poll();
                if(board[cur.y][cur.x]==target){
                    pos[0] = cur.y;
                    pos[1] = cur.x;
                    return cur.count;
                }
                for(int i =0;i<4;i++){ //그냥 움직일때
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if(ny >= N || nx >= N || ny <0 || nx < 0) continue; //범위 밖
                    if(visited[ny][nx]) continue; //이미 방문
                    visited[ny][nx] = true;
                    queue.offer(new Step(ny,nx,cur.count+1));
                }
                for(int i=0;i<4;i++){ //쉬프트 이동
                    int[] next = checkRoute(board,cur.y,cur.x,i);
                    int ny = next[0];
                    int nx = next[1];
                    if(ny >= N || nx >= N || ny <0 || nx < 0) continue; //범위 밖
                    if(visited[ny][nx]) continue;
                    if(cur.y == ny && cur.x == nx) continue;
                    visited[ny][nx] = true;
                    queue.offer(new Step(ny,nx,cur.count+1));
                }
            }
            return 0;
        }

        private int[] checkRoute(int[][] board, int y, int x, int dir) {
            y += dy[dir];
            x += dx[dir];
            while(y>=0 && y<=3 && x>=0 && x<=3){
                if(board[y][x] != 0) return new int[]{y,x}; //카드가 있으면
                y+= dy[dir];
                x+= dx[dir];
            }
            return new int[]{y-dy[dir],x-dx[dir]};
        }

        private void getOrders(boolean[] used,List<Integer> arr) {
            if(arr.size() == type.size()){
                orders.add(new ArrayList<>(arr));
                return;
            }
            for(int i =0;i< type.size();i++){
                if(!used[i]){
                    used[i] = true;
                    arr.add(type.get(i));
                    getOrders(used,arr);
                    arr.remove(arr.size()-1);
                    used[i] = false;
                }
            }
        }

        class Step{
            int y;
            int x;
            int count;
            Step(int y, int x, int count) {
                this.y = y;
                this.x = x;
                this.count = count;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{
                {1,0,0,3},
                {2,0,0,0},
                {0,0,0,2},
                {3,0,1,0}
        },1,0));
    }
}
