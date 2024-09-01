# [백준 - s5] 2057. 팩토리얼 분해

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘
- 브루트포스 알고리즘

## :round_pushpin: **Logic**

n>=2에서 n! >= (n-1)! + (n-2)! +... + 0!이므로 그리디하게 입력 N>=n!에서 큰 팩토리얼부터 그리디하게 빼가면된다.

입력 N의 최대값이 1,000,000,000,000,000,000이므로 19! = 121,645,100,408,832,000이므로 19!에서부터 돌면된다.


n=0일땐 No인것은 예외처리해줘야한다.

```java
   for (int i = 19; i >= 0; i--) {
            if (n >= factorial[i]) {
                n -= factorial[i];
            }
        }
        if (n == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

```

## :black_nib: **Review**

처음엔 비트마스킹으로 20개의 조합을 만들어 계산할까 했는데 팩토리얼 표를 보고 그리디하게 접근했다.  
실제로 알고리즘 분류가 그리디였다.

## 📡**Link**

https://www.acmicpc.net/problem/2057
