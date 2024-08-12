# [SWEA - 모의 SW 역량테스트] 4008. 숫자만들기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
누적합

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 연산자 배열에 완전 탐색을 한다.
	1. 배열에서 연산자 하나씩 들고 와서 계산을 한다
      	2. 수식에 개수 만큼 계산을 하고 전에 계산했던 max와 min을 비교해서 값을 해당 값이랑 변경해준다
2. 완전 탐색으로 구한 max와 min의 차이를 구한다.
  
```java
		public static void quest(int count) {
		if (count == N - 1) { // 연산자 수만큼 계산 다 했을때
			if(max<total) {
				max=total;
			}
			if(min> total) {
				min = total;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int tmp = total;
			if (operator[i] != 0) {
				if (i == 0) { // 더하기
					operator[i] -= 1;
					total += num[++count];
					quest(count);
					count--;
					operator[i] += 1;
					total = tmp;
				}else if(i == 1) { // 빼기
					operator[i] -= 1;
					total -= num[++count];
					quest(count);
					count--;
					operator[i] += 1;
					total = tmp;
				}else if(i == 2) { // 곱하기
					operator[i] -= 1;
					total *= num[++count];
					quest(count);
					count--;
					operator[i] += 1;
					total = tmp;
					
				}else if(i == 3) { // 나누기
					operator[i] -= 1;
					total /= num[++count];
					quest(count);
					count--;
					operator[i] += 1;
					total = tmp;
				}

			}
		}

	}
```

## :black_nib: **Review**
- 처음에 이중 for문을 돌려서 i에서 j 만큼 더했는데 시간초과 하였다.
- 알고리즘 힌트를 얻고 누적합으로 풀었더니 문제를 해결했다.

  
## 📡**Link**

- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH&categoryId=AWIeRZV6kBUDFAVH&categoryType=CODE&problemTitle=%EB%AA%A8%EC%9D%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1


  
