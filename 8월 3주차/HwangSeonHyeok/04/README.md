# [백준 - S4] 14602. 소금과 후추 (Small)

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 정렬
- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(N^4)$

## :round_pushpin: **Logic**
문제 조건대로 각 칸마다 행렬A에서 정해진 칸의 수들을 list에 넣고 정렬해서 중간값을 찾아서 행렬B로 출력한다.
```java
int newM = m - w + 1;
int newN = n - w + 1;
for (int i = 0; i < newM; i++) {
    for (int j = 0; j < newN; j++) {
        List<Integer> tmp = new ArrayList<>();
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < w; y++) {
                tmp.add(matrixA[i + x][j + y]);
            }
        }
        Collections.sort(tmp);
        sb.append(tmp.get((w * w) / 2)).append(" ");
    }
    sb.append("\n");
}
```  
## :black_nib: **Review**
4중for문이랑 정렬을 너무 자주해서 다른 좋은 방법이 있을거 같은데 코드가 너무 길어질것 같다.  
## 📡**Link**
https://www.acmicpc.net/problem/14602