import java.util.*;
import java.io.*;
public class Main
{
	static int answer;
	static int[] dx= {-1,0,1,-1,1,-1,0,1};
	static int[] dy= {1,1,1,0,0,-1,-1,-1};


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n,m;

		while(true) {
			answer=0;
			st = new StringTokenizer(br.readLine());
			m=Integer.parseInt(st.nextToken());
			n=Integer.parseInt(st.nextToken());

			if(n==0&&m==0)break;
			int [][]map = new int[n][m];
			int [][]done = new int[n][m];
			for(int i=0; i<n; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			

			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==1&&done[i][j]==0) {
				// 		System.out.println(i+" "+j);
						answer++;
						done[i][j]=1;
						Queue<Dot>q = new ArrayDeque<>();// ArrayDeque
						Dot tmp = new Dot();
						tmp.y=i;
						tmp.x=j;
						q.add(tmp);
						while(!q.isEmpty()) {
							Dot now = q.poll();
							int nowx=now.x;
							int nowy=now.y;
							
							for(int k=0; k<8; k++) {
								int ny =nowy+dy[k];
								int nx =nowx+dx[k];


                                
								if(ny<0||nx<0||ny==n||nx==m||map[ny][nx]==0||done[ny][nx]==1)continue;
								Dot next = new Dot();
								next.y=ny;
								next.x=nx;
								q.add(next);
								done[ny][nx]=1;
							}
						}
					}
				}
			}


			System.out.println(answer);
		}

	}
}
class Dot {
	int x;
	int y;
}

