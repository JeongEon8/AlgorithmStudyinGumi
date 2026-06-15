# [PGS - LV2] 154539. 뒤에 있는 큰 수 찾기

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 스택

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
각 배열의 인덱스를 스택에 넣고 더 큰 수를 만나면 스택에서 꺼내서 기록한다.
```java
int[] answer = new int[n];
for(int i = 0; i<n; i++){
    answer[i] = -1;
}
Stack<Integer> st = new Stack<>();
for(int i = 0; i<n; i++){
    while(!st.isEmpty() && numbers[st.peek()]<numbers[i]){
        int idx = st.pop();
        answer[idx] = numbers[i];
    }
    st.push(i);
}
```

## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/154539