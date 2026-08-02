class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int currentX = 5;;
        int currentY = 5;
        
        for(char dir: dirs.toCharArray()){
            int nextX = currentX;
            int nextY = currentY;
            int d = 0;
            if(dir == 'U'){
                d = 0;
                nextY++;
            }else if(dir == 'D'){
                d = 2;
                nextY--;
            }else if(dir == 'R'){
                d = 1;
                nextX++;
            }else{
                d = 3;
                nextX--;
            }
            if(nextX < 0||nextX>10||nextY<0||nextY>10)continue;
            if(!visited[currentX][currentY][d]){
                visited[currentX][currentY][d] = true;
                visited[nextX][nextY][(d+2)%4] = true;
                answer++;
            }
            currentX = nextX;
            currentY = nextY;
        }
        return answer;
    }
}