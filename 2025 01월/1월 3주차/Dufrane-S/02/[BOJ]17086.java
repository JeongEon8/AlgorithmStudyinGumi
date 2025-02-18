import java.util.*;
import java.io.*;
public class Main
{
	static int [] dx= {-1,0,1,-1,1,-1,0,1};
	static int [] dy= {1,1,1,0,0,-1,-1,-1};
	static int N=0;
	static int M=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		int [][] map=new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int answer=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					int tmp = check(i,j,map);
					if(answer<tmp)answer=tmp;
				}
			}
		}
		System.out.println(answer);
	}
	static int check(int sy,int sx, int[][] map) {
	    int[][]tmpmap=new int[N][M];
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            tmpmap[i][j]=map[i][j];
	        }
	    }
	    
		int result=0;
		tmpmap[sy][sx]=-1;
		Queue<Dot>q=new ArrayDeque<>();
		Dot d = new Dot();
		d.y=sy;
		d.x=sx;
		q.add(d);
		while(!q.isEmpty()&&result==0) {
			Dot now = q.poll();
			int nowy=now.y;
			int nowx=now.x;
			for(int i=0; i<8; i++) {
				int ny=nowy+dy[i];
				int nx=nowx+dx[i];
				if(ny<0||nx<0||ny==N||nx==M||tmpmap[ny][nx]<0)continue;
				if(tmpmap[ny][nx]==1) {
				    if(result>tmpmap[nowy][nowx]-1)result=tmpmap[nowy][nowx]-1;
				    break;
				} else {
					tmpmap[ny][nx]=tmpmap[nowy][nowx]-1;
					d= new Dot();
					d.y=ny;
					d.x=nx;
					q.add(d);
				}
			}
		}
		result = Math.abs(result+1);
		return result;
	}
}

class Dot {
	int x;
	int y;
}
