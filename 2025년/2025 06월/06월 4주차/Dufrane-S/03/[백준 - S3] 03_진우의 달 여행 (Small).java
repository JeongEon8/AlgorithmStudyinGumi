import java.io.*;
import java.util.*;
public class Main
{
    static int [] nums = {-1,0,1};
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rows = Integer.parseInt(st.nextToken());
		int columns = Integer.parseInt(st.nextToken());
		int [][]map = new int[rows][columns];
		int [][]dirmap = new int[rows][columns];
		for(int i=0;i<columns;i++){dirmap[0][i]=999;}
		for(int i=0;i<rows;i++){
		    st=new StringTokenizer(br.readLine());
		    for(int j=0;j<columns;j++){
		        map[i][j]=Integer.parseInt(st.nextToken());
		    }
		}
		for(int i=1;i<rows;i++){
		    for(int j=0;j<columns;j++){
		        int next=Integer.MAX_VALUE;
		        for(int num : nums){
		            int beforej = num+j;
		            int beforei = i-1;
		            if(beforej<0||beforej==columns||dirmap[beforei][beforej]==99)continue;
		            if(dirmap[i][j]!=123||dirmap[beforei][beforej]==num)continue;
		            if(next>map[beforei][beforej]){
		                next=map[beforei][beforej];
		                dirmap[i][j]=num;
		            }else if(next==map[beforei][beforej]){
		                dirmap[i][j]=123;
		            }
		        }
		        if(next==Integer.MAX_VALUE){
		            next=0;
		            dirmap[i][j]=99;
		        }
		        map[i][j]=next+map[i][j];
		    }
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i=0;i<columns;i++){
		    if(answer>map[rows-1][i]&&dirmap[rows-1][i]!=99)answer=map[rows-1][i];
		}
		
		for(int i=0;i<rows;i++){
		    
		    for(int j=0;j<columns;j++){
		        System.out.print(map[i][j]+" ");
		    }System.out.println();
		}
  System.out.println();
		for(int i=0;i<rows;i++){
		    
		    for(int j=0;j<columns;j++){
		        System.out.print(dirmap[i][j]+" ");
		    }System.out.println();
		}
System.out.println();
		
		System.out.print(answer);
	}
}
