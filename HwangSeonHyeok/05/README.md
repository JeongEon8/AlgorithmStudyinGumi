# [백준 - S3] 17124. 두 개의 배열

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 정렬
- 이분 탐색

## ⏲️**Time Complexity**

$O(NlogM)$

## :round_pushpin: **Logic**
TreeSet의 floor, ceil을 이용해서 B배열에 있는 a값 이상, 이하의 값을 구하고 a값과 차가 더 작은값 만약 같다면 floor를 우선적으로 답으로 정한다.  
floor, ceil은 null이 나올 수 있으므로 이 경우 큰 값을 넣어 답이 될 수 없게한다.

```java
	TreeSet<Integer> a = new TreeSet<>();
	TreeSet<Integer> b = new TreeSet<>();
	split = in.readLine().split(" ");
	for(int i = 0; i<n;i++){
		a.add(Integer.parseInt(split[i]));
	}
	split = in.readLine().split(" ");
	for(int i = 0; i<m;i++){
		b.add(Integer.parseInt(split[i]));
	}
	long ans = 0;
	for(int aNum:a){
		Integer ceil = b.ceiling(aNum);
		if(ceil==null){
			ceil = (int)2e9;
		}
		Integer floor = b.floor(aNum);
		if(floor==null){
			floor = (int)-1e9;
		}
		if(aNum-floor<=ceil-aNum){
			ans+=floor;
		}else{
			ans+=ceil;
		}
	}
	sb.append(ans).append("\n");
```

## :black_nib: **Review**
이분탐색만 바로 사용하는게 더 빨랐을거 같다.

## 📡**Link**

https://www.acmicpc.net/problem/17124
