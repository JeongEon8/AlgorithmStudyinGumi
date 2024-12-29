# [SWEA] 문자열 교집합

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- set

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- HashSet을 활용해서 첫번째 집합의 값을 넣어주고 두번쨰 집합을 입력 받을떄는 set에 있는지 확인하고 있으면 result를 1증가시킨다.
- 마지막으로 result를 출력해준다.
```java
 Set<String> firstSet = new HashSet<>();
            int result = 0;

            // 첫 번째 문자열 리스트 삽입
            String[] firstInput = in.readLine().split(" ");
            for (String str : firstInput) {
                firstSet.add(str);
            }

            // 두 번째 문자열 리스트 탐색
            String[] secondInput = in.readLine().split(" ");
            for (String str : secondInput) {
                if (firstSet.contains(str)) {
                    result++;
                }
            }
```

## :black_nib: **Review**
- 처음에는 트라이로 풀었는데 시간 초과뜨더라구요
- 이렇게 간단한 방법이 있었는데 너무 어렵게 생각했어요

## 📡**Link**

https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AV-Un3G64SUDFAXr&categoryId=AY1INdsqPvADFAWX&categoryType=BATTLE&battleMainPageIndex=1
