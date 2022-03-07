package programmers;

public class 단어_변환 {
	static class Solution {
		int answer;
		boolean[] visited;
		public int solution(String begin, String target, String[] words) {
			answer = Integer.MAX_VALUE;
			visited = new boolean[words.length];
			if(!hasTarget(words, target)) return 0;
			dfs(words,target,begin,0);

			return answer;
		}
		boolean compareString(String a,String b){ //1개만 다른지 판단
			if(a.length() != b.length()) return false;
			int count = 0;
			for(int i=0;i<a.length();i++){
				if(a.charAt(i) != b.charAt(i)) count++;
				if(count>1) return false;
			}
			return true;
		}
		void dfs(String[] words,String target,String cur,int count){
			if(cur.equals(target)){
				answer = Math.min(answer,count);
				return;
			}
			for(int i=0;i< words.length;i++){
				if(!visited[i] && compareString(words[i],cur)){
					visited[i] = true;
					dfs(words, target, words[i], count+1);

					visited[i] = false;
				}
			}
		}
		boolean hasTarget(String[] words,String target){
			for(String word:words) if(word.equals(target)) return true;
			return false;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("hit","cog",
				new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));

	}
}
