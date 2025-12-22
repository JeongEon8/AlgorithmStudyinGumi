# [백준 - S3] 16567. 바이너리 왕국

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 애드 혹
- 시뮬레이션
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
연결된 더러운 칼을 블록이라고 할때 새롭게 더러워진 곳의 앞또는 뒤중 더러운 곳이 없으면 블록이 1개가 추가, 1곳이 더러운 곳이 있으면 블록은 유지, 양쪽 다 더러우면 더러운 블록이 연결되므로 한개가 줄어든다.
```java
for (int i = 1; i <= n; i++) {
    int state = Integer.parseInt(st.nextToken());
    if (state == 1) {
        isDirty[i] = true;
        if (!isDirty[i - 1])
            blockCnt++;
    }
}

for (int i = 0; i < m; i++) {
    st = new StringTokenizer(in.readLine());
    int cmd = Integer.parseInt(st.nextToken());
    if (cmd == 0) {
        sb.append(blockCnt).append('\n');
    } else {
        int dirtyIdx = Integer.parseInt(st.nextToken());
        if (isDirty[dirtyIdx])
            continue;
        isDirty[dirtyIdx] = true;
        blockCnt++;
        if (isDirty[dirtyIdx - 1])
            blockCnt--;
        if (isDirty[dirtyIdx + 1])
            blockCnt--;
    }
}
```  
## :black_nib: **Review** 
## 📡**Link**
https://www.acmicpc.net/problem/16567