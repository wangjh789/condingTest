package programmers;

import java.util.*;

public class 베스트앨범 {

	static class Solution {
		public int[] solution(String[] genres, int[] plays) {
			Map<String,Integer> gen = new HashMap<>();
			Map<String, Map<Integer,Integer>> map = new HashMap<>();
			for(int i=0;i< genres.length;i++){
				gen.put(genres[i],gen.getOrDefault(genres[i],0)+plays[i]);
				if(!map.containsKey(genres[i])){
					map.put(genres[i],new HashMap<>());
				}
				map.get(genres[i]).put(i,plays[i]);
			}
			List<Map.Entry<String,Integer>> ent = new ArrayList<>(gen.entrySet());
			Collections.sort(ent,(o1, o2) -> o2.getValue()-o1.getValue());
			List<Integer> ans = new ArrayList<>();
			for(Map.Entry<String ,Integer> t : ent){
				List<Map.Entry<Integer,Integer>> tmp = new ArrayList<>(map.get(t.getKey()).entrySet());
				Collections.sort(tmp,((o1, o2) -> o2.getValue()-o1.getValue()));
				int count = Math.min(tmp.size(), 2);
				for(int i=0;i<count;i++){
					ans.add(tmp.get(i).getKey());
				}
			}

			return ans.stream().mapToInt(i->i).toArray();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		"classic", "pop", "classic", "classic", "pop"

//
		System.out.println(Arrays.toString(sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop" },
				new int[]{500, 600, 150, 800, 2500}
		)));

	}
}
