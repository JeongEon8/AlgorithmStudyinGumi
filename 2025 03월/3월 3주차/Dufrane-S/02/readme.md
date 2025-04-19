# [백준 - G5] 1011. Fly me to the Alpha Centauri

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학


## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
가속한 만큼 감속해야하므로 대칭을 이루게 된다 9 => 1,2,3,2,1
양쪽으로 1,2,3... 추가해두고 남은 숫자가 2 * i 일 경우, 상황에 따라 처리
```java
static int logic (int n){
	    int i = 1;
	    int answer = 0;
	    while(n>i*2){
	        answer +=2;
	        n-=i*2;
	        i++;
	    }
	    if(n>i){
	        answer+=2;
	    }else if(n==0){
	        
	    }else{
	        answer++;
	    }
	    return answer;
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1011
