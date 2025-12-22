# [프로그래머스 - Lv2] 괄호 변환

## ⏰  **time**
4시간

## :pushpin: **Algorithm**
재귀

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. p의 길이가 0이 되면 반환
2. 이분탐색으로 '('면 left를 오른쪽으로 이동하고 sum 1 감소.')'면 right를 오른쪽으로 이동시키고 sum 1 증가.
3. 만약 sum이 0보다 크다면 ')'가 먼저 나온 것이므로 isRight를 false로 업데이트
4. left와 right가 같다면 index를 i로 업데이트하고 탈출
5. 합계가 0이 아니어도 isRight를 false로 업데이트. isRight가 false인 경우 answer에 '('를 붙이고 index+1부터 자른 문자열을 다시 recur함수로 돌리고 마지막에 ')' 붙이기
6. 문자열을 반대로 뒤집는 작업 수행.
7. isRight가 true였다면 v에 대해 동일한 작업 수행해서 붙이기
```java
    public String recur(String p, String answer) {

        if(p.length() == 0) return answer;
        int left = 0, right = 0, index = 0;
        int sum = 0;
        boolean isRight = true;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                left++;
                sum -= 1;
            }
            else {
                right++;
                sum += 1;
            }
            if(sum > 0) isRight = false;
            if(left == right) {
                index = i;
                break;
            }
        }
        if(sum != 0) isRight = false;
        if(isRight == false) {
            answer += '(';
            answer = recur(p.substring(index+1), answer);
            answer += ')';
            String str = p.substring(1, index);
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(') answer += ')';
                else answer += '(';
            }
        } else {
            answer = recur(p.substring(index+1), answer+p.substring(0, index+1));
        }
        return answer;
    }

```

## :black_nib: **Review**
- 잘 따라가면 됐던 문젠데 뭔가 생각하기 복잡했고 뒤집는다는게 앞뒤로 뒤집는다는줄..!

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/60058
