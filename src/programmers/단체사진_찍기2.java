package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 단체사진_찍기2 {
    static class Solution {
        String[] conds;
        int result;
        public int solution(int n, String[] data) {
            int answer = 0;
            result = 0;
            conds = data;
            char[] chars = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
            dfs(chars,new boolean[8],new char[8],0);
            System.out.println(result);
            return answer;
        }
        private boolean condition(String cond,String arr){
            char a = cond.charAt(0);
            char b = cond.charAt(2);
            char oper = cond.charAt(3);
            int val = cond.charAt(4)-'0';
            int result = Math.abs(arr.indexOf(a)-arr.indexOf(b))-1;
            if(oper == '='){
                return result == val;
            }else if(oper == '>'){
                return result > val;
            }else if(oper == '<'){
                return result < val;
            }
            return false;
        }
        private void dfs(char[] chars, boolean[] used, char[] arr,int idx){
            if(idx == 8){
                for(String cond: conds){
                    if(!condition(cond,String.valueOf(arr))){
                        return;
                    }
                }
                result++;
                return;
            }
            for(int i =0;i<chars.length;i++){
                if(!used[i]){
                    used[i] = true;
                    arr[idx] = chars[i];
                    dfs(chars,used,arr,idx+1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2,new String[]{"N~F=0", "R~T>2"}));
//        System.out.println(sol.solution(2,new String[]{"M~C<2", "C~M>1"}));
    }
}
