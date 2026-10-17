import java.util.*;
class Solution {
    
    private static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        
        List<Point> points = new ArrayList<>();
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        int n = line.length;
        
        
        for(int i = 0; i < n; i++) {
            
            long a1 = line[i][0];
            long b1 = line[i][1];
            long c1 = line[i][2];
            
            for(int j = i + 1; j < n; j++) {
                
                long a2 = line[j][0];
                long b2 = line[j][1];
                long c2 = line[j][2];
                
                long denominator = a1 * b2 - a2 * b1;
                
                if (denominator == 0) continue;
                
                long xN = b1 * c2 - b2 * c1;
                long yN = c1 * a2 - c2 * a1;
                
                if (xN % denominator != 0 || yN % denominator != 0) continue;
                
                long x = xN / denominator;
                long y = yN / denominator;
                
                points.add(new Point(x, y));
                
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
            
        }
        
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        
        char[][] map = new char[height][width];
        
        for(char[] row: map) {
            Arrays.fill(row, '.');
        }
        
        // 별 찍기
        for(Point p: points) {
            int nx = (int) (p.x - minX);
            int ny = (int) (maxY - p.y);
            map[ny][nx] = '*';
        }
        
        String[] answer = new String[height];
        for(int i = 0; i < height; i++) {
            answer[i] = new String(map[i]);
        }
        
        
        return answer;
    }
}