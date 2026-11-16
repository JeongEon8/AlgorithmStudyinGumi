import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int x = routes.length;
        int m = routes[0].length;
        
        List<int[]>[] robotPath = new ArrayList[x];
        HashMap<String, Integer> pathMap = new HashMap<>();
        for(int i = 0; i < x; i++){
            robotPath[i] = new ArrayList<>();
            robotPath[i].add(points[routes[i][0] - 1]);
        }
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < m - 1; j++){
                int curR = points[routes[i][j] - 1][0];
                int curC = points[routes[i][j] - 1][1];
                int goalR = points[routes[i][j + 1] - 1][0];
                int goalC = points[routes[i][j + 1] - 1][1];
                
                while(curR != goalR || curC != goalC){
                    if(curR != goalR){
                        if(curR < goalR){
                            curR++;
                        }else{
                            curR--;
                        }
                    }else if(curC != goalC){
                        if(curC < goalC){
                            curC++;
                        }else{
                            curC--;
                        }
                    }
                    robotPath[i].add(new int[] {curR, curC});
                }
            }
        }
        
        for(int i = 0; i < x; i++){
            for(int j = 0; j < robotPath[i].size(); j++){
                int time = j;
                int r = robotPath[i].get(j)[0];
                int c = robotPath[i].get(j)[1];
                String path = time + ", " + r + ", "+ c;
                pathMap.put(path, pathMap.getOrDefault(path, 0) + 1);
            }
        }
        
        for(int count : pathMap.values()){
            if(count > 1){
                answer++;
            }
        }
        
        return answer;
    }
}
