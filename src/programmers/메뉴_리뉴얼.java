package programmers;

import java.util.*;

public class 메뉴_리뉴얼 {
	static class Solution {
		public String[] solution(String[] orders, int[] course) {
			List<String> answer = new ArrayList<>();

			for(int count : course){
				Map<String,Integer> map = new HashMap<>();
				for(String order : orders){
					char[] chars = order.toCharArray();
					Arrays.sort(chars);
					getCount(String.valueOf(chars),count,0,new StringBuilder(),map);
				}
				List<Map.Entry<String,Integer>> entries = new ArrayList<>(map.entrySet());
				if(entries.size() == 0) continue;
				entries.sort((o1, o2) -> o2.getValue() - o1.getValue());
				int max = entries.get(0).getValue();
				if(max == 1) continue;
				for(Map.Entry<String,Integer> entry : entries){
					if(entry.getValue() != max) break;
					answer.add(entry.getKey());
				}
			}
			answer.sort((o1, o2) -> o1.compareTo(o2));
			return answer.stream().toArray(String[]::new);
		}
		void getCount(String order, int count,int idx,StringBuilder sb,Map<String,Integer> map){
			if(sb.length() == count){
				map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
				return;
			}
			for(int i =idx;i<order.length();i++){
				sb.append(order.charAt(i));
				getCount(order,count,i+1,sb,map);
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(
				new String[]{"XYZ", "XWY", "WXA"},
				new int[]{2,3,4}
		)));

	}
}
