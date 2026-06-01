import java.awt.*;
import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        for(int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(bf.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] maps = new char[H][W];
            Point cur = new Point();
            char dir = 'v';
            for(int i = 0; i < H; i++) {
                String str = bf.readLine();
                for(int j = 0; j < W; j++) {
                    maps[i][j] = str.charAt(j);
                    if(maps[i][j] == 'v' || maps[i][j] == '<' || maps[i][j] == '>' || maps[i][j] == '^'){
                        cur = new Point(i, j);
                        dir = maps[i][j];
                    }
                }
            }

            int N = Integer.parseInt(bf.readLine());
            String str = bf.readLine();
            for(int i = 0; i < N; i++) {
                char op = str.charAt(i);
                if(op == 'U') {
                    dir = '^';
                    maps[cur.x][cur.y] = '^';
                    if(isInMap(cur.x-1, cur.y, H, W) && maps[cur.x-1][cur.y] == '.') {
                        maps[cur.x][cur.y] = '.';
                        cur.x -= 1;
                        maps[cur.x][cur.y] = '^';
                    }
                } else if(op == 'D') {
                    dir = 'v';
                    maps[cur.x][cur.y] = 'v';
                    if(isInMap(cur.x+1, cur.y, H, W) && maps[cur.x+1][cur.y] == '.') {
                        maps[cur.x][cur.y] = '.';
                        cur.x += 1;
                        maps[cur.x][cur.y] = 'v';
                    }
                } else if(op == 'L') {
                    dir = '<';
                    maps[cur.x][cur.y] = '<';
                    if(isInMap(cur.x, cur.y-1, H, W) && maps[cur.x][cur.y-1] == '.') {
                        maps[cur.x][cur.y] = '.';
                        cur.y -= 1;
                        maps[cur.x][cur.y] = '<';
                    }                    
                } else if(op == 'R') {
                    dir = '>';
                    maps[cur.x][cur.y] = '>';
                    if(isInMap(cur.x, cur.y+1, H, W) && maps[cur.x][cur.y+1] == '.') {
                        maps[cur.x][cur.y] = '.';
                        cur.y += 1;
                        maps[cur.x][cur.y] = '>';
                    }
                } else if(op == 'S') {
                    Point shell = new Point(cur.x, cur.y);
                    Point way = new Point();
                    switch (dir) {
                        case '^':
                            way = new Point(-1,0);
                            break;
                        case 'v':
                            way = new Point(1,0);
                            break;
                        case '<':
                            way = new Point(0,-1);
                            break;
                        case '>':
                            way = new Point(0,1);
                            break;
                    }
                    while (true) { 
                        if((shell.x >= H || shell.x < 0 || shell.y >= W || shell.y < 0 ) || maps[shell.x][shell.y] == '#') {
                            break;
                        }
                        if(maps[shell.x][shell.y] == '*') {
                            maps[shell.x][shell.y] = '.';
                            break;
                        }
                        shell.x += way.x;
                        shell.y += way.y;
                    }
                }
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    sb.append(maps[i][j]);
                }
                if(i < H-1) sb.append("\n");
            }
            System.out.println(sb);
        }
    }

    static boolean isInMap(int x, int y, int H, int W) {
        if(x < 0 || x >= H || y < 0 || y >= W) return false;
        return true;
    }
}
