import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon9655 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 0) System.out.println("CY");
		else System.out.println("SK");
		
	}
}