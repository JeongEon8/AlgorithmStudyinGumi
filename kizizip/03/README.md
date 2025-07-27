# [백준] 11866. 요세푸스 문제 0


## ⏰ **time**
20분

## :pushpin: **Algorithm**
자료 구조, 큐

## ⏲️**Time Complexity**
O(n^2)

## :round_pushpin: **Logic**
리스트 크기는 처음에 n이다. 그리고 하나 빼낼 때마다 줄어들겠지...
현재 위치에서 k번째 사람을 찾기 위해 `k-1`만큼 이동 = `index + (k-1)`
원형 구조를 반영해서 `% circle.size()` 해준다.
```java
        while (!circle.isEmpty()) {
            index = (index + k - 1) % circle.size();
            sb.append(circle.remove(index));
            if (!circle.isEmpty()) {
                sb.append(", ");
            }
        }
```


## :black_nib: **Review**
정신을 체리길 바랍니다.. 

## 📡**Link**
https://www.acmicpc.net/problem/11866 
