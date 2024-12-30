# [백준] 1958. LCS 3


## ⏰ **time**
60분 

## :pushpin: **Algorithm**
DP, 문자열

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
str1현재자리=str2현재자리=str3현재자리라면, 이렇게 일치할 때마다 +1 해준다. <br/>
그러다 현재위치에서 일치하지 않게 되면(=즉, 끊기면) 3개의 lcs값 중 최댓값으로 갱신...
```java
                    if(str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j - 1) == str3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i-1][j-1][k-1]+1; //한 글자씩 일치할 때마다 +1 해줌
                    } else { 
                        //1. str1에서 한 문자 제외하고 계산했을 때의 lcs값
                        //2. str2에서 한 문자 제외하고 계산했을 때의 lcs값
                        //3. str3에서 한 문자 제외하고 계산했을 때의 lcs값
                        //...셋 중 최댓값으로 dp[i][j][k]를 갱신하고 이어나감
                        dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    }
```


## :black_nib: **Review**
코드는 간단하지만 저는 dp가 싫어요 

## 📡**Link**
https://www.acmicpc.net/problem/1958
