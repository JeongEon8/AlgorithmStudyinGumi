# [백준] 17352. 여러분의 다리가 되어 드리겠습니다!


## ⏰ **time**
30분 

## :pushpin: **Algorithm**
자료구조, 그래프 

## ⏲️**Time Complexity**
O(n α(n))

## :round_pushpin: **Logic**
이어져 있다고 입력된 애들끼리는 union함수로 이어준다. <br/>
어떻게 이어주느냐? 일단 부모를 find함수로 찾는다. 
```java
    private static int find(int[] parent, int x) {
        if (parent[x] != x) {
            //계속 상위 부모 찾기
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
```
부모가 다르면? 일치시켜주면 된다~ 그럼 합쳐진다~
```java
    private static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootY] = rootX; //그룹 ㅎ바치기
        }
    }
```
그러고선 안 이어져 있는 애들을 찾아서 출력해주면 끝.


## :black_nib: **Review**
친구가 시켜서 풀었는데 친구의 양심이 살아 있는 문제였어요 (나쁘지 않았다는 뜻) 

## 📡**Link**
https://www.acmicpc.net/problem/17352
