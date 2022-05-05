package programmers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 수식_최대화2 {
    static class Solution {
        List<Long> nums;
        List<Character> opers;
        List<char[]> orders;
        public long solution(String expression) {
            long answer = 0;
            orders = new ArrayList<>();
            nums = new ArrayList<>();
            opers = new ArrayList<>();
            getNumsAndOper(expression,nums,opers);
            dfsOper(orders,new char[]{'-','*','+'},new boolean[3],new char[3],0);
            for(char[] order : orders){ //
                List<Long> tNums = new ArrayList<>(nums);
                List<Character> tOpers = new ArrayList<>(opers);
                for(char or : order){
                    int idx = 0 ;
                    while(idx < tOpers.size()){
                        if(or == tOpers.get(idx)){
                            tNums.set(idx,cal(tNums.get(idx),tNums.get(idx+1),or));
                            tNums.remove(idx+1);
                            tOpers.remove(idx);
                        }else idx++;
                    }
                }
                answer = Math.max(answer,Math.abs(tNums.get(0)));
            }

            return answer;
        }
        private Long cal(Long a,Long b,char oper){
            if(oper == '+') return a+b;
            else if(oper =='-') return a-b;
            else return a*b;
        }

        private void dfsOper(List<char[]> orders,char[] std,boolean[] visited,char[] order,int idx){
            if(idx == 3){
                orders.add(Arrays.copyOf(order,3));
                return;
            }
            for(int i =0;i<3;i++){
                if(!visited[i]){
                    visited[i] = true;
                    order[idx] = std[i];
                    dfsOper(orders,std,visited,order,idx+1);
                    visited[i] = false;
                }
            }
        }

        private void getNumsAndOper(
                String expression,List<Long> nums,List<Character> opers){
            int ex = 0;
            int idx = 0;
            while(idx < expression.length()){
                if(!Character.isDigit(expression.charAt(idx))){ //숫자가 아니면
                    nums.add(Long.parseLong(expression.substring(ex,idx)));
                    opers.add(expression.charAt(idx));
                    ex = idx +1;
                }
                idx++;
            }
            nums.add(Long.parseLong(expression.substring(ex,idx)));

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("50*6-3*2"));
    }
}
