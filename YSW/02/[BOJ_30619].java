import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_30619 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		int[] roomArr = new int[strArr.length];
		int query = Integer.parseInt(br.readLine());
		int[] peopleArr = new int[strArr.length];

		for (int i = 0; i < N; i++) {
			roomArr[i] = Integer.parseInt(strArr[i]);
			peopleArr[roomArr[i] - 1] = i + 1;
		}

		for (int i = 0; i < query; i++) {
			strArr = br.readLine().split(" ");
			int L = Integer.parseInt(strArr[0]);
			int R = Integer.parseInt(strArr[1]);
			int[] copyPeopleArr = Arrays.copyOf(peopleArr, peopleArr.length);
			Arrays.sort(copyPeopleArr, L - 1, R);

			for (int j = 0; j < N; j++) {
				roomArr[copyPeopleArr[j] - 1] = j + 1;
			}

			for (int j = 0; j < N; j++) {
				System.out.print(roomArr[j] + " ");
			}
			System.out.println();
		}
	}
}
