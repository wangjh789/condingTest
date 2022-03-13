package programmers;

import java.util.*;

public class 오픈채팅방 {
	static class Solution {
		public String[] solution(String[] record) {
			List<String> answer = new ArrayList<>();
			Map<String,String> user = new HashMap<>();
			for(String rec : record){
				String[] arr = rec.split(" ");
				if(arr[0].equals("Leave")) continue;
				user.put(arr[1],arr[2]);
			}
			for(String rec : record){
				String[] arr = rec.split(" ");
				if(arr[0].equals("Change")) continue;
				StringBuilder sb = new StringBuilder();
				sb.append(user.get(arr[1])).append("님이 ");
				if(arr[0].equals("Enter")) sb.append("들어왔습니다.");
				else if(arr[0].equals("Leave")) sb.append("나갔습니다.");
				answer.add(sb.toString());
			}
			return answer.toArray(new String[0]);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(new String[]{
				"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"
		})));
//		["Prodo님이 들어왔습니다.",
//		"Ryan님이 들어왔습니다.",
//		"Prodo님이 나갔습니다.",
//		"Prodo님이 들어왔습니다."]
	}
}
