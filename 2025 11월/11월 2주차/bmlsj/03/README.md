
# [백준- S5] 10814. 나이순 정렬

## ⏰  **time**
10분

## :pushpin: **Algorithm**
구현, 정렬

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

1. 나이순으로 정렬한다
   
```java
static class Person implements Comparable<Person> {
		int age;
		String name;

		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.age, o.age);
		}
}
```

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/10814

