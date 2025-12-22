import java.io.*;
import java.util.*;

public class Main {
    static int N = 0;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
//    static int[][] smap = new int[1][1];

    public static void main(String[] args) throws Exception {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
//        smap=new int[N][N];
        Shark babyShark = new Shark();
        babyShark.size = 2;
        LinkedList<Shark> sharks = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
//                smap[i][j] = tmp;
                if (tmp == 9) {
                    babyShark.y = i;
                    babyShark.x = j;
                } else if (tmp > 0) {
                    Shark temp = new Shark();
                    temp.size = tmp;
                    temp.y = i;
                    temp.x = j;
                    sharks.add(temp);
                }
            }
        }


        int count = 0;
        while (!sharks.isEmpty()) {
            for (Shark s : sharks) {
                if (s.size < babyShark.size) {
                    s.distance = checkDistance(babyShark, s, map);
                }
            }
            Collections.sort(sharks);
            int i = 0;
            for (; i < sharks.size(); i++) {
                if (sharks.get(i).size < babyShark.size && sharks.get(i).distance != 1001) {
                    break;
                }
            }
            if (i < sharks.size()) {
                count++;
                if (count == babyShark.size) {
                    babyShark.size += 1;
                    count = 0;
                }
//                showNow(babyShark,sharks.get(i));
                map[babyShark.y][babyShark.x] = 0;
                map[sharks.get(i).y][sharks.get(i).x] = 0;
                answer += sharks.get(i).distance;
                babyShark.y = sharks.get(i).y;
                babyShark.x = sharks.get(i).x;

                /*System.out.println("dis : "+sharks.get(i).distance+" size : " +babyShark.size);
                System.out.println();*/
                sharks.remove(i);

            } else {
                break;
            }
        }


        System.out.println(answer);

    }

    /*private static void showNow(Shark babyShark, Shark shark) {

        smap[babyShark.y][babyShark.x] = 0;
        smap[shark.y][shark.x]=9;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(smap[i][j]);
            }
            System.out.println();
        }
    }*/

    static int checkDistance(Shark babyShark, Shark shark, int[][] map) {
        int result = 1000;
        int[][] tmpmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmpmap[i][j] = map[i][j];
            }
        }
        Queue<Dot> q = new ArrayDeque<>();
        Dot tmp = new Dot();
        tmp.y = shark.y;
        tmp.x = shark.x;
        q.add(tmp);
        tmpmap[tmp.y][tmp.x] = -1;
        while (!q.isEmpty() && result == 1000) {
            Dot now = q.poll();
            int nowy = now.y;
            int nowx = now.x;
            for (int i = 0; i < 4; i++) {
                int ny = nowy + dy[i];
                int nx = nowx + dx[i];
                if (ny == babyShark.y && nx == babyShark.x) {
                    result = tmpmap[nowy][nowx] - 1;
                    break;
                }
                if (ny < 0 || nx < 0 || ny == N || nx == N || babyShark.size < map[ny][nx] || tmpmap[ny][nx] < 0)
                    continue;

                tmpmap[ny][nx] = tmpmap[nowy][nowx] - 1;
                Dot next = new Dot();
                next.y = ny;
                next.x = nx;
                q.add(next);

            }
        }


		/*for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(tmpmap[i][j]);
			}
			System.out.println();
		}
		System.out.println(result);*/

        return Math.abs(result + 1);


    }

}


class Shark implements Comparable<Shark> {
    int distance;
    int size;
    int y;
    int x;

    @Override
    public int compareTo(Shark other) {
        if (this.distance != other.distance) {
            return this.distance - other.distance;
        } else if (this.y != other.y) {
            return this.y - other.y;
        } else if (this.x != other.x) {
            return this.x - other.x;
        } else return 0;

    }
}

class Dot {
    int y;
    int x;
}
