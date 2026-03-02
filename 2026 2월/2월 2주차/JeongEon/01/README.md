# [백준 - 실버 5] 9625.BABBA

## ⏰ **time**
30분

## :pushpin: **Algorithm**
재귀

## ⏲️ **Time Complexity**
$O(K)$

## :round_pushpin: **Logic**
1. 0회일 때의 A와 B 개수, 1회일 때의 A와 B개수를 각각 a0, b0, a1, b1으로 전달하며 function을 호출한다.
2. A = a0 + a1, B = b0 + b1 후 function에는 a1, b1, A, B를 전달한다. (피보나치수열쳐럼)
3. 현재 재귀 k번이 입력값 K와 동일하다면 A와 B를 출력하고 종료한다.
```cpp
void function(int k, int a0, int b0, int a1, int b1) {
	if (k == K) {
		cout << A << " " << B << '\n';
		return;
	}
	
	A = a0 + a1;
	B = b0 + b1;
	function(k + 1, a1, b1, A, B);
}
```

## :black_nib: **Review**
- [10 Hours Of Wii Theme Music (Mii Song)](https://www.youtube.com/watch?v=Twi92KYddW4&list=RDTwi92KYddW4&start_radio=1&t=2961s) 요새 알고 풀 때 닌텐도 노래 들으면 잘 풀리는 거 같아요
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/9625](https://www.acmicpc.net/problem/9625)
