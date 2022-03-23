package programmers;

import java.util.*;

public class 주차_요금_계산 {
	static class Solution {
		class Car{
			String num;
			int fee;
			Car(String num, int fee){
				this.fee = fee;
				this.num = num;
			}
		}
		static int baseMin;
		static int baseFee;
		static int overMin;
		static int overFee;
		public int[] solution(int[] fees, String[] records) {
			baseMin = fees[0];
			baseFee = fees[1];
			overMin = fees[2];
			overFee = fees[3];
			Map<String, List<Integer>> map = new HashMap<>();
			for(String record : records){
				String[] str = record.split(" ");
				if(!map.containsKey(str[1])) map.put(str[1],new ArrayList<>());
				map.get(str[1]).add(timeToInt(str[0]));
			}
			List<Car> cars = new ArrayList<>();
			for(Map.Entry<String,List<Integer>> entry : map.entrySet()){
				System.out.println(entry);
				int time = 0;
				if(entry.getValue().size()%2 ==1){
					entry.getValue().add(timeToInt("23:59"));
				}

				int fee = calList(entry.getValue());
				cars.add(new Car(entry.getKey(),fee));
			}
			cars.sort((o1, o2) -> o1.num.compareTo(o2.num));
			int[] answer = new int[cars.size()];
			for(int i =0;i< cars.size();i++){
				answer[i] = cars.get(i).fee;
			}

			return answer;
		}
		int calList(List<Integer> list){
			int total = 0;
			for(int i =0;i<list.size();i++){
				total += list.get(i+1)-list.get(i);
				i++;
			}
			return calFee(total);
		}
		int calFee(int time){
			int fee = baseFee;
			if(time > baseMin){ //초과 했을때
				fee += Math.ceil((double)(time-baseMin)/overMin)*overFee;
			}
			return fee;
		}

		int timeToInt(String s){
			String[] a = s.split(":");
			return Integer.parseInt(a[0])*60 + Integer.parseInt(a[1]);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(
				new int[]{180, 5000, 10, 600},
				new String[]{
						"05:34 5961 IN",
						"06:00 0000 IN",
						"06:34 0000 OUT",
						"07:59 5961 OUT",
						"07:59 0148 IN",
						"18:59 0000 IN",
						"19:09 0148 OUT",
						"22:59 5961 IN",
						"23:00 5961 OUT"})));

	}
}
