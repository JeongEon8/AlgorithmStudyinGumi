class Solution {
    
    int[][] dungeons;
    int k;
    boolean[] check;
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        check = new boolean[dungeons.length];
        this.dungeons = dungeons;
        this.k = k;
        
        dfs(0);
        return max;
    }
    
    public void dfs(int depth){
        if(depth>max){max = depth;}
        
        for(int i = 0; i<dungeons.length; i++){
            if(check[i]){
                continue;
            }
            int need = dungeons[i][0];
            int send = dungeons[i][1];
            if(need<=k){
                k-=send;
                check[i]=true;
                dfs(depth+1);
                check[i]=false;
                k+=send;
            }
        }
    }
}
