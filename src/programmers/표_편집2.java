package programmers;

import java.util.Arrays;
import java.util.Stack;

public class 표_편집2 {
    static class Solution {
        Stack<Node> removed;
        public String solution(int n, int k, String[] cmd) {
            StringBuilder answer = new StringBuilder("O".repeat(n));
            removed = new Stack<>();
            int[] next = new int[n];
            int[] prev = new int[n];
            for(int i =0;i<n;i++) prev[i] = i-1;
            for(int i =0;i<n;i++) next[i] = i+1;
            next[n-1] = -1;

            for(String c : cmd){
                String[] word = c.split(" ");
                if(word[0].equals("U")){
                    int value = Integer.parseInt(word[1]);
                    while(value >0){
                        value --;
                        k = prev[k];
                    }
                }else if(word[0].equals("D")){
                    int value = Integer.parseInt(word[1]);
                    while(value >0){
                        value --;
                        k = next[k];
                    }
                }else if(word[0].equals("C")){
                    removed.push(new Node(prev[k],next[k],k ));
                    if(prev[k] != -1) //맨 첫 노드가 아니면
                        next[prev[k]] = next[k];
                    if(next[k] != -1)
                        prev[next[k]] = prev[k];

                    answer.setCharAt(k,'X');

                    if(next[k] == -1) k = prev[k];
                    else k = next[k];
                }else{ //Z
                    Node node = removed.pop();
                    if(node.prev != -1) next[node.prev] = node.cur;
                    if(node.next != -1) prev[node.next] = node.cur;
                    answer.setCharAt(node.cur,'O');
                }
            }
            return answer.toString();
        }
        class Node{
            int prev;
            int next;
            int cur;
            Node(int prev,int next,int cur){
                this.prev = prev;
                this.next = next;
                this.cur = cur;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(8,2,new String[]{
                "D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"
        }));
    }
}
