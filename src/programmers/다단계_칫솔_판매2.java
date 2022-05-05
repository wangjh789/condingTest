package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매2 {
    static class Solution {
        class Node{
            String parent;
            int amount;

            @Override
            public String toString() {
                return "Node{" +
                        "parent='" + parent + '\'' +
                        ", amount=" + amount +
                        '}';
            }

            public Node(String parent, int amount) {
                this.parent = parent;
                this.amount = amount;
            }
        }
        Map<String,Node> members;
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];
            final int COST = 100;
            members = new HashMap<>();
            members.put("-",new Node(null,0)); //root 노드
            for(int i =0;i< enroll.length;i++) members.put(enroll[i],new Node(referral[i],0));
            for(int i=0;i< seller.length;i++){
                addCost(seller[i],amount[i]*COST);
            }
            for(int i =0;i<enroll.length;i++){
                answer[i] = members.get(enroll[i]).amount;
            }
            return answer;
        }
        private void addCost(String mem,int price){
            Node node = members.get(mem);
            if(node.parent == null) {  //나눌 필요 없음
                node.amount+= price;
            }else{
                int val = price/10;
                if(val < 1){
                    node.amount += price;
                }else{
                    node.amount += price-val;
                    addCost(node.parent,val);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10})));
    }
}
