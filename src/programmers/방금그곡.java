package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 방금그곡 {
	static class Solution {
		class Music{
			String title;
			int playTime;
			int startedAt;
			List<String> music;
			Music(String title, int playTime,int startedAt,List<String> music){
				this.title = title;
				this.playTime = playTime;
				this.startedAt = startedAt;
				this.music = music;
			}
		}
		public String solution(String m, String[] musicinfos) {
			String answer = "";
			List<String> list = process(m,-1);
			Music[]  musics = new Music[musicinfos.length];
//			System.out.println(list);

			for(int i =0;i< musicinfos.length;i++){
				String[] t = musicinfos[i].split(",");
				int play = strToInt(t[1])-strToInt(t[0]);
				musics[i] = new Music(t[2],
						play,
						strToInt(t[0]),
						process(t[3],play));
//				System.out.println(musics[i].playTime+" "+musics[i].music);
			}
			Arrays.sort(musics,(o1, o2) ->{
				if(o1.playTime != o2.playTime) return o2.playTime-o1.playTime;
				return o1.startedAt-o2.startedAt;
			});
			for(Music t : musics){
				if(isMatched(t.music,list)) return t.title;
//				if(t.music.containsAll(list)) return t.title;
			}

			return "(None)";
		}
		boolean isMatched(List<String> origin,List<String> target){
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
		int strToInt(String time){
			String[] tmp = time.split(":");
			int hour = Integer.parseInt(tmp[0])*60;
			int min = Integer.parseInt(tmp[1]);
			return hour+min;
		}
		List<String> process(String m,int num){
			List<String> list = new ArrayList<>();
			int idx = 0;
			while(idx < m.length()){ //num만큼만 받음
				if(num != -1 && num == list.size()) break;
				boolean hasShop = false;
				if(idx +1 <m.length() && m.charAt(idx+1)=='#') hasShop =true;
				if(hasShop){
					list.add(m.substring(idx,idx+2));
					idx+=2;
				}else{
					list.add(m.substring(idx,idx+1));
					idx++;
				}
			}
			idx = 0;
			while(num!=-1 && num > list.size()){
				list.add(list.get(idx));
				idx++;
			}
			return list;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("ABC",
				new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));

	}
}
