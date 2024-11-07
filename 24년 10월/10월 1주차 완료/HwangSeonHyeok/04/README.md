# [백준 - S5] 2822. 점수 계산

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

점수의 오름차순으로 정렬해서 상위 5개의 총점을 구하고 문제 번호를 기록후 문제번호를 다시 오름차순으로 정렬하고 출력한다.

```java
	static class Problem implements Comparable<Problem> {
		int num, score;

		public Problem(int num, int score) {
			super();
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Problem o) {
			return o.score - this.score;
		}
	}




	Arrays.sort(pArr);
	int sum = 0;
	int[] correct = new int[5];
	for (int i = 0; i < 5; i++) {
		sum += pArr[i].score;
		correct[i] = pArr[i].num;
	}
	Arrays.sort(correct);
	System.out.println(sum);
	for (int n : correct) {
		System.out.print(n + " ");
	}
```

## :black_nib: **Review**

문제가 최대 8개 고정에 항상 상위 5개로 N이 굉장이 작아서 정렬을 2번해서 풀었다.

## 📡**Link**

https://www.acmicpc.net/problem/2822
