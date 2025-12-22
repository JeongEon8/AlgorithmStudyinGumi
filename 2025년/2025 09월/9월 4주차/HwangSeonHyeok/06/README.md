# [백준 - S5] 33846. 삽입 정렬을 해볼까

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
삽입정렬은 앞 인덱스부터 순차적으로 정렬하는 알고리즘이므로 t-1까지만 따로 정렬하고 그 뒤에 정렬안된 리스트를 그대로 붙이면 된다.
```java
List<Integer> list = new ArrayList<>();
st = new StringTokenizer(in.readLine());
for (int i = 0; i < n; i++) {
    list.add(Integer.parseInt(st.nextToken()));
}
List<Integer> sortedList = list.subList(0, t);
Collections.sort(sortedList);
StringBuilder sb = new StringBuilder();
for (int num : sortedList) {
    sb.append(num).append(" ");
}
for (int i = t; i < n; i++) {
    sb.append(list.get(i)).append(" ");
}
```  
## :black_nib: **Review** 
이름은 삽입 정렬인데 이렇게 푸는게 맞나..?
## 📡**Link**
https://www.acmicpc.net/problem/33846