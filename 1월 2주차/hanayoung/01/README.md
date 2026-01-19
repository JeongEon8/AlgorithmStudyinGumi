# [백준 - S5] 4673. 셀프 넘버

## ⏰  **time**
20분

## :pushpin: **Algorithm**
구현, 수학

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 셀프넘버인지, 체크했는지 플래그를 담을 배열 생성, 0이 체크안함, 1이 셀프넘버아님+체크함, 2가 셀프넘버임+체크함
```java
int[] nonSelfNum = new int[MAX_NUM+1];
```
2. idx로 숫자 살펴보기. idx가 MAX_NUM과 같을 때까지 반복.
3. 체크하지 않았으면 해당 숫자로부터 만들 수 있는 모든 수 파악.
4. 해당 숫자는 이전에 만들어지지 않았으므로 셀프 넘버이므로 2로 업데이트.
5. 계속해서 더한 숫자인 cal이 MAX_NUM을 넘지 않을 때까지 반복하며 모든 자릿수 더하기
6. cal이 MAX_NUM보다 작고 배열의 값이 0이라면 1로 업데이트하고 아니라면 탈출
```java
        int idx = 1;
        while(idx <= MAX_NUM) {
            if(nonSelfNum[idx] == 0){
                int cal = idx;
                int num;
                nonSelfNum[idx] = 2;
                while(cal <= MAX_NUM) {
                    num = cal;
                    while(num > 0) {
                        cal += num % 10;
                        num /= 10;
                    }
                    if(cal <= MAX_NUM &&nonSelfNum[cal] == 0) nonSelfNum[cal] = 1;
                    else break;
                }
            }
            idx++;
        }
```
7. 1부터 MAX_NUM까지 살펴보며 값이 2이면 StringBuilder에 붙이기
```java
        for(int i = 1; i <= MAX_NUM; i++) {
            if(nonSelfNum[i] == 2) sb.append(i).append("\n");
        }
```

## :black_nib: **Review**
- 처음엔 boolean으로 관리하려했더니 셀프넘버와 체크하지 않은 것에서 제대로 구분이 안돼서 무한루프,,,

## 📡 Link
https://www.acmicpc.net/problem/4673
