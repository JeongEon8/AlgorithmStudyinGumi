# [백준 - G5] 17953. 디저트

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(NM^2)$

## :round_pushpin: **Logic**
딜러의 카드를 받아서 페어가 만들어지면 플레이어가 어떤 카드를 주더라도 페어가 완성돼 카드가 없어진다.  
즉 주어진 턴제한 안에서 받을때 점수가 가장 높은 카드를 받아 점수를 받고 가장 점수가 낮은 카드를 돌려주면된다.  
또한 음수카드만 남은 경우엔 빈카드를 받고 주고를 반복하면서 턴을 넘겨줄 수 있으니 0점 미만의 카드를 받는 경우는 고려하지 않는다.
```java
Arrays.sort(scores);
int ans = 0;
int max = Math.min(m,n%2==0? n/2:n/2+1);
for (int i = 0; i<max;i++){
	if(scores[i]>0)break;
	ans-=scores[i];
}
```
점수를 내림차순으로 정렬하려고 음수 저장하고 정렬하였다.

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/31845
