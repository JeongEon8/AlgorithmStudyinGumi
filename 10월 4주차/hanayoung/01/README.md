# [SWEA - D3] 01_진용이네 주차타워

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N*M)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 주차공간 요금, 차들의 무게를 담을 배열 생성, 주차공간 여부와 차량번호를 담을 배열 두 개 생성, 대기 중인 차량들 담을 큐 생성
   ```
   std::vector<int> costs(n+1); // 주차공간 요금
        std::vector<int> cars(m+1); // 차들의 무게
        std::vector<int> map(n+1, -1); // 주차공간 여부, 존재할 경우 map[주차공간 인덱스] = 차량번호 
        std::vector<int> revMap(m+1); // revMap[차량번호] = 주차공간 인덱스
   std::queue<int> q;
   ```
2. 입력받으며, 주차일 경우와 출차인 경우 분리
3. 출차인 경우, 주차 위치를 revMap을 통해 파악, 큐 사이즈가 0보다 클 경우 대기중인 차량이 있으므로 한 대를 꺼내서 해당 위치에 저장
4. 큐 사이즈가 0일 경우 대기 중인 차량이 없으므로 비우기
5. 주차일 경우 while문을 돌며 index가 가장 작은 곳 찾기, index가 n+1보다 클 경우 q에 넣고, 아닐 경우 answer에 값 더하고 map과 revMap에 넣기
```
            for(int i = 1; i <= 2*m; i++) {
            int op; // op는 차량번호, index는 주차위치
            std::cin >> op;

            if(op < 0) {
                int index = revMap[op*-1];
                if(q.size() > 0) {
                    int top = q.front(); // 차량번호
                    q.pop();
                    map[index] = top;
                    revMap[top] = index;
                    answer += cars[top] * costs[index];
                } else {
                    map[index] = -1;
                    revMap[op*-1] = -1;
                }
            } else {
                int index = 1;
                while(index <= n && map[index] != -1) {
                    index++;
                }
                if(index >= n+1) {
                    q.push(op);
                } else {
                    answer += cars[op] * costs[index];
                    map[index] = op;
                    revMap[op] = index;
                }
            }
        }
```

## :black_nib: **Review**

- 배열이 너무 많아서 못생기지만... 아무튼 해결!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
