# [백준 - S5] 11650. 좌표 정렬하기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
Comparable 써서 정렬하면 끝.  
```java
class Point implements Comparable<Point> {
    int x, y;
    
    
    @Override
    public int compareTo(Point other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}
```


## :black_nib: **Review**  
정렬하기!!!
## 📡**Link**

https://www.acmicpc.net/problem/11650
