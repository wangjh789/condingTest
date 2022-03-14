package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 튜플 {
	static class Solution {
		public int[] solution(String s) {
			List<Integer> answer = new ArrayList<>();
			List<List<Integer>> list = new ArrayList<>();
			int idx = 1;
			while(idx < s.length()-1){
				if(s.charAt(idx) == '{'){
					int tmp = ++idx;
					while(s.charAt(idx) != '}'){
						idx++;
					}
					List<Integer> t = new ArrayList<>();
					for(String st : s.substring(tmp,idx).split(",")){
						t.add(Integer.parseInt(st));
					}
					list.add(t);
				}
				idx++;
			}
			list.sort((o1, o2) -> o1.size() - o2.size());
			for(List<Integer> l : list){
				for(int i=0;i<l.size();i++){
					if(!answer.contains(l.get(i))) {
						answer.add(l.get(i));break;
					}
				}
			}
			return answer.stream().mapToInt(i->i).toArray();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));

	}
}
