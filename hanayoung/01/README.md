# [백준 - S4] 10866. 덱

## ⏰  **time**
40분

## :pushpin: **Algorithm**
구현, 자료구조

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 명령어에 따라 switch문 분기처리
2. "push_front"일 경우 앞에 숫자를 삽입
3. "push_back"일 경우 뒤에 숫자 삽입
4. "pop_front"일 경우, 큐의 크기가 0보다 크면 맨 앞의 값 sb에 붙이기, 0이면 -1붙이기
5. "pop_back"일 경우, 큐의 크기가 0보다 크면 맨 뒤의 값 sb에 붙이기, 0이면 -1붙이기
6. "size"일 경우, 큐의 크기를 sb에 붙이기
7. "empty"일 경우, 큐의 크기가 0이면 sb에 1 붙이기, 아니면 0 붙이기
8. "front"일 경우, 큐의 크기가 0이면 sb에 -1붙이고, 아닐경우 가장 앞의 값 붙이기
9. "back"일 경우, 큐의 크기가 0이면 sb에 -1붙이고, 아닐 경우 큐의 크기가 1일 때까지 하나씩 꺼내서 임시 큐에 담기, 마지막 값을 sb에 붙이고 다시 기존 큐에 다 옮겨담기
```java
            switch(st.nextToken()) {
                case "push_front":
                    tmp.clear();
                    X = Integer.parseInt(st.nextToken());
                    tmp.add(X);
                    tmp.addAll(q);
                    q.clear();
                    q.addAll(tmp);
                    break;
                case "push_back":
                    X = Integer.parseInt(st.nextToken());
                    q.add(X);
                    break;
                case "pop_front":
                    if(q.size() > 0) sb.append(q.poll()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "pop_back":
                    if(q.size() > 0) {
                        tmp.clear();
                        while(q.size() > 1) {
                            tmp.add(q.poll());
                        }
                        sb.append(q.poll()).append("\n");
                        q.addAll(tmp);
                    } else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.size() == 0) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(q.size() > 0) sb.append(q.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "back":
                    if(q.size() > 0) {
                        tmp.clear();
                        while(q.size() > 1) {
                            tmp.add(q.poll());
                        }
                        int last = q.poll();
                        sb.append(last).append("\n");
                        q.addAll(tmp);
                        q.add(last);
                    } else sb.append(-1).append("\n");
                    break;
            }
```
10. sb 출력하기


## :black_nib: **Review**
- 스택처럼 배열로 하고싶었지만 큐라서 잘 안됐다..! 무언가 시간복잡도 낭비중인거 같긴 하다만...

## 📡 Link
https://www.acmicpc.net/problem/10866
