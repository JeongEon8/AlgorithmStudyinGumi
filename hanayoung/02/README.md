# [SWEA - D?] 02_[S W 문제해결 기본] 3일차 - String

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N^2)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 찾을 패턴과 문자를 저장할 변수 생
   ```
        std::string pattern;
        std::cin >> pattern;

        std::string text;
        std::cin >> text;
   ```
2. 패턴 개수를 담을 변수와 size_t 타입의 변수 생성
```
int answer = 0;
std::size_t pos = 0;
```
3. find를 이용해 위치를 찾고 string::npos가 나타날 때까지 반복하며 answer 업데이트하고  pos에 해당 길이만큼 붙여서 이미 찾은 문자열을 다시 찾지 않게끔 함
```
        while ((pos = text.find(pattern, pos)) != std::string::npos) {
            answer++;
            pos += pattern.length();
        }
```

## :black_nib: **Review**

- 처음에는 find를 안 쓰고 직접 구현했는데 이게 더 코드가 깔끔하다! pos에 길이 붙여서 또 안 찾게 하는 건 처음 써본다

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
