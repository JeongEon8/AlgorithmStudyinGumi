# [백준 - G5] 2096. 내려가기
 
## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 1차원 배열 크기가 12인 배열 생성
    - 각자리에서 이전 단계랑 더했을 때 최댓값을 저장하는 칸 3개, 최솟값 3개, 이전 단계에 최댓값을 담는 칸 3개, 이전 단계에 최솟값을 담는 칸 3개
- 데이터를 입력 받으면 값을 갱신한다.
- 입력을 다 받으면 for문으로 최댓값과 최솟값을 찾는다.
```java
for(int n = 1; n<N; n++) {
			input = in.readLine().split(" ");
			int max = Math.max(save[6], save[7]);
			int min =Math.min(save[9], save[10]);
			save[0] = max+Integer.parseInt(input[0]);
			save[1] = Math.max(max, save[8])+Integer.parseInt(input[1]);
			save[2] = Math.max(save[7], save[8])+Integer.parseInt(input[2]);
			save[3] = min+Integer.parseInt(input[0]);
			save[4] = Math.min(min, save[11])+Integer.parseInt(input[1]);
			save[5] = Math.min(save[10], save[11])+Integer.parseInt(input[2]);
			save[6] = save[0];
			save[7] = save[1];
			save[8] = save[2];
			save[9] = save[3];
			save[10] = save[4];
			save[11] = save[5];
		}

```

## :black_nib: **Review**
너무 단순 무식하게 구현한거 같은데 이거 더 좋은방법이 있을까요?

## 📡**Link**
- https://www.acmicpc.net/problem/2096
