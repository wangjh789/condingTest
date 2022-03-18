package programmers;

import java.util.*;

public class 길_찾기_게임 {
	static class Solution {
		class Node{
			int x;
			int y;
			int num;
			Node left;
			Node right;
			Node(int num,int y,int x){
				this.num = num;
				this.y = y;
				this.x = x;
			}
		}
		public int[][] solution(int[][] nodeinfo) {
			int[][] answer = new int[2][];
			Node[] nodes = new Node[nodeinfo.length];
			for(int i =0;i< nodeinfo.length;i++){
				int y = nodeinfo[i][1];
				int x = nodeinfo[i][0];
				nodes[i] = new Node(i+1,y,x);
			}
			Arrays.sort(nodes,(o1, o2) -> {
				if(o1.y != o2.y ) return o2.y - o1.y;
				return o1.x - o2.x;
			});
			Node root = nodes[0];
			for(int i =1;i< nodes.length;i++){
				insertNode(root,nodes[i]);
			}
			List<Integer> pre = new ArrayList<>();
			List<Integer> post = new ArrayList<>();
			preOrder(root,pre);
			postOrder(root,post);
			answer[0] = pre.stream().mapToInt(i->i).toArray();
			answer[1] = post.stream().mapToInt(i->i).toArray();

			return answer;
		}

		void insertNode(Node parent,Node child){
			if(parent.x > child.x){
				if(parent.left == null) parent.left = child;
				else insertNode(parent.left,child);
			}else{
				if(parent.right == null) parent.right = child;
				else insertNode(parent.right, child);
			}
		}
		void preOrder(Node node,List<Integer> arr){
			if(node == null) return;
			arr.add(node.num);
			preOrder(node.left,arr);
			preOrder(node.right,arr);
		}
		void postOrder(Node node,List<Integer> arr){
			if(node == null) return;
			postOrder(node.left,arr);
			postOrder(node.right,arr);
			arr.add(node.num);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}
		System.out.println(Arrays.deepToString(sol.solution(new int[][]{
				{5, 3},
				{11, 5},
				{13, 3},
				{3, 5},
				{6, 1},
				{1, 3},
				{8, 6},
				{7, 2},
				{2, 2}}
		)));

	}
}
