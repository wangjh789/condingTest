package programmers;

import java.util.*;

public class 압축 {
	static class Solution {
		public int[] solution(String msg) {
			List<Integer> answer = new ArrayList<>();
			Map<String,Integer> dict = new HashMap<>();
			for(int i = 0;i<26;i++){
				int t = 'A'+i;
				dict.put(String.valueOf((char)t),i+1);
			}
			int dictIdx = 27;
			int idx = 0;
			while(idx < msg.length()){
				StringBuilder sb = new StringBuilder(String.valueOf(msg.charAt(idx)));
				while(idx+1 < msg.length() && dict.containsKey(sb.toString())){
					idx++;
					sb.append(msg.charAt(idx));
				}
				if(idx == msg.length()-1){
					System.out.println(sb);
					if(dict.containsKey(sb.toString())){
						answer.add(dict.get(sb.substring(0,sb.length())));
					}else{
						answer.add(dict.get(sb.substring(0,sb.length()-1)));
						dict.put(sb.toString(),dictIdx);
						answer.add(dict.get(sb.charAt(sb.length()-1)+""));
					}
					break;
				}
				answer.add(dict.get(sb.substring(0,sb.length()-1)));
				dict.put(sb.toString(),dictIdx++);
			}
			return answer.stream().mapToInt(i->i).toArray();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution("KAKAO")));

	}
}
