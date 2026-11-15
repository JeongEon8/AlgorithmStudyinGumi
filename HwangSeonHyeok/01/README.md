# [PGS - LV1] 12932. 자연수 뒤집어 배열로 만들기


## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 구현

## ⏲️**Time Complexity**

$O(logn)$

## :round_pushpin: **Logic**
자연수의 길이를 미리 구해 배열을만들고 나머지를 이용해서 1의 자리부터 배열에 넣는다.
```
int len = String.valueOf(n).length();
int[] answer = new int[len];
for(int i = 0; i<len; i++){
	answer[i] = (int) (n%10);
	n /= 10;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12932