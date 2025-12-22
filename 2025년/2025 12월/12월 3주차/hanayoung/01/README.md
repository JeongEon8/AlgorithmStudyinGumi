# [백준 - S4] 10828. 스택

## ⏰  **time**
10분

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. List<Integer> 타입의 변수 생성
```java
List<Integer> stack = new ArrayList<>();
```
2. N개의 명령어를 처리할 때까지 for문 탐색 진행.
3. command를 읽어서 switch 문으로 처리
4. push일 경우 추가적인 token 탐색하며 리스트에 추가. pop일 경우 크기 확인하여 가장 뒤의 값을 sb에 붙이고 해당 값을 제거.
5. size일 경우 리스트의 크기 sb에 추가. empty일 경우 리스트의 사이즈를 확인하여 0보다 클 경우 0 붙이고 아닐 경우 1 붙이기.
6. top일 경우 리스트의 크기를 확인하여 가장 마지막 값을 sb에 붙이고 리스트 크기가 0일 경우 -1 붙이기.
```java
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();
            switch(command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.add(x);
                    break;
                case "pop":
                    if(stack.size() > 0) {
                        sb.append(stack.get(stack.size()-1)).append("\n");
                        stack.remove(stack.size()-1);
                    }
                    else sb.append("-1").append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(stack.size() > 0) sb.append("0").append("\n");
                    else sb.append("1").append("\n");
                    break;
                case "top":
                    if(stack.size() > 0) sb.append(stack.get(stack.size()-1)).append("\n");
                    else sb.append("-1").append("\n");
                    break;
            }
        }
```

## :black_nib: Review
- 시키는 대로만 하면 됐던 실버 문제 야호 !

## 📡**Link**
- https://www.acmicpc.net/problem/10828
