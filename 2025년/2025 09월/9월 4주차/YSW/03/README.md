# [백준 - S5] 15719. 중복된 숫자 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**

길이가 N인 배열을 만들고 숫자가 나올때 마다 그 숫자를 인덱스로 해서 배열을 값을 증가 시키고 2가 되는 인덱스를 출력했다.

```java
		for (int i = 0; i < arr.length; i++) {
			int currentNum = Integer.parseInt(st.nextToken());
			arr[currentNum]++;
			if (arr[currentNum] > 1) {
				System.out.println(currentNum);
				return;
			}
		}
```

## :black_nib: **Review**

평소에 여러개를 숫자를 받을때 br.readLine.split(" ");을 써서 받는데 이걸로 배열의 값을 받으면 메모리가 터질꺼 같아서 scanner로 하나 씩 받아서 쓰니까 시간 초과가 났다. 그래서 다시 BufferedReader와 StringTokenizer를 사용했는데 StringTokenizer도 사용해봐야겠다.

## 📡**Link**

https://www.acmicpc.net/problem/15719
