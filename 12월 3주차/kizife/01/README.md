# [백준] 1062. 가르침


## ⏰ **time**
40분

## :pushpin: **Algorithm**
브루트포스 

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**
일단 a, n, t, c, i 이 다섯 개는 기본적으로 배운다고 생각하면 된다. <br/>
그러면 배울 수 있는 최대 단어 수 = k-5겠지...<br/>

list에 '배워야 할 문자'를 저장한다. <br/>
그 문자들을 최대한 배우고 나서 learned에 추가, 읽을 수 있는 단어 수를 찾는다...끝
```java
        //두 수가 같아지면 읽을 수 있는 단어 개수 구함 
        if (depth == maxDepth) {
            max = Math.max(max, countWords(words, learned));
            return;
        }

        for (int i = index; i < list.size(); i++) {
            learned.add(list.get(i)); //순서대로 하나씩 배우기
            combine(list, learned, words, i + 1, depth + 1, maxDepth);
            learned.remove(list.get(i));
        }
```

```java
        for (String word : words) {
            boolean readable = true;
            for (char ch : word.toCharArray()) {
                if (!learned.contains(ch)) { //배우지 않은 문자면
                    readable = false; //버린다...
                    break;
                }
            }
            if (readable) count++;
        }
```


## :black_nib: **Review**
이것도 마음만 먹으면 날로 먹는 골드4! 

## 📡**Link**
https://www.acmicpc.net/problem/1062
