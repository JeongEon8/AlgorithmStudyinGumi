# [백준 - G2] 11780. 플로이드 2

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 플로이드 워셜

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**

최단 경로가 업데이트 될 때 마다 기록하는 테이블을 만들고 테이블을 바탕으로 최단경로 복구

```java
	 for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int i1 = list[i][j];

                if (i1 != 0) {
                    int count = 0;
                    int a = i;
                    int b = j;
                    List<Integer> tmp = new ArrayList<>();
                    do {
                        count++;
                        tmp.add(a);
                        a = shortCut[a][b];
                    } while (a != 0);

                    sb.append(count);
                    sb.append(' ');
                    for (Integer integer : tmp) {
                        sb.append(integer);
                        sb.append(' ');
                    }
                } else {
                    sb.append(i1);
                }
                sb.append('\n');
            }
        }
```

## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/11780
