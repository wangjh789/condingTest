package programmers;

import java.util.Arrays;

public class 쿼드압축_후_개수_세기2 {
    static class Solution {
        public int[] solution(int[][] arr) {
            int[] answer = {};
            int len = arr.length;
            int[] result = count(arr,len,0,0,new int[2]);
            System.out.println(Arrays.toString(result));

            return answer;
        }
        private int[] count(int[][] arr,int len,int y,int x,int[] result){
            if(check(arr,len,y,x)){
                return arr[y][x] == 0 ?
                        new int[]{result[0]+1,result[1]}:new int[]{result[0],result[1]+1};
            }else{
                int nextLen = len/2;
                int[] a =  count(arr,nextLen,y,x,result);
                int[] b= count(arr,nextLen,y,x+nextLen,result);
                int[] c = count(arr,nextLen,y+nextLen,x,result);
                int[] d = count(arr,nextLen,y+nextLen,x+nextLen,result);
                return new int[]{a[0]+b[0]+c[0]+d[0],a[1]+b[1]+c[1]+d[1]};
            }
        }
        private boolean check(int[][] arr,int len,int y,int x){
            int t = arr[y][x];
            for(int i=y;i<y+len;i++){
                for(int j=x;j<x+len;j++){
                    if(arr[i][j] != t) return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[][]{
                {1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}
        })));
    }
}
