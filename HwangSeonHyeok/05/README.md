# [백준 - S5] 5635. 생일

## ⏰ **time**

5분

## :pushpin: **Algorithm**

- 구현
- 문자열
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

다음과 같은 학생 클래스를 만들고 정렬후 처음과 마지막 학생의 이름을 출력하면된다.

```java
static class Student implements Comparable<Student>{
	String name;
	int y, m, d;
	public Student(String name, int d, int m, int y) {
		super();
		this.name = name;
		this.y = y;
		this.m = m;
		this.d = d;
	}
	@Override
	public int compareTo(Student o) {
		if(this.y==o.y && this.m==o.m) {
			return o.d-this.d;
		}else if(o.y==this.y) {
			return o.m - this.m;
		}
		return o.y-this.y;
	}

}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/5635
