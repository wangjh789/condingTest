package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 파일명_정렬 {
	static class Solution {
		class Item{
			String title;
			String head;
			int num;
			String tail;
			Item(String title,String head,int num,String tail){
				this.title = title;
				this.head = head;
				this.num = num;
				this.tail = tail;
			}
		}
		public String[] solution(String[] files) {
			String[] answer = new String[files.length];
			List<Item> items = new ArrayList<>();
			for(String file : files){
				int numStart = 0;
				while(numStart < file.length() && !Character.isDigit(file.charAt(numStart))){
					numStart++;
				}
				String head = file.substring(0,numStart).toLowerCase();
				int numEnd = numStart;
				while(numEnd < file.length() && Character.isDigit(file.charAt(numEnd))){
					numEnd++;
				}
				int num = Integer.parseInt(file.substring(numStart,numEnd));
				String tail = file.substring(numEnd);
				items.add(new Item(file,head,num,tail));
			}
			items.sort((o1, o2) -> {
				if(!o1.head.equals(o2.head)) return o1.head.compareTo(o2.head);
				return o1.num-o2.num;
			});
			for(int i =0;i< items.size();i++){
				answer[i] = items.get(i).title;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(
				new String[]{
						"A-10 Thunderbolt II",
						"B-50 Superfortress",
						"F-5 Freedom Fighter",
						"F-14 Tomcat"})));

	}
}
