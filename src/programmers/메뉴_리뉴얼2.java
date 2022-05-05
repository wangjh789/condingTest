package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴_리뉴얼2 {
    static class Solution {
        public String[] solution(String[] orders, int[] course) {
            List<String> answer = new ArrayList<>();
            Map<String,Integer>[] menus = new Map[course.length];
            for(int i =0;i<course.length;i++){
                menus[i] = new HashMap<>();
                for(String order : orders){
                    dfs(order,course[i],0,new ArrayList<>(),menus[i]);
                }
                List<Map.Entry<String,Integer>> array = new ArrayList<>(menus[i].entrySet());
                array.sort((a,b)->b.getValue()-a.getValue());
                if(!array.isEmpty()){
                    int len = array.get(0).getValue();
                    for (Map.Entry<String, Integer> stringIntegerEntry : array) {
                        if (stringIntegerEntry.getValue() == len) answer.add(stringIntegerEntry.getKey());
                        else break;
                    }
                }
            }
            answer.sort(String::compareTo);
            return answer.toArray(String[]::new);
        }

        private void dfs(String order, int size,int idx, List<Character> arr,Map<String,Integer> map){
            if(arr.size() == size){
                String tmp = arr.stream().map(String::valueOf).collect(Collectors.joining());
                System.out.println(arr);
                map.put(tmp,map.getOrDefault(tmp,0)+1);
                return;
            }
            for(int i =idx;i<order.length();i++){
                arr.add(order.charAt(i));
                dfs(order,size,i+1,arr,map);
                arr.remove(arr.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(
                new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                new int[]{2, 3, 4})));
    }
}
