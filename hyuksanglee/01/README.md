# [백준 S3] 2108. 통계학
 
## ⏰  **소요 시간**
40분

## :pushpin: **Algorithm**
- 정렬, 구현

## ⏲️**Time Complexity (시간 복잡도)**
$ O(N log N)$

## :round_pushpin: **Logic**
1. 1차원 배열에 for문을 사용해서 N만큼 정수를 넣어주고 입력받은 정수들도 더해서 총합도 구해준다.
2. 산술평균 : 총합에서 N만큼 나누어준다.Math.round() 함수를 사용해서 반올림해줌
3. 중앙값 : 배열을 Arrays.sort()로 정렬해주고 N/2인덱스의 수를 뽑아준다.
4. 최빈값 : count 변수를 만들어 주어서 배열안을 for문을 돌면서 이전 값이랑 같으면 count+1해주고 max변수랑 비교하여 count가 크면 max값 갱신해주고 해당 정수를 담아준다.
   - max변수랑 비교하여 count가 같으면 문제에서 여러개 일경우 두번째 작은 값을 출력해야하므로 check변수가 true일경우 해당 정수로 갱신해주고 check변수를 false로 바꾸어준다.
   - 이전 값이랑 다를경우 count를 1로 초기화 해주고 check변수도 true로 초기화 해준다.
   - max값에 해당하는 정수를 출력해준다.
5. 범위 : 배열의 마지막 값고 첫번째 값을 빼준다.


## :black_nib: **Review**
최빈값 구하는게 너무 힘들었어요

## 📡 Link
https://www.acmicpc.net/problem/2108
