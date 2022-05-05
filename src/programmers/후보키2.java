package programmers;

import java.util.*;

public class 후보키2 {
    static class Solution {
        boolean[] usable;
        List<List<Integer>> conds;
        public int solution(String[][] relation) {
            int answer = 0;
            usable = new boolean[relation[0].length];
            conds = new ArrayList<>();
            Arrays.fill(usable,true);
            for(int i =1;i<relation[0].length;i++){ //1개 부터
                conds = new ArrayList<>();
                dfs(i,new boolean[relation[0].length],new ArrayList<>(),0);

                for(List<Integer> cond:conds){
                    Set<String> set = new HashSet<>();
                    for(String[] re : relation){
                        StringBuilder sb= new StringBuilder();
                        for(int co : cond){
                            sb.append(re[co]).append(" ");
                        }
                        set.add(sb.toString());
                    }
                    if(set.size() == relation.length){ //결과값이 고유하면
                        System.out.println(cond+" "+set);
                        answer++;
                        for(int co : cond){
                            usable[co] = false;
                        }
                    }
                }
            }
            return answer;
        }
        private void dfs(int count,boolean[] used,List<Integer> arr, int idx){
            if(arr.size() == count){
//                System.out.println(arr);
                conds.add(new ArrayList<>(arr));
                return;
            }
            for(int i =idx;i< usable.length;i++){
                if(usable[i] && !used[i]){
                    used[i] = true;
                    arr.add(i);
                    dfs(count,used,arr,i+1);
                    arr.remove(arr.size()-1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[][]{
                {"100","ryan","music","2"},
                {"200","apeach","math","2"},
                {"300","tube","computer","3"},
                {"400","con","computer","4"},
                {"500","muzi","music","3"},
                {"600","apeach","music","2"}
        }));
    }
}
