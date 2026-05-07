# [PGS - lv2] 02. 롤케이크 자르기

## ⏰**time**

60분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 오른쪽 조각의 토핑 개수를 먼저 모두 저장
2. 왼쪽으로 하나씩 이동하면서, 오른쪽 개수를 감소 시킨다.
3. 왼쪽 개수와 오른쪽 개수를 비교 후 같으면 `ans + 1`

```java
Map<Integer, Integer> right = new HashMap<>();
Set<Integer> left = new HashSet<>();

for (int t : topping) {
    right.put(t, right.getOrDefault(t, 0) + 1);
}

int ans = 0;
for(int i = 0; i < topping.length; i++) {

    int t = topping[i];

    // 왼쪽으로 이동
    left.add(t);

    // 오른쪽 개수 감소
    right.put(t, right.get(t) - 1);

    if (right.get(t) == 0) {
        right.remove(t);
    }

    if (left.size() == right.size()) {
        ans++;
    }

}
```

## :black_nib: **Review**

처음에 그냥 set으로 모든 경우의 수를 체크했는대 $O(N^2)$로 시간초과 됏다..

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/42627>
