# [백준] 1052. 물병


## ⏰ **time**
30분

## :pushpin: **Algorithm**
수학, 비트마스킹 

## ⏲️**Time Complexity**
O(n)

## :round_pushpin: **Logic**
2진수로 변환한 값에서의 1의 개수가, 최종 물병의 개수라는 사실을 아시나요? <br/>
가령 물병이 7병 있다고 치면 2진수로는 111이죠? <br/>
이것은 먼저 4병을 2병으로, 2병을 1병으로 압축해 "1" <br/>
남은 3병 중 2병을 1병으로 압축해 또 "1" <br/>
남은 1병으로 그냥 "1" <br/>
총 3병으로 압축 가능함을 뜻합니다~ <br/>
이게 k병을 넘으면 안 되겠죠? <br/>
k 이하로 압축할 수 있을 때까지 물병을 추가해 줄 겁니다. 
```java
        int addCount = 0; //추가해야 할 물병의 개수

        while (Integer.bitCount(n) > k) {
            //Integer.bitCount(n)란?? 2진수에서 1의 개수를 반환함
            n++;
            addCount++;
        }
```


## :black_nib: **Review**
로직만 알면 날로 먹는 골드 

## 📡**Link**
https://www.acmicpc.net/problem/1052
