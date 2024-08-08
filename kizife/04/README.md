# [백준] 2605. 줄 세우기
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
192ms

## :round_pushpin: **Logic**
1. 학생 수만큼 자리 배정을 반복한다.
```java
for (int i = 1; i <= N; i++)
```

2. seat은 학생들이 뽑은 자리 번호이다. 계산된 인덱스의 위치는 i  - 1 - seat
3. j=i-1 : 배열의 마지막 인덱스 위치는 j, 이후 index위치까지 줄어들며 반복
4. arr[j] = arr[j-1] : j에서의 값을 j-1위치의 값으로 밂
5. arr[index] = 1 : index 위치에 현재 학생 배치 
```java
for (int i = 1; i <= N; i++) {
    int seat = sc.nextInt();
    int index = i - 1 - seat;
    for (int j = i - 1; j > index; j--) {
        arr[j] = arr[j - 1];
    }
    arr[index] = i; //계산된 위치에 현재 학생 배치
}
```

## :black_nib: **Review**
- 어제 푼 건데 사실 무슨 로직으로 풀었는지 기억이 안 난다...다시 풀어야 할 듯 

## 📡**Link**
- https://www.acmicpc.net/problem/2605
