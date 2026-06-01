# [SWEA - D3] 01_정곤이의 단조 증가하는 수

## ⏰**time**

20분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N^2)$ 

## :round_pushpin: **Logic**

1. arr에 A의 값들 저장
   ```
            int[] arr = new int[N+1];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
   ```
2. 단조증가하는 수가 나오지 않을 경우를 대비해 초기값 -1로 설정
```
int max = -1;
```
3. 모든 조합의 숫자를 비교해야하므로 이중 반복문 사용
```
            for(int i = 0; i < N-1; i++) {
                for(int j = i+1; j < N; j++) {
                    int num = arr[i] * arr[j];
```
4. 끝에서부터 비교하기 시작하여 after에 뒷자리 숫자를 담기, boolean flag를 이용해서 단조증가 수인지 여부 판단
5. num이 0보다 클 때까지 반복하며, num을 10으로 나누고 after보다 num % 10이 더 크면 단조증가수가 아니므로 isMonoIncre false로 값 업데이트하고 탈출
6. 단조증가중이라면 after를 num % 10로 업데이트
```
                    int after = num % 10;
                    boolean isMonoIncre = true;
                    while(num > 0) {
                        num /= 10;
                        if(after < num % 10) {
                            isMonoIncre = false;
                            break;
                        }
                        after = num % 10;
                    }
```
7. 단조증가 수라면 현재 max값과 비교해서 업데이트
```
if(isMonoIncre == true) max = Math.max(max, arr[i]*arr[j]);
```

## :black_nib: **Review**

- 처음에 조합인줄 알고 N이 1000이라서 되나..? 했는데 두 개씩만 비교라서 안 터짐! 문제를 처음에 잘못 이해해서 더 어려운 알고리즘 사용하는줄 알았는데 아니었다...!

## 📡 Link

https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
