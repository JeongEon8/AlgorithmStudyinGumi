# [백준] 2839. 설탕 배달 
 
## ⏰  **time**
15분 

## :pushpin: **Algorithm**
 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
while로 반복문 돌려준다... 5킬로그램 봉지 수를 하나씩 줄여서 검토하기 위함.
5킬로 봉지에 담고 남은 것들을 3킬로 봉지에 담아준다...
```java
        while (five >= 0) {
            int num = n - (five * 5);

            if (num % 3 == 0) { 
                three = num / 3;
                result = five + three; 
                break;
            }

            five--; // 5kg 봉지 개수를 하나 줄여서 다시 시도...
        }
```


## :black_nib: **Review**
- 쉽지만, 처음에는 접근을 잘못했다. (단순히 5배수 먼저 때우고 나머지를 3배수로 검토하는 식...) 

## 📡**Link**
- https://www.acmicpc.net/problem/2839 
