# [SWEA - 모의 SW 역량테스트] 5650. 핀볼 게임
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 배열에 자석 데이터 담기

2. 빨간색 화살표 위치를 담는 배열 생성 ( 자석이 움직이는게 아닌 화살표가 움직이게 설계함)

3. 비교자석에 왼쪽과 오른쪽을 비교하여 큐에 담는다.

4. 큐에서 하나씩 꺼내주면서 회전방향을 -1을 곱하여 방향을 바꾼다음 더해준다.

5. 화살표의 위치를 해당하는 극 비교하여 비트연산자로 점수를 계산해준다.

```java

	// 자석의 연결 상태 확인
	public static void check(int m, int t) { // m : 자석 번호, t : 확인하려는 자석이 오른쪽인지 왼쪽인지
		if (t == 0) { // 0 : 왼쪽
			if (m > 0) { // 왼쪽은 1이상일때만 확인 (0일경우 왼쪽에 자석이 없다)

				int cp = point[m]; // 현재 자석의 빨간색 화살표 위치
				int cpe = (cp + 6) % 8; // 현재 자석의 왼쪽 날 위치;

				int np = point[m - 1]; // 왼쪽 자석의 빨간색 화살표 위치
				int npe = (np + 2) % 8; // 왼쪽 자석의 오른쪽 날 위치

				if (magnet[m][cpe] != magnet[m - 1][npe]) { // 외쪽 자석과 다른 극인지 확인
					left.offer(m - 1);
					check(m - 1, 0);
				}
			}
		} else { // 오른쪽일 경우
			if (m < 3) { // 오른쪽은 2이하일때만 확인 (3일경우 오른쪽에 자석이 없다)

				int cp = point[m]; // 현재 자석의 빨간색 화살표 위치
				int cpe = (cp + 2) % 8; // 현재 자석의 오른쪽 날 위치;

				int np = point[m + 1]; // 오른쪽 자석의 빨간색 화살표 위치
				int npe = (np + 6) % 8; // 오른쪽 자석의 왼쪽 날 위치

				if (magnet[m][cpe] != magnet[m + 1][npe]) { // 외쪽 자석과 다른 극인지 확인
					right.offer(m + 1);
					check(m + 1, 1);
				}
			}

		}
	}
		
```


  

## :black_nib: **Review**
- 비트 연산자로 코드 길이가 조금 줄었던거 같아요

  
## 📡**Link**

- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeV9sKkcoDFAVH&categoryId=AWIeV9sKkcoDFAVH&categoryType=CODE&problemTitle=%EB%AA%A8%EC%9D%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1


  
