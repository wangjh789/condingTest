package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호_목록2 {
    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            Arrays.sort(phone_book);
            for(int i =1;i< phone_book.length;i++){
                if(phone_book[i].startsWith(phone_book[i-1])) return false;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"12","123","1235","567","88"}));
    }
}
