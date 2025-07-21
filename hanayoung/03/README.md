# [백준 - S5] 4659. 비밀번호 발음하기
 
## ⏰  **time**
90분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N×L)$

## :round_pushpin: **Logic**
1. end 나타나면 종료하기
```java
            if ("end".equals(word)) {
                break;
            }
```
2. 모음이 포함되어있으면, 모음 포함 여부 boolean인 containVowel 값 true로 업데이트,
   i가 0보다 클 경우, 현재 char이 모음인데, isVowelSequence가 true이면(연속적인 모음) cnt 값을 증가시키고, 현재 char이 모음인데, isVowelSequence가 false이면 cnt를 1로 업데이트
```java
                if (VOWEL.contains(Character.toString(word.charAt(i)))) {
                    containVowel = true;
                    if (i > 0) {
                        if (isVowelSequence == true) {
                            cnt += 1;
                        } else {
                            cnt = 1;
                        }
                    }
                    isVowelSequence = true;
                } else {
                    if (i > 0) {
                        if (isVowelSequence == false) {
                            cnt += 1;
                        } else {
                            cnt = 1;
                        }
                    }
                    isVowelSequence = false;
                }
```
3. Node 클래스 생성해서 cost로 비교할 수 있게끔 Comparable implements
```java
    static class Node implements Comparable<Node>{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost < o.cost) return -1;
            else return 1;
        }
        
    }
```
4. cnt가 3이상이면 연속된 값이 3번이므로 break
```java
                if (cnt >= 3) {
                    isAccept = false;
                    break;
                }
```
5. 동일한 char가 연속적으로 나타날 경우에도 break
```java
                    if (lastChar == word.charAt(i) && lastChar != 'e' && lastChar != 'o') {
                        isAccept = false;
                        break;
                    }
```

## :black_nib: **Review**
코드 완전 누더기 왜이렇게 오래 걸렸지

## 📡**Link**
- https://www.acmicpc.net/problem/4659
