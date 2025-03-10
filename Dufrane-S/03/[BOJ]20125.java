import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char [][] list = new char [n][n];
		for(int i=0;i<n;i++){
		    String tmp = br.readLine();
		    for(int j=0;j<n;j++){
		        list[i][j]=tmp.charAt(j);
		    }
		}
		Dot core = null;
		for(int i=0;i<n;i++){
		    for(int j=0;j<n;j++){
		        if('*'==list[i][j]){
		            core = new Dot();
		            core.y=i+1;
		            core.x=j;
		            break;
		        }
		    }
		    if(core!=null)break;
		}
		System.out.print(core.y+1+ " ");
		System.out.println(core.x+1);
		int leftHand =0;
		int x = core.x-1;
		char now='*';
		while(now=='*'){
		    leftHand++; 
		    x--;
		    if(x==-1)break;
		    now = list[core.y][x];
		}
		System.out.print(leftHand+" ");
		
		int rightHand =0;
		x = core.x+1;
		now='*';
		while(now=='*'){
		    rightHand++; 
		    x++;
		    if(x==n)break;
		    now = list[core.y][x];
		}
		System.out.print(rightHand+" ");
		
		int body =0;
		int y = core.y+1;
		x = core.x;
		now='*';
		while(now=='*'){
		    body++; 
		    y++;
		    if(y==n)break;
		    now = list[y][core.x];
		}
		System.out.print(body+" ");
		Dot bottom = new Dot();
		bottom.y=y;
		bottom.x=core.x;
		
		
		
		int leftFoot =0;
		y = bottom.y;
		x = bottom.x-1;
		now='*';
		while(now=='*'){
		    leftFoot++; 
		    y++;
		    if(y==n)break;
		    now = list[y][x];
		}
		System.out.print(leftFoot+" ");
		
		int rightFoot =0;
		y = bottom.y;
		x = bottom.x+1;
		now='*';
		while(now=='*'){
		    rightFoot++; 
		    y++;
		    if(y==n)break;
		    now = list[y][x];
		}
		System.out.print(rightFoot+" ");
	}
}

class Dot{
    int y;
    int x;
}
