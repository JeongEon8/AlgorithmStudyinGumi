import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] books = new String[n];
		for (int i = 0; i < n; i++) {
			books[i] = in.readLine();
		}
		Arrays.sort(books);
		String ans = books[0];
		int max = 1;
		int current = 1;
		for (int i = 1; i < n; i++) {
			if (books[i].equals(books[i - 1])) {
				current++;
				if (max < current) {
					ans = books[i];
					max = current;
				}
			} else {
				current = 1;
			}
		}
		System.out.println(ans);

	}

}