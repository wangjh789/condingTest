package programmers;

import java.util.*;

//개발언어는 cpp, java, python 중 하나입니다.
//직군은 backend, frontend 중 하나입니다.
//경력은 junior, senior 중 하나입니다.
//소울푸드는 chicken, pizza 중 하나입니다.
public class 순위_검색 {
	static class Solution {
		public int[] solution(String[] info, String[] query) {
			int[] answer = new int[query.length];
			Set<Integer> person = new HashSet<>();
			String[] langs = new String[]{"cpp","java","python"};
			String[] pos = new String[]{"backend","frontend"};
			String[] cars = new String[]{"junior","senior"};
			String[] foods = new String[]{"chicken","pizza"};
			Map<String, List<Integer>> langMap = new HashMap<>();
			Map<String, List<Integer>> posMap = new HashMap<>();
			Map<String, List<Integer>> foodMap = new HashMap<>();
			Map<String, List<Integer>> carMap = new HashMap<>();
			Map<Integer,List<Integer>> scoreMap = new HashMap<>();
			for(String lang : langs) langMap.put(lang,new ArrayList<>());
			for(String po : pos) posMap.put(po,new ArrayList<>());
			for(String food : foods) foodMap.put(food,new ArrayList<>());
			for(String car : cars) carMap.put(car,new ArrayList<>());

			for(int i=0;i<info.length;i++){
				String[] option = info[i].split(" ");
				langMap.get(option[0]).add(i);
				posMap.get(option[1]).add(i);
				carMap.get(option[2]).add(i);
				foodMap.get(option[3]).add(i);
				if(!scoreMap.containsKey(Integer.valueOf(option[4]))) scoreMap.put(Integer.valueOf(option[4]),new ArrayList<>());
				scoreMap.get(Integer.valueOf(option[4])).add(i);
				person.add(i);
			}
			List<Map.Entry<Integer,List<Integer>>> scores = new ArrayList<>(scoreMap.entrySet());
			scores.sort((o1, o2) -> o1.getKey()-o2.getKey());


			for(int i=0;i< query.length;i++){
				String[] options = query[i].replaceAll("and ","").split(" ");
				Set<Integer> tmp = new HashSet<>(person);
				for(int j=0;j< options.length;j++){
					if(options[j].equals("-")) continue;
					if(j == 0){
						tmp.retainAll(langMap.get(options[0]));
					}else if(j==1){
						tmp.retainAll(posMap.get(options[1]));
					}else if(j==2){
						tmp.retainAll(carMap.get(options[2]));
					}else if(j==3){
						tmp.retainAll(foodMap.get(options[3]));
					}else if(j==4){ //점수
						for(int k=0;k<scores.size();k++){
							if(scores.get(k).getKey() >= Integer.parseInt(options[4])) break;
							tmp.removeAll(scores.get(k).getValue());
						}
					}
				}
				answer[i] = tmp.size();
			}
			return answer;
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
						"python backend senior chicken 50"
				},
				new String[]{
						"java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200",
						"cpp and - and senior and pizza 250",
						"- and backend and senior and - 150",
						"- and - and - and chicken 100",
						"- and - and - and - 150"
				})));

	}
}
