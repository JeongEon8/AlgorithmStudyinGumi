# [백준 - S5] 13909. 창문 닫기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학, 정수론

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
입력 숫자가 1억이라서 N의 시간 복잡도로 풀면 시간초과 걸린다.
낮은 숫자부터 시작해서 규칙을 찾으면 된다.
각 숫자의 약수의 개수가 홀수이면 열려있고, 짝수이면 닫혀있다.
그런데, 약수의 개수가 홀수인 숫자는 제곱수이다. (1, 4, 9, 16 같은 수)
그래서 입력한 N의 루트 값에서 소수점을 버리면 답이다.
규칙 생각이 어렵다.

```python
n = int(input())
print(int(n**0.5))
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/13909
