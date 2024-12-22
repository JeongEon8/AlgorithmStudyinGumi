# [백준 - S5] 26265. 멘토와 멘티

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

주어진 정렬규칙에 맞게 compareTo함수를 만들고 정렬하면 되는문제다.

```java
	static class Pair implements Comparable<Pair>{
		String mentor, mentee;

		public Pair(String mentor, String mentee) {
			super();
			this.mentor = mentor;
			this.mentee = mentee;
		}
        
		@Override
		public String toString() {
			return  mentor + " " + mentee;
		}
        
		@Override
		public int compareTo(Pair o) {
			if(this.mentor.equals(o.mentor)) {
				return o.mentee.compareTo(this.mentee);
			}
			return this.mentor.compareTo(o.mentor);
		}	
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/26265
