# [백준] 5557. 1학년


## ⏰ **time**
60분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
현재까지 계산한 결과, i값을 만들 수 있는 경우의 수를 저장하기 위해 dp[i]형태의 배열을 만든다. <br/>
다음 수를 더하거나 뺀 결과가 0~20 범위 내에 있다면 dp에 경우의 수를 더해준다.<br/>
dp[마지막 숫자]를 출력한다.
```java
                if (dp[j]>0) { //j를 만들 수 있는 경우가 존재하면
int plus = j + arr[i]; //더하기의 결과
int minus = j - arr[i]; //빼기의 결과

                    if(plus<=20) { //더해서 20 안 넘으면
next[plus] += dp[j]; //경우의 수 추가
        }
        if(minus>=0) { //빼서 0 이상이면
next[minus] += dp[j]; //경우의 수 추가
        }
        }
```


## :black_nib: **Review**
나는 dp가 싫어요!

## 📡**Link**
https://www.acmicpc.net/problem/5557
