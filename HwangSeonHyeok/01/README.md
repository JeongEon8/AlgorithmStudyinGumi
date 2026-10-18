# [PGS - LV2] 135807. 숫자 카드 나누기


## ⏰ **time**

	15분

## :pushpin: **Algorithm**
- 수학

## ⏲️**Time Complexity**

$O(nlogn)$

## :round_pushpin: **Logic**
각각의 최대공약수를 구하고 반대쪽 카드들을 나눌 수 없는지 판단한다.
```
int gcd(int a, int b){
	while(b!=0){
		int tmp = a%b;
		a = b;
		b =tmp;
	}
	return a;
}
for(int i = 0; i<arrayB.length; i++){
	if(arrayB[i]%gcdA==0){
		canDivide = true;
		break;
	}
}
if(!canDivide){
	answer = gcdA;
}
canDivide = false;
for(int i = 0; i<arrayA.length; i++){
	if(arrayA[i]%gcdB==0){
		canDivide = true;
		break;
	}
}
if(!canDivide){
	answer = Math.max(answer,gcdB);
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/135807