package programmers;

import java.util.ArrayList;
import java.util.List;

public class 양과_늑대2 {
    static class Solution {
        int answer = 0;
        class Node{
            int idx;
            int type;
            int left=-1;
            int right=-1;
            public Node(int idx, int type) {
                this.idx = idx;
                this.type = type;
            }
        }
        public int solution(int[] info, int[][] edges) {
            Node[] nodes = new Node[info.length];
            for(int i=0;i<info.length;i++)
                nodes[i] = new Node(i,info[i]);
            for(int[] edge : edges){
                if(nodes[edge[0]].left == -1){
                    nodes[edge[0]].left = edge[1];
                }else nodes[edge[0]].right = edge[1];
            }
            dfs(nodes,0,new ArrayList<>(),0,0);

            return answer;
        }
        void dfs(Node[] nodes,int idx,List<Integer> arr,int s,int w){
            if(nodes[idx].type==0)s++;
            else w++;
            if(s <= w) return;
            answer = Math.max(answer,s);
            if(nodes[idx].left != -1) arr.add(nodes[idx].left);
            if(nodes[idx].right != -1) arr.add(nodes[idx].right);
//            System.out.println(idx+" "+arr+" "+s+" "+w);
            for(int next : arr){
                List<Integer> nextArr = new ArrayList<>(arr);
                nextArr.remove(Integer.valueOf(next));
                dfs(nodes,next,nextArr,s,w);
            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{0,1,0,1,1,0,1,0,0,1,0},
                new int[][]{
                        {0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}
                }));
    }
}
