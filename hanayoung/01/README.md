# [SWEA - D3] 01_이진수 표현

## ⏰**time**

- 10분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 마지막 N비트가 모두 1로 켜져있는지 확인하기 위해서 2로 나눴을 때 나머지 확인
2. 2로 나눈 나머지가 0이면 bool 값 false로 업데이트 후 탈출
3. 1일 경우 M을 2로 나누어 이어서 진행
```cpp
        bool isOn = true;
        for(int i = 0; i < N; i++) {
            if(M % 2 == 0) 
            {
                isOn = false;
                break;
            }
            M /= 2;
        }
```

## :black_nib: **Review**

- 뭔가 더 있나? 했는데 간단한 문제였다 야호!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
