# [PGS - lv2] 01. 메뉴 리뉴얼

## ⏰**time**

60분

## :pushpin: \*\*Algorith

조합(DFS)

## ⏲️**Time Complexity**

$O(2^M)$

## :round_pushpin: **Logic**

1. 각 코스 길이를 순회하며, 주문 문자열을 알파벳 순으로 정렬.
2. dfs를 이용해 길이 c의 모든 조합을 생성한다.
3. 생성된 조합을 hashmap에 등장 횟수를 증가시킨다.
4. 등장 횟수가 2이상인 조합 중 최댓값을 찾는다.
5. 최댓값과 동일한 조합들을 결과에 추가한 후, 사전순으로 정렬후 반환

```java
for(int c: course) {

    map.clear();
    for(String order: orders) {
        char[] arr = order.toCharArray();
        Arrays.sort(arr);

        comb(arr, "", 0, c, map);
    }

    int max = 0;
    for(String key: map.keySet()) {
        if (map.get(key) >= 2) {
            max = Math.max(max, map.get(key));
        }
    }

    for (String key : map.keySet()) {
        if (map.get(key) == max && max >= 2) {
                list.add(key);
        }
    }
}


Collections.sort(list);
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/72411>
