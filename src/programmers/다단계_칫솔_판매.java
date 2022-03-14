package programmers;

import java.util.*;

public class 다단계_칫솔_판매 {
	static class Solution {
		class Member{
			String parent;
			List<String> children = new ArrayList<>();
			int price = 0;
		}
		public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
			int[] answer = new int[enroll.length];
			Map<String,Member> memberMap = new HashMap<>();
			memberMap.put("-",new Member());
			for(String e : enroll){
				memberMap.put(e,new Member());
			}
			for(int i =0;i< enroll.length;i++){
				memberMap.get(enroll[i]).parent = referral[i];
				memberMap.get(referral[i]).children.add(enroll[i]);
			}
			for(int i =0;i<seller.length;i++){
				int total = amount[i] * 100;
				cal(memberMap,seller[i],total);
			}
//			for(Map.Entry<String,Member> t : memberMap.entrySet()){
//				System.out.println(t.getKey()+" "+t.getValue().price);
//			}
			for(int i=0;i< enroll.length;i++){
				answer[i] = memberMap.get(enroll[i]).price;
			}

			return answer;
		}

		void cal(Map<String,Member> memberMap,String seller,int total){
			if(memberMap.get(seller).parent == null || total < 10){ //부모가 없거나 나눠먹지 못하면
				memberMap.get(seller).price += total;
			}else{
				int parent = total/10;
				memberMap.get(seller).price += (total-parent);
				cal(memberMap,memberMap.get(seller).parent,parent);
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(
				new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
				new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
				new String[]{"young", "john", "tod", "emily", "mary"},
				new int[]{12, 4, 2, 5, 10}
		)));

	}
}
