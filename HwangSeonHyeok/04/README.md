# [백준 - G4] 27447. 주문은 토기입니까?

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
이 문제는 커피를 따르거나 서빙하는 시간 외에는 항상 토기를 만든다고 가정할 수 있다.  
손님한명당 서빙이 완료되기까지 최소 3이 소요되므로 i번째손님은 i*3+2 시간이후에 와야한다. 그보다 빨리 오는경우는 처리할 수 없음.  
손님이 왔을때 토기에 커피를 따라두는 시간은 아무리 빨라도 (손님 도착예정시간-m)이다. 항상 손님에게 전달할 수 있는 가장 빠른 시간에 커피를 담아두면 되므로 가장 마지막에 커피를 담은시간과 (손님 도착예정시간-m)중 더 늦은 시간부터 손님이 올때까지 커피를 담거나 서빙을 하지 않는 시간이 있으면 그 시간에 커피를 담아두고 손님이 오자마자 커피를 전달할 수 있다. 그런 시간이 없는경우 주문을 처리하지 못한 경우.

```java
customerLoop:for(int i = 0; i<n; i++){
	if(customers[i]<i*3+2){
		System.out.println("fail");
		return;
	}
	int startTime = Math.max(customers[i]-m,lastCoffeeTime);
	isAct[customers[i]] = true;
	for(int j = startTime; j<customers[i]; j++){
		if(!isAct[j]){
			isAct[j] = true;
			lastCoffeeTime = j;
			continue customerLoop;
		}
	}
	System.out.println("fail");
	return;
}
```

## :black_nib: **Review**
continue label을 사용하는거보단 그냥 메소드로 빼는게 더 깔끔했을듯.  
다음부턴 메소드로 빼는걸 습관화해야겠다.

## 📡**Link**

https://www.acmicpc.net/problem/27447
