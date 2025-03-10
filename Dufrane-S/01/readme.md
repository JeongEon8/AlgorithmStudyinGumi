# [백준 - S1] 25956. 목차 세기

## ⏰ **time**

90분

## :pushpin: **Algorithm**

- 스택

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 새로 들어온 제목이 스택의 top보다 크면 그냥 넣고 작으면 자신보다 작은 top이 나올 때까지 pop
2. pop 과정에서 제목 갯수를 카운트해서 넣어주기

```java
	 for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());  // 입력
            
            if (stack.isEmpty() || stack.peek().level <= tmp) { 
                if (before + 1 < tmp) {  
                    System.out.println("-1");
                    return;
                }
                before = tmp;  
                
                stack.push(new StackItem(tmp, i));
                

                if (tmp > 0) {
                    v[tmp - 1]++;
                }
            } else {
                before = tmp;  
                
                while (!stack.isEmpty() && tmp <= stack.peek().level) {
                    StackItem item = stack.pop();
                    answers[item.index] = v[item.level];
                    v[item.level] = 0;           
                }
                
                stack.push(new StackItem(tmp, i));
                
                if (tmp > 0) {
                    v[tmp - 1]++;
                }
            }
        }

        while (!stack.isEmpty()) {
            StackItem item = stack.pop();
            answers[item.index] = v[item.level];
            v[item.level] = 0;
        }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/25956
