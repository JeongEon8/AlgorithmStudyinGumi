# \[백준 - 실버 3] 20920. 영단어 암기는 괴로워

## ⏰  **time**

15분

## \:pushpin: **Algorithm**

정렬 + 맵(빈도 집계)

## ⏲️**Time Complexity**

\$O(N \log U)\$

* $U$: 길이 $\ge M$ 인 서로 다른 단어 수
* 맵 조회/갱신 $O(\log U)$ × $N$ + 정렬 $O(U \log U)$

## \:round\_pushpin: **Logic**

1. 단어를 입력받되, **길이 < M**이면 버림.
2. 길이 조건을 통과한 단어들만 맵으로 **빈도 수**를 집계.
3. 벡터에 `({빈도, 길이}, 단어)` 형태로 담고 **사용자 정의 비교함수**로 정렬:

   1. **빈도 내림차순**
   2. **길이 내림차순**
   3. **사전순 오름차순**
4. 정렬된 벡터에서 단어만 순서대로 출력.

```cpp
bool compare(pair<pair<int,int>,string> a, pair<pair<int,int>,string> b){
    if (a.first.first != b.first.first)   // 빈도
        return a.first.first > b.first.first;
    if (a.first.second != b.first.second) // 길이
        return a.first.second > b.first.second;
    return a.second < b.second;           // 사전순
}
```

### 핵심 구현 포인트

* 맵에 처음 등장한 단어면 `({1, len}, word)`를 벡터에 push하고,
  이미 존재하면 해당 인덱스의 **빈도만 증가**.
* 최종적으로 벡터를 위 비교 기준으로 정렬 후 출력.

## \:black\_nib: **Review**

* 조건이 세 가지라 비교 함수만 정확히 쓰면 나머지는 깔끔하게 해결!
* 맵에서 인덱스를 함께 관리해 벡터 원소의 빈도만 올리는 방식이 메모리/시간 모두 효율적이었다.

## 📡 Link

[https://www.acmicpc.net/problem/20920](https://www.acmicpc.net/problem/20920)
