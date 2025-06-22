# [백준 - S4] 2331. 반복수열
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- A부터 시작해, 각 자리수의 제곱인 다음수를 생성한다.
- 다음 수를 HashMap에 저장하고 순서를 기록한다.
- 이미 등장한 수가 나올 경우 → 반복 → 그 수의 인덱스를 출력한다.
- 반복되는 수부터는 사이클이므로, 그 이전까지 등장한 수의 개수만 세면 된다.


```java
HashMap<Integer, Integer> map = new HashMap<>();
int current = A;
int index = 0;

while (!map.containsKey(current)) {
	map.put(current, index++);
	current = getNext(current, P);
}

System.out.println(map.get(current));

```

## :black_nib: **Review**
- `Math.pow()` 사용 시 반환형이 double이므로 int 변환 필요 주의


## 📡**Link**
- https://www.acmicpc.net/problem/2331
