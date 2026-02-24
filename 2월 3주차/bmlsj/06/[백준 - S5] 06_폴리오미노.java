import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] words = br.readLine().split("\\.", -1);
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < words.length; i++) {
			
			int len = words[i].length();

            if (len % 2 != 0) { 
                System.out.println(-1);
                return;
            }
            
            int aCnt = len / 4;
            int remain = len % 4;
            
            for (int j = 0; j < aCnt; j++) {
                result.append("AAAA");
            }

            if (remain == 2) {
                result.append("BB");
            }

            // 마지막 블록이 아니면 '.' 다시 붙이기
            if (i != words.length - 1) {
                result.append(".");
            }
		}

		System.out.println(result);

	}

}