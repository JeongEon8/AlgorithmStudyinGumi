import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static int n, m;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		n = Integer.parseInt(split[0]); // 사이트 주소 수
		m = Integer.parseInt(split[1]); // 비밀번호 찾으려는 수

		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			split = br.readLine().split(" ");
			map.put(split[0], split[1]);
		}

		for (int i = 0; i < m; i++) {
			String input = br.readLine();
			System.out.println(map.get(input));
		}

	}

}
