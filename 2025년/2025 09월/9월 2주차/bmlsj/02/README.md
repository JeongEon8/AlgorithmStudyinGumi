
# [백준- G5] 12904. A와 B

## ⏰  **time**
30분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

1. `T` 에서 시작해 `S` 를 찾는 로직
2. `target`과 `start`의 길이가 같지 않으면 계속 로직을 수행함
	- `target` 의 끝이 `A`이면, `A`를 제거한다.
	- 끝이 `B`이면, `B` 제거 후 뒤집는다.

```java
static boolean change(String start, String target) {
		
	while (target.length() > start.length()) {
	    if (target.endsWith("A")) {
	        target = target.substring(0, target.length() - 1);
	    } else if (target.endsWith("B")) {
	        target = target.substring(0, target.length() - 1);
	        target = new StringBuilder(target).reverse().toString();
	    }
	}
	return target.equals(start);
}
```


## :black_nib: **Review**

S부터 시작하면 `directMethodHandle`가 발생한다는 사실! 알고 싶지 않았어요...
> 재귀 호출이 무한하게 일어나면서 JVM이 내부적으로 메서드 핸들을 계속 만들어내는 상황 때문에 보인다구 한다.. (나약하ㄴ 자바)


## 📡**Link**
- https://www.acmicpc.net/problem/12904

