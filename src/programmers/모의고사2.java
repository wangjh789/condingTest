package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사2 {
    static class Solution {
        class Stu{
            int idx;
            int score;

            public Stu(int idx, int score) {
                this.idx = idx;
                this.score = score;
            }

            @Override
            public String toString() {
                return "Stu{" +
                        "idx=" + idx +
                        ", score=" + score +
                        '}';
            }
        }
        public int[] solution(int[] answers) {
            List<Integer> answer = new ArrayList<>();
            Stu[] stus = new Stu[3];
            for(int i =0;i<stus.length;i++)
                stus[i] = new Stu(i+1,0);

            int[] pattern1 = new int[]{1, 2, 3, 4, 5};
            int[] pattern2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
            int[] pattern3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            for(int i=0;i<answers.length;i++){
                if(pattern1[i%pattern1.length] == answers[i]) stus[0].score++;
                if(pattern2[i%pattern2.length] == answers[i]) stus[1].score++;
                if(pattern3[i%pattern3.length] == answers[i]) stus[2].score++;
            }
            Arrays.sort(stus,(o1, o2) -> o2.score-o1.score);
            int max = stus[0].score;
            for(int i =0;i< stus.length;i++){
                if(stus[i].score == max) answer.add(stus[i].idx);
                else break;
            }
            return answer.stream().mapToInt(i->i).toArray();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 3, 2, 4, 2})));
    }
}
