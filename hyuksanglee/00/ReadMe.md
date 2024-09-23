# [백준 - G5] 14567. 선수과목
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- dp


## :round_pushpin: **Logic**
1. N과목 만큼 배열 안에 N을 수강하기 위한 선수과목을 담는 리스트를 추가하여 생성

2. 과목을 수강 할수 있는 최소 학기 입력 받을 배열 생성

3. 1부터 N까지 for문을 선수과목 있는지 파악
   	- 선수 과목이 없으면 1을 출력하고 최소 학기 입력 받을 배열에 갱신
   	- 선수 과목이 있으면 선수 과목 중 최대 학기에서 +1해서 출력하고 최소 학기 입력 받을 배열에 갱신
```
java
int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!arr[i].isEmpty()) {
				int max = Integer.MIN_VALUE;
				for (int n : arr[i]) {
					if (max < result[n]) {
						max = result[n];
					}
				}
				result[i] = 1+max;
			} else {
				result[i] = 1;
			}
			System.out.print(result[i] + " ");

		}
```

## :black_nib: **Review**
- 시간이 오래 걸리는거 같은데 더 빠른방법이 있을까요?



## 📡 Link
https://www.acmicpc.net/problem/14567
