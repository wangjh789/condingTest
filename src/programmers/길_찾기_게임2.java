package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 길_찾기_게임2 {
    static class Solution {
        public int[][] solution(int[][] nodeinfo) {
            int[][] answer = new int[2][nodeinfo.length];
            Node[] nodes = new Node[nodeinfo.length];
            for(int i =0;i< nodeinfo.length;i++){
                nodes[i] = new Node(i+1,nodeinfo[i][1],nodeinfo[i][0]);
            }
            Arrays.sort(nodes, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.y != o2.y)
                        return o2.y-o1.y;
                    return o1.x - o2.x;
                }
            });
            Node root = nodes[0];
            for(int i=1;i<nodes.length;i++){
                insertNode(root,nodes[i]);
            }
            List<Integer> pre = new ArrayList<>();
            List<Integer> post = new ArrayList<>();

            printPreOrder(root,pre);
            printPostOrder(root,post);

            for(int i =0;i< pre.size();i++){
                answer[0][i] = pre.get(i);
            }
            for(int i =0;i< post.size();i++){
                answer[1][i] = post.get(i);
            }
            return answer;
        }

        private void printPostOrder(Node node, List<Integer> arr) {
            if(node == null) return;
            printPostOrder(node.left,arr);
            printPostOrder(node.right,arr);
            arr.add(node.idx);

        }

        private void printPreOrder(Node node,List<Integer> arr) {
            if(node ==null) return ;
            arr.add(node.idx);
            printPreOrder(node.left,arr);
            printPreOrder(node.right,arr);
            return ;
        }

        private void insertNode(Node parent, Node child) {
            if(parent.x > child.x){
                if(parent.left == null) parent.left = child;
                else insertNode(parent.left,child);
            }else{
                if(parent.right == null) parent.right = child;
                else insertNode(parent.right,child);
            }
        }

        class Node{
            int idx;
            int y;
            int x;
            Node left;
            Node right;
            Node(int idx,int y,int x){
                this.idx = idx;
                this.y = y;
                this.x = x;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.solution(new int[][]{
                {5, 3},
                {11, 5},
                {13, 3},
                {3, 5},
                {6, 1},
                {1, 3},
                {8, 6},
                {7, 2},
                {2, 2}
        })));
    }
}
