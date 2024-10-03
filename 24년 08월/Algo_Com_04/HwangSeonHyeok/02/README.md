# [백준 - s2] 2942. 퍼거슨과 사과

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 정수론
- 유클리드 호제법

## :round_pushpin: **Logic**

상자들을 넓이 순으로 정렬하고 가장 큰 상자부터 그리디하게 사용해서 사탕을 다담으면 사용한 상자 개수를 출력한다.

```cpp
    //최대공약수 구하기
    static int getGCD(int a, int b) {
		if(b==0) {
			return a;
		}
		return getGCD(b,a%b);
	}

    //최대공약수 구하고 그 약수들 찾기
    if(r<g) {
			gcd = getGCD(g,r);
		}else {
			gcd = getGCD(r,g);
		}
		for(int i = 1; i<=Math.sqrt(gcd); i++) {
			if(gcd%i==0) {
				sb.append(i + " "+ (r/i) + " " + (g/i) + "\n");
				list.add(i);
			}
		}
		for(int i =0; i<list.size();i++) {
			if(list.get(i)==Math.sqrt(gcd))continue;
			int cd = gcd/list.get(i);
			sb.append(cd + " "+ (r/cd) + " " + (g/cd) + "\n");
		}

```

## :black_nib: **Review**


## 📡**Link**

- https://www.acmicpc.net/problem/2942
