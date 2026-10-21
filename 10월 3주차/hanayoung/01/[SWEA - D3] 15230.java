import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            int before = (int)str.charAt(0);
            if(str.charAt(0) == 'a') {
            	for(int i = 1; i < str.length(); i++) {
                    if(before + 1 == (int)str.charAt(i)) {
                        before += 1;
                        continue;
                    } else {
                        break;
                    }
                }
            } else {
                before = (int)'a' -1;
            }
			System.out.println("#"+test_case+" "+(before-'a'+1));
		}
	}
}
