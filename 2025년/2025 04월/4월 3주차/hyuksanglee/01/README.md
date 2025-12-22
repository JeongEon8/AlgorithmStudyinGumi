# [백준 - S2] 1965. 상자넣기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- dp

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
- Collections.binarySearch() 리스트 안에 들어가야할 인덱스를 찾는다
- 인덱스의 크기가 리스트 사이즈랑 같으면 add로 추가하고 작으면 해당 인데스랑 변경한다.
```java
List<Integer> lis = new ArrayList<>();
        for (int box : arr) {
            int idx = Collections.binarySearch(lis, box);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx == lis.size()) {
                lis.add(box);
            } else {
                lis.set(idx, box);
            }
        }
```


## :black_nib: **Review**  
어렵네요
## 📡**Link**

https://www.acmicpc.net/problem/1965
