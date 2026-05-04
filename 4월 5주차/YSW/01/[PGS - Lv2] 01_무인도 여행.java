import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[] answer;
        int N  = maps.length;
        int M  = maps[0].length();
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] || maps[i].charAt(j) == 'X') continue;
                
                queue.add(new int[] {i, j});
                visited[i][j] = true;
                int food = maps[i].charAt(j) - '0';
                while(!queue.isEmpty()){
                    int[] current = queue.poll();
                    int row = current[0];
                    int col = current[1];
                    
                    for(int k = 0; k < 4; k++){
                        int newRow = row + directions[k][0];
                        int newCol = col + directions[k][1];
                        
                        if(newRow >= 0 && newRow < N && newCol >= 0 && newCol < M && !visited[newRow][newCol] && maps[newRow].charAt(newCol) != 'X'){
                            food += maps[newRow].charAt(newCol) - '0';
                            queue.add(new int[] {newRow, newCol});
                            visited[newRow][newCol] = true;
                        }
                    }
                }
                
                list.add(food);
            }
        }
        if(list.isEmpty()){
           return new int[] {-1}; 
        }
        
        Collections.sort(list);
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}