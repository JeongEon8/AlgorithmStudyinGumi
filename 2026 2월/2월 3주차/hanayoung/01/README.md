# [백준 - S4] 10845. 큐

## ⏰  **time**
40분

## :pushpin: **Algorithm**
큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 명령어에 따라 switch문 분기처리
2. "push"일 경우 뒤의 숫자를 삽입
3. "pop"일 경우, 큐의 크기가 0보다 크면 맨 앞의 값 sb에 붙이기, 0이면 -1붙이기
4. "size"일 경우, 큐의 크기를 sb에 붙이기
5. "empty"일 경우, 큐의 크기가 0이면 sb에 1 붙이기, 아니면 0 붙이기
6. "front"일 경우, 큐의 크기가 0이면 sb에 -1붙이고, 아닐경우 가장 앞의 값 붙이기
7. "back"일 경우, 큐의 크기가 0이면 sb에 -1붙이고, 아닐 경우 큐의 크기가 1일 때까지 하나씩 꺼내서 임시 큐에 담기, 마지막 값을 sb에 붙이고 다시 기존 큐에 다 옮겨담기
```java
            switch(st.nextToken()) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    q.add(X);
                    break;
                case "pop":
                    if(q.size() > 0) {
                        sb.append(q.poll());
                    }
                    else sb.append(-1);
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.size() == 0) sb.append(1);
                    else sb.append(0);
                    sb.append("\n");
                    break;
                case "front":
                    if(q.size() == 0) sb.append(-1);
                    else sb.append(q.peek());
                    sb.append("\n");
                    break;
                case "back":
                    if(q.size() == 0) sb.append(-1);
                    else {
                        Queue<Integer> tmp = new LinkedList<>();
                        while(q.size() > 1) {
                            tmp.add(q.poll());
                        }
                        int last = q.poll();
                        sb.append(last);
                        q.addAll(tmp);
                        q.add(last);
                    }
                    sb.append("\n");
                    break;
            }
```
8. sb 출력하기


## :black_nib: **Review**
- 스택처럼 배열로 하고싶었지만 큐라서 잘 안됐다..!

## 📡 Link
https://www.acmicpc.net/problem/10845
