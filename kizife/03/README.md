# [백준] 2661. 좋은 수열 


## ⏰ **time**
90분

## :pushpin: **Algorithm**
백트래킹

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
1, 2, 3 안에서 현재 자리에 숫자를 배정한다. 그리고 계속 좋은 수열 여부 검사. <br/>
'현재까지 만들어진 단어 기준' 반까지만 탐색한다. (대칭 여부를 보는 거니까) <br/>
그 범위 안에서 대칭인 부분이 있는지 검사... 
```java
    public static boolean checkArr(int length) {
        for (int i = 1; i <= length/2 ; i++) {
            boolean same = true;
            for (int j = 0; j < i; j++) {
                if (arr[length-2*i+j] != arr[length-i+j]) {
                    same = false;
                    break;
                }

            }
            if (same ) return false; //나쁜 수열이면 false
        }
        return true; //좋은 수열이면 true
    }
```

## :black_nib: **Review**
백트래킹이 싫어요 어려워요 코드는 어렵지 않지만 뇌가 안 돌아가요 

## 📡**Link**
https://www.acmicpc.net/problem/2661
