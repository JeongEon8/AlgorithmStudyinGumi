# [백준 - S4] 30020. 치즈버거 만들기 2

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 구현
- 그리디 알고리즘
- 해 구성하기

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
b*2 >= a > b의 범위가 아니면 패티와 치즈를 모두 사용할 수 없다. 범위내에 들면 a-b개의 버거를 만들어야 모두 사용할 수 있고 aba는로 패티를 2개 치즈를 1개씩 사용하면서 a와 b의 차이가 1이되면 a와 b를 반복해서 마지막 버거를 완성해준다.
```java
	if (a > b && a <= b * 2) {
			sb.append("YES\n");
			sb.append(a - b + "\n");
			while (a - b != 1) {
				a -= 2;
				b -= 1;
				sb.append("aba\n");
			}
			sb.append("a");
			for (int i = 0; i < b; i++) {
				sb.append("ba");
			}
		} else {
			sb.append("NO");
		}
		System.out.println(sb);
```

## :black_nib: **Review**
처음에 생각을 잘못해서 해맸다.  
그리디 햇갈려요..

## 📡**Link**

https://www.acmicpc.net/problem/30020
