# [백준 - S1] 10728. XOR삼형제 1 (Nomal)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 브루트포스 알고리즘
- 해 구성하기
- 비트마스킹

## ⏲️**Time Complexity**

$O(2^n*n^3)$

## :round_pushpin: **Logic**

부분집합의 개수를 구하고 비트 마스크로 사용해 각 부분집합을 만들고 부분집합이 생성되면 check(subset) 함수를 호출하여 주어진 XOR 조건을 만족하는지 확인한 후, 현재 부분집합의 크기가 이전에 찾았던 최대 길이 maxLen보다 크다면, maxLen을 갱신하고 result 리스트를 현재 부분집합으로 저장하고 최종적으로 가장 길었던 부분집합 result의 크기와 그 원소들을 출력합니다.

```java
			int maxLen = 0;
            List<Integer> result = new ArrayList<>();

            int totalSubsets = 1 << n;

            for (int i = 1; i < totalSubsets; i++) {
                List<Integer> subset = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        subset.add(j + 1);
                    }
                }

                if (check(subset)) {
                    if (subset.size() > maxLen) {
                        maxLen = subset.size();
                        result = new ArrayList<>(subset);
                    }
                }
            }

		static boolean check(List<Integer> subset) {
        int size = subset.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if ((subset.get(i) ^ subset.get(j) ^ subset.get(k)) == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
```

## :black_nib: **Review**

처음에 부분집합의 XOR 조건을 너무 가볍게 생각하고 단순하게 완전 탐색으로 풀었다가 n=20만 되도 시간초과가 났었다. n=100일때도 시간초과가 나는데 20일때 까지만 통과해도 맞춘걸로 해줘서 더 개선해야할거 같다.

## 📡**Link**

https://www.acmicpc.net/problem/10728
