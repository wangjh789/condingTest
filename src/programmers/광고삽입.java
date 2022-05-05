package programmers;

public class 광고삽입 {
    static class Solution {
        public String solution(String play_time, String adv_time, String[] logs) {
            String answer = "";
            int total = timeToInt(play_time);
            int advLen = timeToInt(adv_time);
            int[] arr = new int[total];
            for(String log : logs){
                String[] split = log.split("-");
                int start = timeToInt(split[0]);
                int end = timeToInt(split[1]);
                for(int i = start;i<end;i++){
                    arr[i]++;
                }
            }
            int minLeft = 0;
            long sum = 0;
            int left = 0;
            int right = advLen;
            for(int i =left;i<right;i++){
                sum += arr[i];
            }
            long temp = sum;
            while(right < arr.length){
                temp += arr[right++];
                temp -= arr[left++];
                if(temp > sum){
                    minLeft = left;
                    sum = temp;
                }
            }

            return intToTime(minLeft);
        }

        private int timeToInt(String time){
            String[] word = time.split(":");
            return Integer.parseInt(word[0])*60*60 +
                    Integer.parseInt(word[1])*60 +
                    Integer.parseInt(word[2]);
        }
        private String intToTime(int tInt){
            String hour = tInt/(60*60)<10?'0'+String.valueOf(+tInt/(60*60)):String.valueOf(tInt/(60*60));
            tInt %= 60*60;
            String min = tInt/(60)<10?'0'+String.valueOf(tInt/(60)):String.valueOf(tInt/(60));
            String sec = tInt%(60)<10?'0'+String.valueOf(tInt%(60)):String.valueOf(tInt%(60));
            return hour+":"+min+":"+sec;

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
                "99:59:59",
                "25:00:00",
                new String[]{
                        "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"
        }));
    }
}
