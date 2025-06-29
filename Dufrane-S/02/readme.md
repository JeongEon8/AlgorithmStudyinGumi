# [백준- S4] 2578. 빙고
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- 빙고를 직접 구현, 가로 체크, 세로 체크, 대각선 체크
  
```java
for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                String s = st.nextToken();
                Dot searched = search(Integer.parseInt(s));
                if (!ver[searched.x]) {
                    checkVer(searched.x);
                }
                if (!hor[searched.y]) {
                    checkHor(searched.y);
                }
                if (!inc && searched.y + searched.x == 4) {
                    checkInc();
                }
                if (!dec && searched.y == searched.x) {
                    checkDec();
                }
                answer++;
                if (bingoCount >= 3) {
                    System.out.println(answer);
                    return;
                }
            }
        }
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/2578
