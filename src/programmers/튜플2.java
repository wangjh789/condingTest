package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 튜플2 {
    static class Solution {
        public int[] solution(String s) {
            List<Integer> answer = new ArrayList<>();
            String[] arr = s.split("},\\{");
            arr[0] = arr[0].replace("{{","");
            arr[arr.length-1] = arr[arr.length-1].replace("}}","");
            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length()-o2.length();
                }
            });
            List<String[]> strings = Arrays.stream(arr).map(i -> i.split(",")).toList();
//            strings.sort((a,b)->a.length-b.length);
            for(String[] str : strings){
                for(String value : str){
                    if(!answer.contains(Integer.valueOf(value))){
                        answer.add(Integer.valueOf(value));
                        break;
                    }
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                Arrays.toString(
                        sol.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
    }

}
