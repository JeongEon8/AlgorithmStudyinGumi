# [SWEA - D3] 02_삼성시의 버스 노선

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 버스들 거치는 횟수 담기, 시작과 끝지점을 받아서 그 사이 모두 bus[]++
   ```
    std::vector<int> bus(5001);

        for (int i = 0; i < N; i++) {
            int st, end;
            std::cin >> st >> end;
            for(int j = st; j <= end; j++) {
                bus[j]++;
            }
        }
   ```
2. 요구하는 버스 번호들의 값 출력
```
        for (int i = 0; i < P; i++) {
            int idx;
            std::cin >> idx;
            std::cout << bus[idx] << ' ';
        }
```
## :black_nib: **Review**

- 다른 방법으로 해볼까했으나 이 방법이 버스 정류장 수가 적어서 해결 ..!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
