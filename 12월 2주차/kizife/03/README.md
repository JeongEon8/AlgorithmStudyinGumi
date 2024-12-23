# [백준] 4485. 녹색 옷 입은 애가 젤다지?


## ⏰ **time**
30분

## :pushpin: **Algorithm**
그래프 이론, 최단 경로 

## ⏲️**Time Complexity**
O(n^2) 

## :round_pushpin: **Logic**
그냥 2차원배열... 첫 칸에서 끝 칸까지 가면서 밟는 값의 최소 합을 구하면 된다. <br/>
모든 경우를 탐색하되, 이전에 저장된 합보다 크게 된다면 최소값은 불가능하므로 탐색을 패스한다.<br/>
마지막 칸에 저장된 값 출력
```java
                    int newCost = cost + map[nx][ny];

                    //더 작은 비용이 된다면 갱신
                    if (newCost<arr[nx][ny]) {
                        arr[nx][ny] = newCost;
                        queue.add(new int[]{nx, ny, newCost});
                    }
```


## :black_nib: **Review**
날로 먹는 골드4! 야호! 

## 📡**Link**
https://www.acmicpc.net/problem/4485
