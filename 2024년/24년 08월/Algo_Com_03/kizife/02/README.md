# [백준] 13300. 방 배정 
 
## ⏰  **time**
30분 

## :pushpin: **Algorithm**
수학, 구현 

## ⏲️**Time Complexity**
284ms

## :round_pushpin: **Logic**
1. 학생의 성별, 학년에 따른 배열 생성
2. 입력 들어오면 해당 인덱스에 +1 
```java
        for (int i = 0; i < N; i++) {
            int gender = sc.nextInt();
            int grade = sc.nextInt();
            
            arr[gender][grade]++; //각 배열값의 빈도수(해당 학년/성별의 학생 수)
        }
```

3. 각 인덱스당 학생 수를 K로 나누기
4. 이때, 나머지가 0이 아닐 경우(딱 떨어지지 않을 경우) +1
```java
        for(int i=0; i<2; i++) {
            for (int j = 1; j <= 6; j++) {
                count += arr[i][j] / K;
                
                if (arr[i][j]%K != 0) {
                    count++;
                }
            }
        }
```

## :black_nib: **Review**
- 크게 어렵지 않은 문제였다.

## 📡**Link**
- https://www.acmicpc.net/problem/13300 
