# [백준 - S3] 9375. 패션왕 신해빈

## ⏰ **time**

10분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 의상을 입을수 있는 경우의 수를 구하면 된다.
  	- ex) 상의 :2, 하의 : 2 일경우, 상의는 1을 입거나 2번을 입거나 아무것도 안입거나 3가지고 하의도 3가지 이다
  	- 3 x 3 = 9 이고 총 나올수 있는 경우가 9이고 여기서 아무것도 안입는 경우 1개를 빼면 된다.
```java
   for(int t = 0 ; t<T; t++) {
			
			int N = Integer.parseInt(in.readLine());
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(int n = 0; n<N; n++) {
				String [] input = in.readLine().split(" ");
				if(map.containsKey(input[1])) {
					map.put(input[1], map.getOrDefault(input[1], 0) + 1);
				}else {
					map.put(input[1],1);
				}
			}
			int total = 1;
			for(int count : map.values()) {
				total *= count +1;
			}
			System.out.println(total-1);
		}
```



## :black_nib: Review
- 썬글라스만 끼고 나갈수가 있다니 충격!!!!
## 📡**Link**

- [https://www.acmicpc.net/problem/9375](https://www.acmicpc.net/problem/9375)
