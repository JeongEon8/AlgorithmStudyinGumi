import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24173 {
	public static int N;
	public static int K;
	public static int[] A;
	public static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		heapSort(A, N);

		System.out.println("-1");
	}

	public static void heapSort(int[] A, int n) {
		buildMinHeap(A, n);
		for (int i = n; i >= 2; i--) {
			swap(A, 1, i);
			heapify(A, 1, i - 1);
		}
	}

	public static void buildMinHeap(int[] A, int n) {
		for (int i = n / 2; i >= 1; i--) {
			heapify(A, i, n);
		}
	}

	public static void heapify(int[] A, int k, int n) {
		int left = 2 * k;
		int right = 2 * k + 1;
		int smaller;

		if (right <= n) {
			if (A[left] < A[right])
				smaller = left;
			else
				smaller = right;
		} else if (left <= n) {
			smaller = left;
		} else {
			return;
		}

		if (A[smaller] < A[k]) {
			swap(A, k, smaller);
			heapify(A, smaller, n);
		}
	}

	public static void swap(int[] A, int i, int j) {
		count++;
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;

		if (count == K) {
			if (A[i] < A[j]) {
				System.out.println(A[i] + " " + A[j]);
			} else {
				System.out.println(A[j] + " " + A[i]);
			}
			System.exit(0);
		}
	}
}