package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 순위_검색2 {
    static class Solution {
        Map<String, PriorityQueue<Integer>> map;
        String[] lang = new String[]{"-","cpp", "java", "python"};
        String[] pos = new String[]{"-","backend","frontend"};
        String[] car = new String[]{"-","junior","senior"};
        String[] food = new String[]{"-","chicken","pizza"};
        public int[] solution(String[] info, String[] query) {
            int[] answer = new int[query.length];
            map = new HashMap<>();
            makeMap(0,"");
            for(String in : info){
                putMap(in.split(" "),"",0);
            }
            for(int k =0;k<query.length;k++){
//                java and backend and junior and pizza 100
                String[] t = query[k].replaceAll(" and","").split(" ");
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<4;i++){
                    sb.append(t[i]);
                    if(i != 3) sb.append(" ");
                }
                int count = 0;
                int score = Integer.parseInt(t[4]);
                if(!map.containsKey(sb.toString())){
                    System.out.println(sb);
                }
                PriorityQueue<Integer> tmp = new PriorityQueue<>((o1, o2) -> o2-o1);
                PriorityQueue<Integer> que = map.get(sb.toString());
                while(!que.isEmpty() && que.peek()>= score){
                    tmp.offer(que.poll());
                    count++;
                }
                que.addAll(tmp);
                tmp = null;
                answer[k] = count;
            }
            return answer;
        }
        private void putMap(String[] token,String st,int depth){
            if(depth == 0){
                putMap(token,"-",depth+1);
                putMap(token,token[depth],depth+1);
            } else if(depth < 4){
                putMap(token,st+" -",depth+1);
                putMap(token,st+" "+token[depth],depth+1);
            }else{
                map.get(st).add(Integer.parseInt(token[depth]));
            }
        }
        private void makeMap(int depth,String st){
            if(depth == 0){
                for(int i =0;i< lang.length;i++){
                    makeMap(depth+1, lang[i]);
                }
            }else if(depth ==1){
                for(int i =0;i< pos.length;i++){
                    makeMap(depth+1, st+" "+pos[i]);
                }
            }else if(depth == 2){
                for(int i =0;i< car.length;i++){
                    makeMap(depth+1, st+" "+car[i]);
                }
            }else{
                for(int i =0;i< food.length;i++){
                    map.put(st+" "+food[i],new PriorityQueue<>(((o1, o2) -> o2-o1)));
                }
            }
        }

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(
                new String[]{
                        "java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"},
                new String[]{
                        "java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"}
        )));
    }
}
