import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] xs = new int[100001];
		int[] ys = new int[100001];
		int sum =0;
		st = new StringTokenizer(br.readLine());
		xs[0] = Integer.parseInt(st.nextToken());
		ys[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			xs[i] = Integer.parseInt(st.nextToken());
			ys[i] = Integer.parseInt(st.nextToken());
			sum+=Math.abs(xs[i]-xs[i-1])+Math.abs(ys[i]-ys[i-1]);
		}
		int answer = sum;
		for(int i=1; i<n-1; i++) {
            sum-=Math.abs(xs[i]-xs[i-1])+Math.abs(ys[i]-ys[i-1]);
            sum-=Math.abs(xs[i]-xs[i+1])+Math.abs(ys[i]-ys[i+1]);
            sum+=Math.abs(xs[i-1]-xs[i+1])+Math.abs(ys[i-1]-ys[i+1]);
            if(answer>sum)answer=sum;
            sum-=Math.abs(xs[i-1]-xs[i+1])+Math.abs(ys[i-1]-ys[i+1]);
            sum+=Math.abs(xs[i]-xs[i-1])+Math.abs(ys[i]-ys[i-1]);
            sum+=Math.abs(xs[i]-xs[i+1])+Math.abs(ys[i]-ys[i+1]);
		}
		System.out.println(answer);
	}
}
