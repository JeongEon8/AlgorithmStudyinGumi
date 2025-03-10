# [백준] 1339. 단어 수학 


## ⏰ **time**
80분

## :pushpin: **Algorithm**
그리디 알고리즘 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
특정 알파벳이 탐지될 때마다, 해당 자리수(?)를 누적합 해서 가중치를 계산한다.
```java
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char ch = word.charAt(i);
                int weight = (int) Math.pow(10, length-i-1); //몇의자리숫자인지?? int화
                map.put(ch, map.getOrDefault(ch, 0) + weight);
            }
        }
```
<br/>가중치가 높은 순으로 정렬해서 저장(list). <br/>
가중치가 높은 알파벳순으로 9부터 차례대로 숫자 삽입. 
```java
        int num = 9;
        for (Map.Entry<Character, Integer> entry : list) {
            assignMap.put(entry.getKey(), num--);
        }
```

## :black_nib: **Review**
재미있었어요 

## 📡**Link**
https://www.acmicpc.net/problem/1339
