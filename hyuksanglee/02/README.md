# [백준 - 골드 4] 4195. 친구 네트워크
 
## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
유니온 파이드

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 친구 무리중 리더를 정한다(혼자일 경우 자기자신이 리더가 됨)
2. 친구 두명을 연결할때는 무리중 한팀에 합친다.
   	- 한쪽에 무리의 리더의 번호를 자기자신에서 합치려는 팀의 리더의 번호를 적는다
```java
	static void union(String a, String b) {
		int numA = network.get(a);
		int numB = network.get(b);
		
		int headerA = friendHeader(numA);
		int headerB = friendHeader(numB);
		
		if(headerA != headerB) {
			size[headerA] += size[headerB];
			header[headerB] = headerA;
		}
		
		
		System.out.println(size[headerA]);
	}
```

## :black_nib: **Review**
- 친구 관계수가 F개를 받아서 사람의 수가 총 F명이줄 알았는데 생각을 해보니 F관계중 서로 다 다른 사람들이면 2*F가 되더라구요. 처음에는 메모리 오류가 떴어요 앞으로 잘생각하고 메모리 설정해야할거 같아요

## 📡 Link
https://www.acmicpc.net/problem/4195
