# [백준 - G5] 23349. 졸업 사진

## ⏰ **time**

35분

## :pushpin: **Algorithm**

- 구현
- 자료 구조
- 문자열
- 정렬
- 해시를 사용한 집합과 맵
- 트리를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
학생이 여러버 제출하는 경우 첫번째ㅐ 제출외엔 모두 무시하므로 제출한 학생의 이름을 set에 기록한다. 또 각 장소를 <String,int>인 map에 담는다. value인 int는 0~50000시간까지의 사람 수를 기록하는 배열의 그 장소에 해당하는 index이다. 촬영을 시작하는시간에 +1을 끝나는 시간에 -1을 해서 각 시간대별 사람의 수를 구하여 답을 찾는다.


```java
for(int i = 0; i<n;i++){
	String[] split = in.readLine().split(" ");
	String student = split[0];
	if(!students.contains(student)){
		students.add(student);
		String place = split[1];
		int start = Integer.parseInt(split[2]);
		int end = Integer.parseInt(split[3]);
		if(!map.containsKey(place)){
			map.put(place,cnt++);
		}
		int index = map.get(place);
		times[index][start]++;
		times[index][end]--;
	}
}
static void solve(){
	int max = 0;
	for(String key: map.keySet()){
		int idx = map.get(key);
		int current = 0;
		boolean isMax = false;
		for(int i = 0; i<=50000;i++){
			if(times[idx][i]==0)continue;
			current+=times[idx][i];
			if(current>max){
				ansPlace = key;
				ansStart = i;
				max=current;
				isMax = true;
			}
			if(isMax&&current<max){
				ansEnd = i;
				isMax = false;
			}
		}
	}
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/23349
