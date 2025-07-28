# [백준 - G4] 1339. 단어 수학!
 
## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
그리드

## ⏲️**Time Complexity**
$O(N × L)$

## :round_pushpin: **Logic**

- 알파벳에 자리수만큼 가중치를 더해준다.
	- ABC이면 A : 100, B : 10, C: 1
   	- ADB 추가로 있으면 A : 100 + 100 = 200, D : 10, B : 10 + 1 =11
- 알파벳 배열에서 큰거 부터 9 ~ 1 까지 하나씩 뽑아서 곱해준다

```java
	for(int n = 0; n<N; n++) {
			String input = in.readLine();
				
			int weight = 1;
			for (int i = 0 ; i< input.length()-1; i++) {
				weight *= 10;
			}
			
			for(int l = 0; l< input.length(); l++) {
				char c = input.charAt(l);
				num[c-'A'] += weight;
				
				weight /= 10;
			}
		}
		
		Arrays.sort(num);
		int total = 0;
		int point = 9;
		for(int i = 25; i>=0; i--) {
			total += num[i] * point ;
			point--;
			if(point <=0) {
				break;
			}
		}
```

## :black_nib: **Review**
- 가중치를 처음에 생각이 안나서 배열 어려개를 만들어야하나 생각하다가 오래 걸렸음

## 📡**Link**
- https://www.acmicpc.net/problem/1339
