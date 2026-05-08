# [PGS - lv2] 01. 더맵게

## ⏰**time**

30분

## :pushpin: \*\*Algorith

-heap

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 우선순위 큐 안에 음식을 담아준다.
2. 큐에서 2개를 뽑아서 두번째꺼를 x2를 해서 합을 구해서 다시 큐에 넣어준다.
3. 2번을 큐안에 개수가 2개 미만이고 큐의 최소 값이 K이상일때 까지 반복해준다.
4. 반복 횟수를 출력

```java
while(que.size()>=2 && que.peek()<K){
	            int f = que.poll();
	            int s = que.poll();
	            total = f + s*2;
	            que.add(total);
	            answer++;
	        }
```

## :black_nib: **Review**

## 📡 Link
<https://school.programmers.co.kr/learn/courses/30/lessons/42626>
