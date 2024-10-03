# [SWEA - 모의 SW 역량테스트] 5658. 보물상자 비밀번호
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 4등분 해서 큐에 넣어준다

2. 한 바퀴 돌리면 큐에서 하나 뽑아서 다음 칸에 넘겨준다

3. 넘겨준다음 칸에 있는 string을 Integer.parse를 이용하여 16진수를 10진수로 변경하고 set에 넘어준다

4. 다 돌고 나면 set을 배열로 바꾼 다음 sort로 정렬하고 해당 크기에 맞는 함수 찾는다
  
```java
		// 번호 경우의 수 만큼 돌리기
			for (int k = 0; k < n; k++) {

				// 번호 한번 돌리기
				for (int i = 0; i < 4; i++) {
					arr[i].offer(arr[(i + 1) % 4].poll());
				}

				// 한줄의 수를 int롤 변형하여 set에 담기
				for (int i = 0; i < 4; i++) {
					String str = "";
					for (int j = 0; j < n; j++) {
						String tmp = arr[i].poll();
						str += tmp;
						arr[i].offer(tmp);
					}
					set.add(Integer.parseInt(str, 16));
					
				}

			}
```

## :black_nib: **Review**
- Integer.parse가 16진수를 10진수로 바꾸는거 이문제를 통해 알게 되었어요

  
## 📡**Link**

- [https://www.acmicpc.net/problem/11659](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo)


  
