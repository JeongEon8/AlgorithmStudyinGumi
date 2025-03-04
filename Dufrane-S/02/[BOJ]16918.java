import java.io.*;
import java.util.*;

public class Main
{
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1,};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int [][] list = new int[R][C];
		for(int i=0; i<R; i++) {
			String tmp = br.readLine();
			for(int j=0; j<C; j++) {
				if(tmp.charAt(j)=='.') {
					list[i][j]=-1;
				} else {
					list[i][j]=0;
				}
			}
		}
		int time=2;
		if(N>=2) {
			while(true) {
				if(time%2==0) {
					set(list,time);
				} else {
					explode(list,time);
				}
				/*System.out.println(time);
				printList(list);
				System.out.println();
				printRaw(list);
				System.out.println();*/
				if(time==N)break;
				time++;
			}
		}



		printList(list);
	}
	public static void set(int [][] list,int time) {
		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
				if(list[i][j]==-1) {
					list[i][j]=time;
				}
			}
		}
	}
	public static void explode(int [][] list,int time) {
		int [][]copyList = new int[list.length][list[0].length];
		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
			    copyList[i][j]=list[i][j];
			}
		}

		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
				if(copyList[i][j]==time-3) {
					list[i][j]=-1;
					for(int k=0; k<4; k++) {
						int ny=i+dy[k];
						int nx=j+dx[k];
						if(ny<0||nx<0||ny>=list.length||nx>=list[0].length)continue;
						list[ny][nx]=-1;
					}
				}
			}
		}
	}
	public static void printList(int [][] list) {
		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {
				if(list[i][j]==-1) {
					System.out.print('.');
				} else {
					System.out.print('O');
				}
			}
			System.out.println();
		}
	}

	public static void printRaw(int [][] list) {
		for(int i=0; i<list.length; i++) {
			for(int j=0; j<list[0].length; j++) {

				System.out.print(list[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
