import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int rows = Integer.parseInt(st.nextToken());
		int columns = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;
		char[][]board = new char[rows][columns];
		for(int i=0;i<rows;i++){
		    String tmp = br.readLine();
		    for(int j=0;j<columns;j++){
		        board[i][j]=tmp.charAt(j);
		    }
		}
		
		for(int i=0; i<rows-7; i++) {
			for(int j=0; j<columns-7; j++) {
				int tmp = check(board,i,j);
				
				if(answer>tmp)answer=tmp;
			}
		}
		System.out.println(answer);
	}
	static int check(char [][]board, int y, int x) {
		int count=0;
        for(int i=y;i<y+8;i+=2){
            for(int j=x;j<x+8;j+=2){
                if(board[i][j]=='W'){
                    count++;
                }
            }
            for(int j=x+1;j<x+8;j+=2){
                if(board[i][j]=='B'){
                    count++;
                }
            }
        }
        for(int i=y+1;i<y+8;i+=2){
            for(int j=x;j<x+8;j+=2){
                if(board[i][j]=='B'){
                    count++;
                }
            }
            for(int j=x+1;j<x+8;j+=2){
                if(board[i][j]=='W'){
                    count++;
                }
            }
        }
		return count<64-count?count:64-count;
	}
}
