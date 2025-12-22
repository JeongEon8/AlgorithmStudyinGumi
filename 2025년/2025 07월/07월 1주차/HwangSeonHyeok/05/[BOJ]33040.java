import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int h = Integer.parseInt(split[0]);
		int w = Integer.parseInt(split[1]);
		split = in.readLine().split(" ");
		int one = Integer.parseInt(split[0]);
		int nine = Integer.parseInt(split[1]);
		int minimum = h * (h - 1) / 2;
		if (h > w + 1 || nine < minimum || one < minimum) {
			System.out.println(-1);
		} else {
			StringBuffer sb = new StringBuffer();
			int[] oneInLine = new int[h];
			int remainOne = one - minimum;
			int divide = remainOne / h;
			int remain = remainOne % h;
			for (int i = 0; i < h; i++) {
				oneInLine[i] = h - 1 - i + divide;
				if (i < remain)
					oneInLine[i]++;
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < oneInLine[i]; j++) {
					sb.append("1 ");
				}
				for (int j = 0; j < w - oneInLine[i]; j++) {
					sb.append("9 ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}

	}

}