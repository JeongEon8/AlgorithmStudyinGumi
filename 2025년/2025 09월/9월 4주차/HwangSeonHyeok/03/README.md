# [백준 - S5] 25325. 학생 인기도 측정

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 자료 구조
- 문자열
- 정렬
- 집합과 맵
- 해시를 사용한 집합과 맵
- 트리를 사용한 집합과 맵
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
학생들의 이름을 index로 치환할 수 있게 Map을 만들어놓고 각각 이름으로 투표를 받으면 배열에서 해당 인덱스의 인기도를 증가시킨다.  
이후 인기순 내림차순, 같은 경우 이름 오름차순으로 정렬한다.

```java
static class Student implements Comparable<Student> {
    String name;
    int popularity;

    public Student(String name) {
        this.name = name;
        this.popularity = 0;
    }

    public void increase() {
        this.popularity++;
    }

    @Override
    public int compareTo(Student o) {
        if (this.popularity != o.popularity) {
            return o.popularity - this.popularity;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}
Map<String, Integer> map = new TreeMap<>();
Student[] students = new Student[n];
for (int i = 0; i < n; i++) {
    String name = st.nextToken();
    map.put(name, i);
    students[i] = new Student(name);
}
for (int i = 0; i < n; i++) {
    st = new StringTokenizer(in.readLine());
    while (st.hasMoreTokens()) {
        String name = st.nextToken();
        students[map.get(name)].increase();
    }
}
Arrays.sort(students);
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25325