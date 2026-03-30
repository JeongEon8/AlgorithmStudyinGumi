# [백준 - S4] 26043. 식당메뉴

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 자료 구조
- 정렬
- 큐

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
각 학생들을 큐로 줄세우고 나오는 메뉴에따라 원하는 메뉴인지, 싫어하는 메뉴인지 확인하고 리스트에 넣는다.  
각각의 정렬을 정렬하고 프린트한다.
```java
for (int i = 0; i < n; i++) {
StringTokenizer st = new StringTokenizer(in.readLine());
int type = Integer.parseInt(st.nextToken());
if (type == 1) {
    int num = Integer.parseInt(st.nextToken());
    int like = Integer.parseInt(st.nextToken());
    q.add(new Student(num, like));
} else {
    int menu = Integer.parseInt(st.nextToken());
    Student nextStudent = q.poll();
    if (nextStudent.likeMenu == menu) {
        happy.add(nextStudent.num);
    } else {
        unHappy.add(nextStudent.num);
    }
}
}
```
## :black_nib: **Review**

## 📡**Link**
https://www.acmicpc.net/problem/26043