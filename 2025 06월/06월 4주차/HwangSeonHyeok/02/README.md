# [백준 - S5] 15702. 중간고사 채점

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 구현
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
문제들을 배점에 맞게 채점하고 정렬한다.  
```java
static class Student implements Comparable<Student> {
    int num, score;

    public Student(int student, int score) {
        super();
        this.num = student;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (this.score == o.score) {
            return this.num - o.num;
        }
        return o.score - this.score;
    }

}

for (int i = 0; i < m; i++) {
    split = in.readLine().split(" ");
    int score = 0;
    for (int j = 1; j <= n; j++) {
        if (split[j].equals("O")) {
            score += questionPoints[j - 1];
        }
    }
    students[i] = new Student(Integer.parseInt(split[0]), score);
}
Arrays.sort(students);
```  
각 북마크까지 이동하는데는 1번필요하므로 (시작~목표까지의 차), (북마크~목표까지의차+1)중에 가장 작은 값을 찾으면된다.
## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/15702