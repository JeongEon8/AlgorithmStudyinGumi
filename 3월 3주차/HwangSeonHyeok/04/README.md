# [백준 - S3] 9996. 한국이 그리울 땐 서버에 접속하지

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 문자열


## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
*앞의 선행 문자열과 뒤의 후열 문자열을 나누고 문자열의 길이가 선행과 후열의 길이 합이상이면 DA일 수 있으므로 앞의 문자열과 선행 문자열과 같고 가장 뒤 문자열과 후행 문자열이 같은 경우 DA이다.  
```java
String[] query = in.readLine().split("\\*");
int prelength = query[0].length();
int postlength = query[1].length();
for (int i = 0; i < n; i++) {
	boolean isDA = false;
	String text = in.readLine();
	if (text.length() >= prelength + postlength) {
		String pre = text.substring(0, prelength);
		String post = text.substring(text.length() - postlength);
		if (pre.equals(query[0]) && post.equals(query[1])) {
			isDA = true;
		}

	}
	if (isDA) {
		sb.append("DA\n");
	} else {
		sb.append("NE\n");
	}

}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/9996
