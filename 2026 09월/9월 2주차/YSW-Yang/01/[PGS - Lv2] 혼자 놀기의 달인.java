class Solution {
    public boolean[] visited;
    
    public int solution(int[] cards) {
        int answer = 0;
        int N = cards.length;
        visited = new boolean[N + 1];
        int max1 = 0;
        int max2 = 0;
        
        for(int i = 1; i <= N; i++){
            if(visited[i]){
                continue;
            }
            int size = dfs(i, cards);
            
            if(size > max1){
                max2 = max1;
                max1 = size;
            }else if(size > max2){
                max2 = size;
            }
        }
        
        return max1 * max2;
    }
    
    public int dfs(int start, int[] cards){
        if(visited[start]){
            return 0;
        }
        visited[start] = true;
        return 1 + dfs(cards[start - 1], cards);
    }
}
