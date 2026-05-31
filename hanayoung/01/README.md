# [SWEA - D3] 01_원재의 메모리 복구하기

## ⏰**time**

40분

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(N^2)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 원래의 메모리 값을 origin에 저장, 초기값을 자릿수만큼 0으로 채워서 생성
   ```
        std::cin >> origin;
        std::string check(origin.size(), '0');
   ```
2. origin과 check의 값이 다른 부분이 나타나면 answer 1 증가, 해당 자리부터 다 뒤집기
```
        for(int i = 0; i < origin.size(); i++) {
            if(check[i] != origin[i]) {
                answer++;
                for(int j = i; j < origin.size(); j++) {
                    check[j] = '0' + ('1' - check[j]);
                }
            }
        }
```
## :black_nib: **Review**

- 그리디일거라고 생각못해서 이상하게 dfs 갔다오느라 오래 걸림 ㅠㅠ 

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
