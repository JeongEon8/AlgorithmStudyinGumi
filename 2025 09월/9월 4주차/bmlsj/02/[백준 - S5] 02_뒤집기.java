
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main{
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
        char[] slist = s.toCharArray();

		int zeroCnt = 0;
		int oneCnt = 0;

		boolean flag = slist[0] == '1' ? false : true;
		for (char str : slist) {
			if (str == '1' && !flag) {
				oneCnt++;
				flag = true;
			} else if (str == '0' && flag) {
				flag = false;
				zeroCnt++;
			}

		}

		System.out.println(zeroCnt < oneCnt ? zeroCnt : oneCnt);

	}
}
