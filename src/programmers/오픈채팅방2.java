package programmers;

import java.util.*;

public class 오픈채팅방2 {
    static class Solution {
        public String[] solution(String[] record) {
            List<String> answer = new ArrayList<>();
            Map<String, String> uidMap = new HashMap<>();
            for(String rec : record){
                String[] arr = rec.split(" ");
                if(arr[0].equals( "Enter") || arr[0].equals("Change")){
                    uidMap.put(arr[1],arr[2]);
                }
            }
            for(String rec : record){
                String[] arr = rec.split(" ");
                if(arr[0].equals( "Enter")){
                    String tmp = uidMap.get(arr[1])+"님이 들어왔습니다.";
                    answer.add(tmp);
                }else if(arr[0].equals("Leave")){
                    String tmp = uidMap.get(arr[1])+"님이 나갔습니다.";
                    answer.add(tmp);
                }
            }
            return answer.toArray(String[]::new);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        })));
    }
}
