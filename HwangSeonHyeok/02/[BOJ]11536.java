import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] arr = new String[n];
		
		for(int i = 0; i<n;i++) {
			arr[i] = in.readLine();
		}
		int mod = 0;
		for(int i = 1; i<n;i++) {
			if(arr[i].compareTo(arr[i-1])<0) {
				mod-=1;
			}else if(arr[i].compareTo(arr[i-1])>0) {
				mod+=1;
			}
		}
		if(mod==n-1) {
			System.out.println("INCREASING");
		}else if(mod==1-n) {
			System.out.println("DECREASING");
		}else {
			System.out.println("NEITHER");
		}

	}

}