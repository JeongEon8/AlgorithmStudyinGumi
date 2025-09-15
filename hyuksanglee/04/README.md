
# [백준- G5] 1011. Fly me to the Alpha Centauri
## ⏰  **time**
80분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**
$O(T)$

## :round_pushpin: **Logic**

- 두 수의 뺀 값에 제곱근을 구한다.
  - 시작 값이랑 끝값이 무조건 1이 돼야하므로 피라미드 형태가 나온다(1+2+3+2+1)
    - 20일 경우 최대 낼수 있는 속도는 4이고 5까지 내면 초과 된다.
    	- (1+2+3+4+3+2+1)=16(4*4), (1+2+3+4+5+4+3+2+1) = 25(5*5)
     	- (1+2+3+4+3+2+1) 이거 갯수는 2n-1 로 계산할수 있고 2(4)-1 =7
      	- 16은 20보다 작으므로 어딘가에서 한개를 더해주었을거다 7+1 이된다.
```java
	for(int t=0; t<T; t++) {
			String [] input = in.readLine().split(" ");
			long x = Integer.parseInt(input[0]);
			long y = Integer.parseInt(input[1]);
			
			long total = y-x;
			long n =(long) Math.sqrt(total);
			
			if(n*n==total) {
				System.out.println(2*n-1);
			}else if (n*n+n <total){
				System.out.println(2*n+1);
			}else {
				System.out.println(2*n);
			}
			
			
			
		}
```

## :black_nib: **Review**
- 수학 문제 푸는거 같아, 수학은 알고리즘이 맞을까?


## 📡**Link**
- https://www.acmicpc.net/problem/1011

