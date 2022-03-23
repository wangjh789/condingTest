package programmers;

public class k진수에서_소수_개수_구하기 {
	static class Solution {
		public int solution(int n, int k) {
			int answer = 0;
			String target = Integer.toString(n,k);
			int idx = 0;
			while(idx < target.length()){
				int base = idx;
				idx = target.indexOf("0",base+1);
				if(idx == -1){ //더이상 0이 없음
					if(isPrime(Long.parseLong(target.substring(base)))) answer++;
					break;
				}else{
					if(isPrime(Long.parseLong(target.substring(base,idx)))) answer++;
				}
				while(idx < target.length() && target.charAt(idx) =='0'){
					idx++;
				}
			}
			return answer;
		}
		boolean isPrime(long n){
			if(n <= 1) return false;
			for(long i =2;i<=(long)Math.sqrt(n);i++){
				if(n%i==0) return false;
			}
			return  true;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(524287,2));

	}
}
