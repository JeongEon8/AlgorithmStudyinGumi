# [PGS - Lv1] 02_제일 작은 수 제거하기

## ⏰**time**
5분

## :pushpin: **Algorithm**
벡터

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 가장 작은 수의 인덱스를 저장한다.
2. 저장된 인덱스를 erase 함수를 통해 지운다.
3. 지웠을 때, arr이 비었다면, -1을 넣는다.
   ```cpp
    for(int i = 0; i < size; i++){
        if(arr[smallest] > arr[i]){
            smallest = i;
        }
    }
    
    arr.erase(arr.begin() + smallest);
    if(arr.empty()){
        arr.push_back(-1);
    }
   ```

## :black_nib: **Review**
- 집에 스탠바이미가 생겼는데 말이죠?
- 진짜 드라마를 엄청 봐요.

## 📡 Link
[프로그래머스 Lv1 제일 작은 수 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12935)
