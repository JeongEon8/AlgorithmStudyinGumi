# [백준 - G5] 17609. 회문

## ⏰  **time**
80분

## :pushpin: **Algorithm**
투포인터

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. T개의 테스트케이스만큼 for문 반복, 정답은 sb에 append, 회문확인 isPalindrome 호출
```java
int start = 0, end = str.length() - 1;
int answer = 0; // 0은 회문, 1은 유사, 2는 아님

answer = isPalindrome(str, start, end, 0);
sb.append(answer).append("\n");
```
2. 문자열, start, end, 회문여부를 나타내는 answer를 파라미터로 갖는 isPalindrome 함수
3. start가 end보다 크거나 같으면 answer 반환
4. start와 end 위치의 char가 같으면 인덱스를 이동시켜서 isPalindrome 함수 호출
5. 다를 경우, 문자를 삭제한 적이 없고(answer == 0) 왼쪽이나 오른쪽 중 하나를 이동시켜서 확인한 문자가 같으면 함수 호출
6. leftMove나 rightMove가 1이면 유사회문으로 가능한 경우이므로 flag = 1로 업데이트
7. 아니라면 flag = 2 로 업데이트 후 flag 반환
```java
    static int isPalindrome(String str, int start, int end, int answer) {
        if(start >= end) return answer;
        int flag = 0;
        if (str.charAt(start) == str.charAt(end)) {
            flag = isPalindrome(str, start+1, end-1, answer);
        } else {
            int leftMove = 0;
            int rightMove = 0;
            if (answer == 0 && str.charAt(start + 1) == str.charAt(end)) {
                leftMove = isPalindrome(str, start+2, end-1, 1);
            } 
            if (answer == 0 && str.charAt(start) == str.charAt(end - 1)) {
                rightMove = isPalindrome(str, start+1, end-2, 1);
            }
            if(leftMove == 1 || rightMove == 1) flag = 1;
            else flag = 2;
        }
        return flag;
    }
```


## :black_nib: **Review**
- 투 포인터랑 친해지기 ! 왼쪽 오른쪽 둘 다 확인하는 방법 생각하느라 오래 걸린 문제 ㅠㅠ

## 📡**Link**
- https://www.acmicpc.net/problem/17609
