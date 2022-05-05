package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 파일명_정렬2 {
    static class Solution {
        public String[] solution(String[] files) {
            List<File> list = new ArrayList<>();
            for(String file : files) list.add(process(file));
            list.sort((o1, o2) -> {
                int com = o1.head.compareToIgnoreCase(o2.head);
                if(com != 0) return com;
                return o1.num-o2.num;
            });

            return list.stream().map(i->i.origin).toArray(String[]::new);
        }
        class File{
            String origin;
            String head;
            int num;
            public File(String origin, String head, int num) {
                this.origin = origin;
                this.head = head;
                this.num = num;
            }
        }
        private File process(String file){
            int idx = 0;
            String head = null;
            int numIdx = 0;
            while(idx < file.length()){
                if(head == null){ //일단 head를 찾아야함
                    if(Character.isDigit(file.charAt(idx))){ //숫자 시작
                        head = file.substring(0,idx);
                        numIdx = idx;
                    }
                }else{ //num 차례
                    if(!Character.isDigit(file.charAt(idx))){
                        break;
                    }
                }
                idx++;
            }
            int num = Integer.parseInt(file.substring(numIdx,idx));
            return new File(file,head,num);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{
                "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
        })));
    }
}
