# [SWEA - D3] 01_수의 새로운 연산

## ⏰**time**

40분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$ (시간 복잡도를 작성해주세요.)

## :round_pushpin: **Logic**

1. 짝꿍 찾는 코드, first와 second의 합이 일정하고, cnt가 1씩 증가한다는 점을 이용하여 pair 설정
   ```
   std::pair<int, int> getPair(int num) {
    int cur = 1;
    int prev = 0;
    int cnt = 1;
    std::pair<int, int> pair;
 
    while(1) {
        if(num >= prev && num < cur) {
            pair = {1+num-prev, cnt -1 -num + prev};
            break;
        }
        prev = cur;
        cur += cnt;
        cnt++;
    }
    return pair;
}
   ```
2. pair값으로 순번 찾는 코드, sum이 도달할 때까지 돌며 찾고 하나씩 값을 옮기며 최종값 찾기
```
int getNum(std::pair<int, int> pair) {
    int sum = 1;
    int d = pair.first + pair.second - 1;
    for(int i = d-1; i >= 1; i--) {
        sum += i;
    }
    while(d > pair.second) {
        d--;
        sum++;
    }
    return sum;
}
```

## :black_nib: **Review**

- 규칙찾는 데에 조금 헷갈려서 걸렸지만 해결!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
