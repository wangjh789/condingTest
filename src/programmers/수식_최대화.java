package programmers;

import java.util.*;

public class 수식_최대화 {
	static class Solution {
		long answer;
		List<List<Character>> orders;
		public long solution(String expression) {
			answer = 0;
			orders = new ArrayList<>();
			List<Long> nums = new ArrayList<>();
			List<Character> cals = new ArrayList<>();
			int idx = 0;
			while(idx < expression.length()){
				int tmp = idx;
				while(idx < expression.length() && Character.isDigit(expression.charAt(idx))){
					idx++;
				}
				nums.add(Long.parseLong(expression.substring(tmp,idx)));
				if(idx < expression.length()){
					cals.add(expression.charAt(idx));
				}
				idx++;
			}
			Set<Character> set = new HashSet<>(cals);
			boolean[] used = new boolean[set.size()];
			culOrder(new ArrayList<>(set),used,new ArrayList<>());

			for(List<Character> order : orders){
				Queue<Character> que = new LinkedList<>(order);
				List<Long> numsCopy = new ArrayList<>(nums);
				List<Character> calsCopy = new ArrayList<>(cals);
				while(!que.isEmpty()){
					char target = que.poll();
					for(int i=0;i<calsCopy.size();i++){
						if(calsCopy.get(i) == target){
							if(target == '*'){
								numsCopy.set(i,numsCopy.get(i)*numsCopy.get(i+1));
							}else if(target == '+'){
								numsCopy.set(i,numsCopy.get(i)+numsCopy.get(i+1));
							}else{
								numsCopy.set(i,numsCopy.get(i)-numsCopy.get(i+1));
							}
							calsCopy.remove(i);
							numsCopy.remove(i+1);
							i--;
						}
					}
				}
				answer = Math.max(answer,Math.abs(numsCopy.get(0)));
			}
			return answer;
		}
		void culOrder(List<Character> set,boolean[] used,List<Character> order){
			if(set.size() == order.size()){ //order 대로 하면 됨
				orders.add(new ArrayList<>(order));
				return;
			}
			for(int i=0;i<set.size();i++){
				if(!used[i]){
					used[i] = true;
					order.add(set.get(i));
					culOrder(set,used,order);

					used[i] =false;
					order.remove(order.size()-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("50*6-3*2"));

	}
}
