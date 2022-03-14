package programmers;

import java.util.*;

public class 리틀_프렌즈_사천성 {
	static class Solution {
		public String solution(int m, int n, String[] board) {
			StringBuilder answer = new StringBuilder();
			Map<Character,List<int []>> targetMap = new HashMap<>();
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					char cur = board[i].charAt(j);
					if(Character.isAlphabetic(cur)){
						if(!targetMap.containsKey(cur)) targetMap.put(cur,new ArrayList<>());
						targetMap.get(cur).add(new int[]{i,j});
					}
				}
			}
			List<Map.Entry<Character,List<int[]>>> entries = new ArrayList<>(targetMap.entrySet());
			entries.sort((o1, o2) -> o1.getKey()-o2.getKey());
			List<Character> ans = new ArrayList<>();

//			for(Map.Entry<Character,List<int[]>> entry : entries){
//				System.out.println(entry.getKey()+" "+ Arrays.toString(entry.getValue().get(0))
//				+" "+Arrays.toString(entry.getValue().get(1)));
//			}
			while(!entries.isEmpty()){
				List<Character> tmp = new ArrayList<>(); //해당 루프내에서 없어진 블록들
				for(int idx=0;idx<entries.size();idx++){
					Map.Entry<Character,List<int[]>> entry = entries.get(idx); //지우려고 시도하는 블럭

					int[] cur = entry.getValue().get(0);
					int[] target = entry.getValue().get(1);
					if(canMove(board,cur[0],cur[1],target[0],target[1])){
						tmp.add(board[cur[0]].charAt(cur[1]));
						board[cur[0]] = board[cur[0]].replace(board[cur[0]].charAt(cur[1]),'.');
						board[target[0]] = board[target[0]].replace(board[target[0]].charAt(target[1]),'.');
						entries.remove(idx--);
					}
				}
				if(tmp.isEmpty()) break;
				tmp.sort((o1, o2) -> o1-o2);
				ans.addAll(tmp);
			}
//			for(String t : board){
//				System.out.println(t);
//			}
			if(!entries.isEmpty()){
				return "IMPOSSIBLE";
			}
			for(char t : ans){
				answer.append(t);
			}
			return answer.toString();
		}
		boolean canMove(String[] board,int y1,int x1,int y2,int x2){
			boolean res = true;
			int bY = Math.max(y1,y2);
			int sY = Math.min(y1,y2);
			int bX = Math.max(x1,x2);
			int sX = Math.min(x1,x2);
			char target = board[y1].charAt(x1);

			for(int y = sY;y<=bY;y++){ //y를 먼저 이동하는 경우
				char cur = board[y].charAt(x1);
				if(cur != '.' && cur != target){
					res = false;
					break;
				}
			}
			if(res){ // y를 성공적으로 이동했으면 x를 마저 이동함
				for(int x=sX;x<=bX;x++){
					char cur = board[y2].charAt(x);
					if(cur != '.' && cur != target){
						res = false;
						break;
					}
				}
				if(res) return true; //계속 바뀌지 않고 true일 경우 가능
			}else{ // y를 먼저 이동한 경우가 막혀, x를 먼저 이동
				res = true;
				for(int x = sX;x<=bX;x++){
					char cur = board[y1].charAt(x);
					if(cur != '.' && cur != target){
						res = false;
						break;
					}
				}
				if(!res) return false; //이것조차 막히면 false
				for(int y = sY;y<=bY;y++){ // x를 성공적으로 이동했으면 y를 마저 이동
					char cur = board[y].charAt(x2);
					if(cur != '.' && cur != target){
						res = false;
						break;
					}
				}
			}
			return res;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(10,10,new String[]{
				"M...M...DU", "....AR...R", "...E..OH.H", ".....O....", ".E..A..Q..", "Q....LL.*.", ".D.N.....U", "GT.T...F..", "....FKS...", "GN....K..S"}));

	}
}
