# [백준 - S4] 18258. 큐2

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 큐

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 그냥 조건에 맞게 코드 작성하면 됨

```java
	if (input.startsWith("push")) {
                queue.offer(Integer.parseInt(input.split(" ")[1]));
            } else if (input.equals("pop")) {
                
                if(queue.isEmpty()) {
                	sb.append("-1\n");
                }else {
                	sb.append(queue.pop()).append("\n");
                }
            } else if (input.equals("size")) {
            	sb.append(queue.size()).append("\n");
            } else if (input.equals("empty")) {
            	if(queue.isEmpty()) {
            		sb.append(1).append("\n");
                }else {
                	sb.append(0).append("\n");
                }
            } else if (input.equals("front")) {
            	if(queue.isEmpty()) {
            		sb.append("-1\n");
                }else {
                	sb.append(queue.peekFirst()).append("\n");
                }
            } else if (input.equals("back")) {
            	if(queue.isEmpty()) {
            		sb.append("-1\n");
                }else {
                	sb.append(queue.peekLast()).append("\n");
                }
            }
```

## :black_nib: **Review**
- 하나씩 출력을 하니깐 시간초과 뜸

## 📡**Link**

https://www.acmicpc.net/problem/18258
