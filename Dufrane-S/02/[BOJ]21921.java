import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n= Integer.parseInt(st.nextToken());
		int k= Integer.parseInt(st.nextToken());
		int sum = 0;
		int []list = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<k; i++) {
			sum+=list[i];
		}
		int large = sum;
		int count = 1;
        
		for(int i=k; i<n; i++) {
			sum-=list[i-k];
			sum+=list[i];
			if(large<sum) {
				large=sum;
				count=1;
			} else if(large==sum)count++;
		}
		if(large==0) {
			System.out.print("SAD");
			return;
		}
		System.out.println(large);
		System.out.print(count);
	}
}
