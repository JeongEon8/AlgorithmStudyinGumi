# [PGS - Lv2] 01_전화번호 목록

## ⏰**time**

- 1시간

## :pushpin: **Algorithm**

- 해쉬 맵

## ⏲️**Time Complexity**

$O(N^2)$ 
- for문이 2번 돌기 때문에 n제곱이지 않을까 생각함

## :round_pushpin: **Logic**

 
1. 해쉬 맵으로 전화번호를 set에 넣어준다.
   ```java
    for (String phone : phone_book) {
            set.add(phone);
        }
   ```
2. 다시 for문으로 하나씩 꺼내서 substring를 사용해서 문자를 잘르고 set에 있는지 찾는다
```java
     for (String phone : phone_book) {
            int size = phone.length();
            
            for (int j = 1; j < size; j++) {
                String result = phone.substring(0, j); 
                
                if (set.contains(result)) {
                    return false;
                }
            }
        }
   ```

## :black_nib: **Review**
- 문제를 잘못 이해를 해서 중간에도 있어도 안되는지 알고 풀었다가 시간 초과떠서 Ai 한테 물어보니 중간은 포함 안시키는거래요 


## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42577
