# [백준 - G4] 1253.좋다

## ⏰  **time**
4시간

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. 체크했는지 여부와 등장 횟수를 저장하기 위한 class 정의
```java
    static class Good {

        int count;
        boolean isGood;

        public Good(int count, boolean isGood) {
            this.count = count;
            this.isGood = isGood;
        }
    }
```
2. 해시에 삽입
```java
            if (value != null) {
                hashMap.put(num, new Good(value.count + 1, false));
            } else {
                hashMap.put(num, new Good(1, false));
            }
```
3. 서로 다른 두 수의 합이 해시맵에 존재하고, 체크한 적 없는지 확인
4. arr[i]와 arr[j]가 0인데, 해시맵에 0의 count가 2이면, sum은 arr[i]와 arr[j]와 다른 수가 아니므로 continue
5. arr[i]와 arr[j] 중 0이 하나인데, 해시맵에 sum의 count가 1이면 0이 아닌 arr[i]나 arr[j]와 다른 수가 아니므로 continue
6. answer에 합계의 count를 더하고 true로 변경
```java
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if(i == j) continue;
                int sum = arr[i] + arr[j];
                Good value = hashMap.get(sum);
                if (value != null && value.isGood == false) {
                    if(arr[i] == 0 && arr[j] == 0 && value.count == 2) continue;
                    else if((arr[i] == 0 || arr[j] == 0) && value.count == 1) continue;
                    answer += value.count;
                    hashMap.put(sum, new Good(value.count, true));
                }
            }
        }
```

## :black_nib: **Review**
- 원래는 이분탐색으로 풀고싶어서 도전했다가 갑자기 해시에 꽂혀서 해결하고 싶어서 왕왕 오래 걸린 문제...


## 📡**Link**
- https://www.acmicpc.net/problem/1504
