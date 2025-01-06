# [백준 - S3] 20291. 파일 정리

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 자료 구조
- 문자열
- 정렬
- 해시를 사용한 집합과 맵
- 트리를 사용한 집합과 맵
- 파싱

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

확장자를 사전순으로 출력해야하므로 TreeMap을 사용하여 값을 저장하면된다.  
.을 기준으로 파싱하여 확장자를 key, 갯수를 세어준다.

```java
	TreeMap<String, Integer> map = new TreeMap<String, Integer>();
	for(int i = 0; i<n;i++) {
		String[] split = in.readLine().split("\\.");
		String ext = split[1];
		if(map.containsKey(ext)) {
			map.replace(ext,map.get(ext)+1);
		}else {
			map.put(ext,1);
		}
	}
	for(Entry<String, Integer> entry:map.entrySet()) {
		System.out.println(entry.getKey()+" "+entry.getValue());
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/20291
