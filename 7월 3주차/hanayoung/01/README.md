# [SWEA - D3] 01_퍼펙트 셔플

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 중간부분 찾기
   ```
   int st = (N % 2 == 0) ? N/2 : N/2+1;
   ```
2. N/2 지점까지 반복하며, 순서대로 출력하기
```
        for (int i = 0; i < N/2; i++) {
            std::cout << word[i] << ' ';
            std::cout << word[st+i] << ' ';
        }
```
3. 홀수 길이라면 빠진 부분 같이 출력
```
 if(N % 2 == 1) std::cout << word[N/2];
```

## :black_nib: **Review**

- 구현 굿 ~

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
