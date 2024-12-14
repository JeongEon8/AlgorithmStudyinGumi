# [백준] 9935. 문자열 폭발


## ⏰ **time**
60분

## :pushpin: **Algorithm**
자료구조, 문자열, 스택 

## ⏲️**Time Complexity**
O(n * m)

## :round_pushpin: **Logic**
word라는 스택에 input문자열을 한글자씩 추가한다. <br/>
폭발문자열(bomb) 글자수 이상이어야 비교가 가능하기 때문에 기다렸다가...<br/>
word의 끝부분, bomb를 비교하여 일치 여부를 match에 저장한다. <br/>
match=true라면 해당 부분 없앰.
```java
        Stack<Character> word = new Stack<>();
        int bombLength = bomb.length();

        for (int i = 0; i < input.length(); i++) {
            word.push(input.charAt(i)); //한글자씩 추가해줌

            if (word.size() >= bombLength) {
                boolean match = true;

                //스택에 저장된 단어 끝부분 / 폭탄 비교
                for (int j = 0; j < bombLength; j++) {
                    if (word.get(word.size() - bombLength + j) != bomb.charAt(j)) {
                        match = false; //일치하지 아니하면 폭탄 없으므로 False처리
                        break;
                    }
                }

                //폭탄 있으면 해당 부분 없앰
                if (match) {
                    for (int j = 0; j < bombLength; j++) {
                        word.pop();
                    }
                }
            }
        }

```


## :black_nib: **Review**
처음에는 stack을 이용하지 않고, 문자열 그대로 검토해서 replace 함수를 썼다. <br/>
그랬더니 오버플로우 나길래 얌전히 스택으로...^^ 

## 📡**Link**
https://www.acmicpc.net/problem/9935 
