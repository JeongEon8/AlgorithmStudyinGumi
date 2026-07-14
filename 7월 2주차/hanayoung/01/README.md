# [SWEA - D3] 01_한빈이와 Spot Mart

## ⏰**time**

30분

## :pushpin: **Algorithm**

투 포인터

## ⏲️**Time Complexity**

$O(NlogN)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 간식 정보를 담고, 투 포인터 알고리즘 사용 위해서 정렬
   ```
        std::vector<int> snacks(N);

        for (int i = 0; i < N; i++) {
            std::cin >> snacks[i];
        }
        std::sort(snacks.begin(), snacks.end());
   ```
2. 투 포인터 알고리즘 적용
3. left가 right와 같아질 때까지 반복, left번째의 snack과 right번째의 snack의 합이 M보다 크면 right을 왼쪽으로, 아니라면 left를 오른쪽으로 이동시키고 answer 중 가장 큰 값으로 업데이트
```
        int left = 0;
        int sum = 0;
        int right = N-1;

        while(left < right) {
            sum = snacks[left] + snacks[right];
            if(sum > M) {
                right--;
            } else {
                left++;
                answer = std::max(answer, sum);
            }
        }

```

## :black_nib: **Review**

- 투 포인터 사용하는 문제 오랜만 ! 등호가 헷갈렸음

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
