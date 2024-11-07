import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		List<Integer> pList = new ArrayList<>();
		for(int i = 0; i<m;i++) {
			pList.add(Integer.parseInt(in.readLine()));
		}
		Collections.sort(pList,Collections.reverseOrder());
		int ans = 0;
		int ansprice = 0;
		for(int i = 0;i<m; i++) {
			if(i==n)break;
			int tmp = Math.min(i+1,n) * pList.get(i);
			if(tmp>=ans) {
				ansprice = pList.get(i);
				ans = tmp;
			}
		}
		System.out.println(ansprice+" "+ans);
	}

}