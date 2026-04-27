# [백준 - S4] 32331. 원교수님 A+ 주세요

## ⏰ **time**

45분

## :pushpin: **Algorithm**
- 구현
- 문자열
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
우선 김한양을 제외한 A+의 후보가 될 수 있는 2024학번들만 리스트에 담는다.
```java
int minNum = 2024000000;
for (int i = 1; i < n; i++) {
    st = new StringTokenizer(in.readLine());
    studentNum = Integer.parseInt(st.nextToken());
    score = Integer.parseInt(st.nextToken());
    if (studentNum >= minNum) {
        candidateStudents.add(new Student(studentNum, score));
    }
}
```
우선 후보들을 점수를 기준으로 정렬한다.  
후보들중에서 M등부터 A+를 받을 수 있으므로 김한양의 후보중 M등의 예상점수이상을 받기위한 김한양의 기말고사 점수를 찾아낸다. 
```java
Collections.sort(candidateStudents);
int candidateNum = candidateStudents.size();
if (candidateNum >= m) {
    int candidateScore = candidateStudents.get(candidateNum - m).score;
    int predictScore = Math.max(y - (x - candidateScore), 0) + candidateScore;
    int hanayngMax = hanyang.score + y;
    if (predictScore > hanayngMax) {
        System.out.println("NO");
    } else {
        System.out.println("YES");
        System.out.println(Math.max(predictScore - hanyang.score, 0));
    }

} else {
    System.out.println("YES");
    System.out.println(0);
}
```

## :black_nib: **Review** 
문제가 햇갈려요,,

## 📡**Link**
https://www.acmicpc.net/problem/32331