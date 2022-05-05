package programmers;

import java.util.*;

public class 베스트앨범2 {
    static class Solution {
        class Music{
            int idx;

            @Override
            public String toString() {
                return "Music{" +
                        "idx=" + idx +
                        ", play=" + play +
                        '}';
            }

            int play;

            public Music(int idx, int play) {
                this.idx = idx;
                this.play = play;
            }
        }
        public int[] solution(String[] genres, int[] plays) {
            List<Integer> answer = new ArrayList<>();
            Map<String,Integer> count = new HashMap<>();
            Map<String, PriorityQueue<Music>> musics = new HashMap<>();
            for(int i=0;i< genres.length;i++){
                if(count.containsKey(genres[i])){
                    count.put(genres[i], count.get(genres[i])+plays[i]);
                    musics.get(genres[i]).offer(new Music(i,plays[i]));
                }else{
                    count.put(genres[i],plays[i]);
                    musics.put(genres[i],new PriorityQueue<>((o1, o2) ->{
                        if(o1.play!=o2.play) return o2.play-o1.play;
                        return o1.idx-o2.idx;
                    }));
                    musics.get(genres[i]).offer(new Music(i,plays[i]));
                }
            }
            List<Map.Entry<String,Integer>> list = new ArrayList<>(count.entrySet());
            list.sort((o1, o2) -> o2.getValue()-o1.getValue());
            for(Map.Entry<String,Integer> entry: list){
                String gen = entry.getKey();
                PriorityQueue<Music> que = musics.get(gen);
                int idx = 0;
                while(!que.isEmpty()){
                    if(idx == 2) break;
                    answer.add(que.poll().idx);
                    idx++;
                }
            }
            return answer.stream().mapToInt(i->i).toArray();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                Arrays.toString(sol.solution(
                        new String[]{"classic", "pop", "classic", "classic", "pop"},
                        new int[]{500, 600, 150, 800, 2500}
        )));
    }
}
