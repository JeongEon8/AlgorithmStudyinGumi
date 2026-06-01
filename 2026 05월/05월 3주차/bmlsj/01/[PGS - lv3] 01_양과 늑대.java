import java.util.*;
class Solution {
    
    static int maxSheep;
    static List<Integer>[] tree;
    public int solution(int[] info, int[][] edges) {
        
        maxSheep = -1;
        
        tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // 부모에 자식 추가
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]); 
        }

        dfs(0, 0, 0, tree[0], info);
        
        return maxSheep;
    }
    
    public void dfs(int curNode, int sheep, int wolf, List<Integer> nextNodes, int[] info) {
        
        if (info[curNode] == 0) {
            sheep += 1;
        } else {
            wolf += 1;
        }
        
        // 종료
        if (wolf >= sheep) {
            return;
        }
        
        // 조건 만족
        if (maxSheep < sheep) {
            maxSheep = sheep;
        }
        
        for(int next: nextNodes) {
            
            List<Integer> copy = new ArrayList<>(nextNodes);
            copy.remove(Integer.valueOf(next));

            for(int child: tree[next]) {
                copy.add(child);
            }

            dfs(next, sheep, wolf, copy, info);
            
        }
        
    }
}