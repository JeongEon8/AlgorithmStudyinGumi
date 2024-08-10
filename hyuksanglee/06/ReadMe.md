# [SWEA - 모의 SW 역량테스트] 4012.요리사
 
## ⏰  **time**
90분

## :pushpin: **Algorithm**
dfs

## ⏲️**Time Complexity**
$O(2^N)$

## :round_pushpin: **Logic**
1. A음식과 B음식을 만들기 위해 필요한 재료 담는 스택 만들기

2. A나 B에 담고 다시 dfs호출

3. 담은 재료가 N개이면서 B에 담은 수가 N의 절반이면 계산을 한고 최솟값 비교하면서 갱신한다.
  
```java
		public static void dfs(int n) {
		
		// M 개수 일때 계산을 하거나 리턴
		if (n == N) {
			if (ingredientB.size() == N / 2) {
				int cookA = 0, cookB = 0;
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < N / 2; j++) {
						cookA += arr[ingredientA.get(i)][ingredientA.get(j)];
						cookB += arr[ingredientB.get(i)][ingredientB.get(j)];
					}
					
				}
				int result = Math.abs(cookA - cookB);
				if (min > result) {
					min = result;
				}
			}
			return;
		}

		// a음식에 재료 넣기
		ingredientA.push(n);
		dfs(n + 1); 
		ingredientA.pop(); // 넣은 재료 빼기
		
		// b음식에 재료 넣기
		ingredientB.push(n);
		dfs(n + 1);
		ingredientB.pop(); // 넣은 재료 빼기

	}
```

## :black_nib: **Review**
- 처음에는 조합으로 풀려다가 너무 답이 안나와서 인터넷을 보고 힌트를 얻어서 풀었습니다.
- 너무 어려워요 ㅠㅠ

  
## 📡**Link**

- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH&categoryId=AWIeUtVakTMDFAVH&categoryType=CODE&problemTitle=%EB%AA%A8%EC%9D%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1


  
