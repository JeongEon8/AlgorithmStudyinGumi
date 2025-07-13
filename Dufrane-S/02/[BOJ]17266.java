import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int[count];
		int i=0;
		while(st.hasMoreTokens()) {
			arr[i]= Integer.parseInt(st.nextToken());
			i++;
		}
		int l = 0, r = n;
		while(l<r) {
			int mid= (l+r)/2;
			if(check(mid, arr, n)) {
				r=mid;
			} else {
				l=mid+1;
			}
		}
		System.out.println(l);
	}
	static boolean check(int mid, int [] arr, int n) {
		int now = 0;
		for(int i : arr) {
			if(i-mid>now)return false;
			now = i+mid;
		}
		if(now>=n)return true;
		return false;
	}
}
