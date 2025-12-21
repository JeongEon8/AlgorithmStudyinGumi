# [백준 - S5] 1316. 그룹 단어 체커

## ⏰  **time**
10분

## ⏲️**Time Complexity**
$O(N*L)$

## :round_pushpin: **Logic**
1. N개의 단어를 탐색
2. alpha라는 크기 26의 배열을 생성하여 나타남 여부 확인
3. 전체 str을 탐색하며, 이전의 값과 다르고 alpha배열의 prev-'a' 인덱스 값이 false이면 나타난 적이 없으므로 true 처리. 값이 true이면 연속한 값과 제외로 나타난 적이 있다는 것이므로 isGroup을 false 처리하고 빠져나가기
4. 그리고 prev 값을 현재 str의 j번째 문자로 업데이트
5. 마지막 값이 체크가 되지 않았으므로 alpha의 prev-'a' 인덱스 값이 나타난적이 있는지를 확인하여 마지막으로 isGroup 여부 확인
6. isGroup이 true일 경우 answer++
```java
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            boolean[] alpha = new boolean[26];
            boolean isGroup = true;
            char prev = str.charAt(0);
            for(int j = 1; j < str.length(); j++) {
                if(prev != str.charAt(j)) {
                    if(alpha[prev-'a'] == false) {
                        alpha[prev-'a'] = true;
                    } else {
                        isGroup = false;
                        break;
                    }
                    prev = str.charAt(j);
                }
            }
            if(alpha[prev-'a'] == true) isGroup = false; 
            if(isGroup == true) {
                answer++;
            }
        }
```

## :black_nib: Review
- boolean 배열을 이용해서 확인하기! 마지막 값을 확인안했다가 틀려버리기!

## 📡**Link**
- https://www.acmicpc.net/problem/1316
