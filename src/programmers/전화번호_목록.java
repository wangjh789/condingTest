package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호_목록 {
	static class Solution {
		public boolean solution(String[] phone_book) {
			boolean answer = true;
			Arrays.sort(phone_book);
			for(int i=0;i< phone_book.length-1;i++){
				if(phone_book[i+1].startsWith(phone_book[i]))return false;
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new String[]{"119", "97674223", "1195524421"}));

	}
}
