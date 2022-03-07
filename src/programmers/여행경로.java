package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 여행경로 {
	static class Solution {
		boolean[] used;
		boolean finish;
		List<String> answer;
		public String[] solution(String[][] tickets) {
			used = new boolean[tickets.length];
			finish = false;
			Arrays.sort(tickets,(o1, o2) -> {
				if(!o1[0].equals(o2[0]))
					return o1[0].compareTo(o2[0]);
				return o1[1].compareTo(o2[1]);
			});
			List<String> tmp = new ArrayList<>();
			tmp.add("ICN");
			dfs(tickets,"ICN",0,tmp);
			return answer.toArray(new String[0]);
		}

		void dfs(String[][] tickets,String cur,int count,List<String> arr){
			if(finish) return;
			if(count == tickets.length){
				answer = new ArrayList<>(arr);
				finish = true;
				return;
			}
			for(int i=0;i< tickets.length;i++){
				if(!used[i] && tickets[i][0].equals(cur)){
					used[i] = true;
					arr.add(tickets[i][1]);
					dfs(tickets,tickets[i][1],count+1,arr);

					arr.remove(arr.size()-1);
					used[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
		System.out.println(Arrays.toString(sol.solution(
				new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));

	}
}
