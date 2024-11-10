# [SWEA - D3] 10726. 이진수 표현

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 비트연산

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

- M의 이진수 표현의 마지막 N 비트가 모두 1 켜져있는지 확인 하기 위해
- 1에서 시프트 연산을 사용해서 왼쪽으로 밀고 1을 더해주는것을 N번 반복해서 N 크기 만큼 1을 채워준다.
- 위에서 구한 값에서 &연산을 사용해서 위에 구한 값이랑 같은지 비교해준다.
- 만약 같은면 모두 켜져있는 것이라 ON출력 아닐경우 OFF 출력해준다.


```
for(int t =1; t<= TC; t++) {
			String[] input = in.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			int num = 0;
			for(int n =0; n<N; n++) {
			num =num <<1;
			num = num+1;
			}
			String str = "OFF";
			if((num& M) == num) {
				str = "ON";
			}
			System.out.println("#"+t+" "+str);
		}
```

## :black_nib: **Review**

## 📡**Link**

https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXRSXf_a9qsDFAXS
