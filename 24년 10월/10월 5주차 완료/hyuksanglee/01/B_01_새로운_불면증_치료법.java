package b_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_01_새로운_불면증_치료법 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(in.readLine());
		for(int t = 1; t<= T; t++) {
			boolean[] isSelected = new boolean[10];
			int N = Integer.parseInt(in.readLine());
			int i = 1;
			while(true) {
				int cN = N*i;
				
				String str = cN+"";
				for(int j = 0 ; j <str.length(); j++) {
					int num  = str.charAt(j) -'0';
					isSelected[num] = true;
				}
				
				i++;
				
				boolean check = false;
				for(int j = 0; j<10; j++) {
					if(isSelected[j]== false) {
						check = true;
						break;
					}
				}
				if(!check) {
					break;
				}
				
				
				
			}
			System.out.println("#"+t+" "+(N*(i-1)));
		}
	}

}
