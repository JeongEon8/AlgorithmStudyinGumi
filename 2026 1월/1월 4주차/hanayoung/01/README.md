# [백준 - S3] 1935. 후위 표기식2

## ⏰  **time**
30분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 스택 정보를 담을 배열 생성 및 top 변수 생성
```java
        int top = -1;
        double[] stack = new double[str.length()];
```
2. 후위표기식 한 자리씩 잘라서 연산자일 경우 연산하고, 아닐 경우 top을 증가시켜 stack에 삽입
3. 연산자일 경우, 현재 top-1 인덱스에 top인덱스 값을 연산하기. 두 개를 뽑아서 계산한 값을 넣기때문에 top-1 인덱스에 연산해서 넣는 방식
```java
        for(int i = 0; i < str.length(); i++) {
            switch(str.charAt(i)) {
                case '+':
                    stack[top-1] += stack[top];
                    top--;
                    break;
                case '-':
                    stack[top-1] -= stack[top];
                    top--;
                    break;
                case '*':
                    stack[top-1] *= stack[top];
                    top--;
                    break;
                case '/':
                    stack[top-1] /= stack[top];
                    top--;
                    break;
                default:
                    stack[++top] = (double)nums[str.charAt(i)-'A'];
            }
        }
```
4. 소수점 두 자리수까지만 출력하기 위해 .2f로 출력
```java
System.out.printf("%.2f\n", stack[top]);
```

## :black_nib: **Review**
- 후위 표기식을 오랜만에 봐서 어떻게 이루어지는지가 좀 어려웠던 문제 ! 푸는 거 자체는 간단했으나 Stack으로 풀던 걸 배열로 풀어보려니 헷갈렸다

## 📡 Link
https://www.acmicpc.net/problem/1929
