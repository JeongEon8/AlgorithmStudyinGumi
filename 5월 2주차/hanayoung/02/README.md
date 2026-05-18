# [SWEA - D3] 02_진기의 최고급 붕어빵

## ⏰**time**

20분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(T×NlogN)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 팔 수 있는지 여부를 담는 변수와 현재까지 판매한 붕어빵 개수 담을 변수 선언
   ```
   boolean canSold = true;
   int sold = 0;
   ```
2. 손님들이 도착하는 시간을 담은 배열 생성 및 정렬
```
            int[] customers = new int[N];
            for(int i = 0; i < N; i++) {
                customers[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(customers);
```
3. (손님 도착시간 / M) * K가 현재까지 만들어진 붕어빵 개수이며, 판매한 붕어빵 개수 빼면 현재 남은 붕어빵 개수
4. 해당 개수가 0보다 작거나 같으면 팔 수 없으며 중단, 팔 수 있으면 sold++
```
            for(int i = 0; i < N; i++) {
                int arrTime = customers[i]; // 손님 도착시간
                int check = (arrTime / M) * K - sold;
                if(check <= 0) {
                    canSold = false;
                    break;
                }
                sold += 1;
            }
```
5. canSold에 따라 출력형식 sb에 append
```
            if(canSold) sb.append("#").append(tc).append(" Possible\n");
            else sb.append("#").append(tc).append(" Impossible\n");
```

## :black_nib: **Review**

- 구현 좋아! sold를 따로 저장안하고 그냥 i+1을 빼도 될 듯..?

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
