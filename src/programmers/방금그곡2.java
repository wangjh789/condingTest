package programmers;

import java.util.ArrayList;
import java.util.List;

public class 방금그곡2 {
    static class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "(None)";
            int maxLen = -1;
            List<String> remem = melToList(m,-1);
            for(String music : musicinfos){
                String[] word = music.split(",");
                int playTime = timeToInt(word[1]) - timeToInt(word[0]);
                List<String> mel = melToList(word[3],playTime);
                int size = mel.size();
                int idx = 0;
                while(mel.size() < playTime){
                    mel.add(mel.get(idx++));
                    idx%=size;
                }
                System.out.println(mel);
                if(compare(remem,mel)) {
                    if(maxLen == -1){
                        answer = word[2];
                        maxLen = playTime;
                    }else{
                        if(playTime > maxLen){
                            answer = word[2];
                            maxLen = playTime;
                        }
                    }
                }
            }
            return answer;
        }
        private boolean compare(List<String> target,List<String> origin){
            int idx = 0;
            while(idx < origin.size()- target.size()+1){
                int t = 0;
                while(t< target.size() && origin.get(idx+t).equals(target.get(t))){
                    t++;
                }
                if(t == target.size()) return true;
                idx++;
            }
            return false;
        }
        private int timeToInt(String time){
            String[] word = time.split(":");
            return Integer.parseInt(word[0])*60 + Integer.parseInt(word[1]);
        }

        private List<String> melToList(String melody,int len){
            List<String> arr = new ArrayList<>();
            int idx = 0;
            while(idx < melody.length()){
                if(idx+1 <melody.length() && melody.charAt(idx+1)=='#'){
                    arr.add(melody.substring(idx,idx+2));
                    idx++;
                }else{
                    arr.add(String.valueOf(melody.charAt(idx)));
                }
                idx++;
                if(len != -1 && arr.size() == len)break;
            }
            return arr;
        }
    }

//    "C", ["13:00,13:01,WORLD,F"]
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("CC#BCC#BCC#BCC#B",new String[]{
                "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"
        }));
    }
}
