# [백준 - S4] 24173. 알고리즘 수업 - 힙 정렬 1 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 구현
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

이 코드는 최소 힙 기반 힙 정렬 구현입니다. 먼저 buildMinHeap을 통해 배열을 최소 힙 구조로 변환합니다. 이 단계에서는 전체가 정렬되는 것이 아니라, 최소값이 항상 루트에 위치하도록 힙 조건을 만족시키는 과정입니다.
이후 정렬 단계에서는 루트(최소값)와 마지막 원소를 swap하여 최소값을 배열의 뒤쪽에 확정시키고, 힙의 크기를 줄인 뒤 heapify를 통해 다시 힙 조건을 복구합니다.
이 과정을 반복하면서 뒤에서부터 값이 확정되며 정렬이 완성됩니다.
이 문제의 핵심은 swap이 발생할 때마다 count를 증가시키고, K번째 swap이 발생하는 순간 해당 두 값을 출력하는 점입니다.

```java
		heapSort(A, N);

		System.out.println("-1");

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
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/24173