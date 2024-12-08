# [SWEA] 1824. 혁진이의 프로그램 검증 


## ⏰ **time**
120분 

## :pushpin: **Algorithm**


## ⏲️**Time Complexity**
O(n * m * 64)

## :round_pushpin: **Logic**
명령어에 따라 이동 수행하며, 메모리 정수를 바꾸기를 반복한다.
@에 도달할 수 있으면 YES 출력, 아니면 NO 출력이 기본 로직...
스택에 넣었다 빼면서 확인한다.

```java
stack.push(new State(startX, startY, startMemory, startDir));
 
        while (!stack.isEmpty()) {
            State current = stack.pop();
            int x = current.x;
            int y = current.y;
            int memory = current.memory;
            int dir = current.dir;
 
            // 범위 벗어나면 반대편으로
            if (x < 0) x = n - 1;
            if (x >= n) x = 0;
            if (y < 0) y = m - 1;
            if (y >= m) y = 0;

...

            stack.push(new State(x + dx[dir], y + dy[dir], memory, dir));
        }
 
        return false; //다 봤는데 @ 도달 못 하면 false
    }
```

## :black_nib: **Review**
로직은 간단한데 stack 넣었다 뺐다... 
stack 안 썼더니 오버플로우 발생.

## 📡**Link**
[https://www.acmicpc.net/problem/20166 ](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4yLUiKDUoDFAUx)
