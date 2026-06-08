# [SWEA - D3] 01_[S W 문제해결 기본] 10일차 - 비밀번호

## ⏰**time**

30분

## :pushpin: **Algorithm**

스택

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 입력받은 비밀번호를 담을 변수 pwd, 스택형식으로 저장할 answer 변수 생성
   ```
        std::string pwd;
        std::cin >> pwd;

        std::string answer;
   ```
2. pwd를 순회하며 answer의 길이가 0보다 크고 가장 뒷 값이 c와 같다면 제거, 아니라면 뒤에 붙이
```
        for(char c : pwd) {
            if(answer.length() > 0 && answer.back() == c) {
                answer.pop_back();
            } else {
                answer.push_back(c);
            }
        }
```

## :black_nib: **Review**

- 스택처럼 string 사용해서 문제 해결하기!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
