# [SWEA - D3] 02_원재의 메모리 복구하기

## ⏰**time**

30분

## :pushpin: **Algorithm**

(알고리즘을 작성해주세요.)

## ⏲️**Time Complexity**

$O(N^2)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 원래의 문자열과 확인할 0으로 채운 문자열 생성
   ```
std::string origin;
 std::string check(origin.size(), '0');
   ```
2. origin을 순회하며 둘이 같지 않으면 answer 증가
3. 해당 인덱스의 check에 뒤집은 값 넣기
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

- 처음에는 너무 복잡하게 생각했지만 간단한 문제였고 ! 더 나은 해결법이 있다고 하는데 함 츄라이..!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
