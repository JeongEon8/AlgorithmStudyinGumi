# [PGS - LV2] 12953. N개의 최소공배수


## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**
유클리드 호제법을 이용해 각 숫자들의 최소공배수를 순차적으로 업데이트해나간다.
```
int gcd(int a, int b){
	while(b!=0){
		int tmp = a%b;
		a = b;
		b =tmp;
	}
	return a;
}
public int solution(int[] arr) {
	int answer = arr[0];
	for(int i = 1; i<arr.length; i++){
		answer = (answer*arr[i])/gcd(answer,arr[i]);
	}
	return answer;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/12953