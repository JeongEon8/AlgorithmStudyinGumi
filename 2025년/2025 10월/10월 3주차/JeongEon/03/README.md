# [백준 - 실버 2] 2477. 참외밭

## ⏰  **time**
30분

## :pushpin: **Algorithm**
시뮬레이션, 구현

## ⏲️ **Time Complexity**
- $O(1)$  
입력은 항상 6줄로 고정되어 있어 상수 시간 처리 가능

## :round_pushpin: **Logic**
1. 참외밭은 육각형이지만, 직사각형에서 한 사각형이 잘린 형태
2. 방향은 1~4 (동서남북), 총 6개의 (방향, 길이) 쌍이 주어짐
3. 각 방향별 등장 횟수 count → 1회 등장하는 방향이 **전체 밭의 외곽**을 구성함
   - 이 중 곱한 두 변은 **큰 사각형 전체 넓이**
4. 잘려나간 내부 작은 사각형은,  
   - 반복하면서 `vp[i].first == vp[i+2].first` 형태로 방향이 반복될 때 중간 길이만 곱해서 구함
   - → 이 작은 사각형 넓이를 빼면 실제 밭의 넓이!
5. `(큰 사각형 넓이 - 작은 사각형 넓이) × K` 출력
```cpp
for (int i = 0; i < 6; i++) {
    if (count[vp[i].first - 1] == 1) {
        total *= vp[i].second;
        continue;
    }
    int next = (i + 1) % 6;
    int nextnext = (i + 2) % 6;
    if (vp[i].first == vp[nextnext].first) {
        small *= vp[next].second;
    }
}
````

## :black_nib: **Review**

* 입력이 6개로 고정되어 있어 구현 부담이 크지 않음
* 규칙을 잘 찾아내는 것이 관건
* 실전에서도 회전 인덱스를 이용한 구현 능력이 중요

## 📡 Link
[https://www.acmicpc.net/problem/2477](https://www.acmicpc.net/problem/2477)
