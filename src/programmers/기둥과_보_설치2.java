package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 기둥과_보_설치2 {
    static class Solution {
        boolean[][][] board;
        public int[][] solution(int n, int[][] build_frame) {
            List<int[]> answer = new ArrayList<>();
            board = new boolean[n+1][n+1][2]; //0: 기둥, 1:보

            for(int[] cmd : build_frame){
                int x = cmd[0];
                int y = cmd[1];
                int type = cmd[2];
                int order = cmd[3];
                if(order == 1){ //설치
                    if(type == 0){ //기둥
                        if(checkGid(y,x)){
                            board[y][x][0] = true;
//                            System.out.println("기둥 설치 성공"+" "+ Arrays.toString(cmd));
                        }
//                        else System.out.println("기둥 설치 실패"+" "+ Arrays.toString(cmd));
                    }else{ //보
                        if(checkBo(n,y,x)){
                            board[y][x][1] = true;
//                            System.out.println("보 설치 성공"+" "+ Arrays.toString(cmd));
                        }
//                        else System.out.println("보 설치 실패"+" "+ Arrays.toString(cmd));
                    }
                }else{// 삭제
                    if(type == 0){ // 기둥
                        board[y][x][0] = false;
                        if(!checkAll(n)) {
                            board[y][x][0] = true;
//                            System.out.println("기둥 삭제 실패"+" "+ Arrays.toString(cmd));
                        }
//                        else System.out.println("기둥 삭제 성공"+" "+ Arrays.toString(cmd));
                    }else{ //보
                        board[y][x][1] = false;
                        if(!checkAll(n)) {
                            board[y][x][1] = true;
//                            System.out.println("보 삭제 실패"+" "+ Arrays.toString(cmd));
                        }
//                        else System.out.println("보 삭제 성공"+" "+ Arrays.toString(cmd));
                    }
                }
            }
            for(int i =0;i<=n;i++){
                for(int j=0;j<=n;j++){
                    if(board[i][j][0]) answer.add(new int[]{j,i,0});
                    if(board[i][j][1]) answer.add(new int[]{j,i,1});
                }
            }
            answer.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] != o2[0])
                        return o1[0]-o2[0];
                    else if(o1[1] != o2[1])
                        return o1[1]-o2[1];
                    else return o1[2]-o2[2];
                }
            });
            return answer.toArray(new int[0][]);
        }
        boolean checkAll(int n){
            for(int i =0;i <n+1;i++){
                for(int j=0;j<n+1;j++){
                    if(board[i][j][0] && !checkGid(i,j)) return false; //기둥 체크
                    if(board[i][j][1] && !checkBo(n,i,j)) {
                        return false; //보 체크
                    }
                }
            }
            return true;
        }

        boolean checkBo(int n,int y,int x){
            if(y == 0) return false; //바닥에 설치할 수 없음
            if(board[y-1][x][0] || (x+1<=n && board[y-1][x+1][0])) return true; //내 위치 or 오른쪽에 기둥이 있을때
            if((x-1>=0 && board[y][x-1][1]) && ( x+1<=n && board[y][x+1][1])) return true; //양옆으로 보가 이어져있을땨
            return false;
        }

        boolean checkGid(int y,int x){
            if(y == 0) return true; //바닥에 설치 가능
            if((x >0 && board[y][x-1][1]) || board[y][x][1]) return true; //오른쪽 or 내위치에 보가 있을경우
            if(board[y-1][x][0]) return true; //아래에 기둥이 있을 경우
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.solution(5, new int[][]{
//                {1, 0, 0, 1},
//                {1, 1, 1, 1},
//                {2, 1, 0, 1},
//                {2, 2, 1, 1},
//                {5, 0, 0, 1},
//                {5, 1, 0, 1},
//                {4, 2, 1, 1},
//                {3, 2, 1, 1}
                {0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}
        })));
    }
}
