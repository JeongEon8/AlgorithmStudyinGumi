# [백준 - 실버 3] 1213. 팰린드롬 만들기
 
## ⏰  **time**
30시간

## :pushpin: **Algorithm**
큐

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. int 배열에 입력받은 값을 하나씩 뽑아서 해당인덱스의 값을 늘린다.
    - A 이면 0, Z이면 25

2. for문을 돌면서 알파벳을 다 검사하는데 홀수개이면 que에 넣는다
    - que에 값이 2이상이면 팰린드롬을 만들수 없으므로 I'm Sorry Hansoo을 출력
  
    - 아니라면 result 배열에 양쪽 부터 채워 넣는다.
       - 0번쨰와 n번쨰, 1번쨰와 n-1번째 
    - que에서 하나 뽑아서 result 배열 가운데 넣는다.
3. result 출력
   
```java
    for(int i = 0; i<26; i++) {
			if(isCount[i]%2!=0) {
				que.add(i);
				isCount[i]-=1;
			}
			if(que.size()>1) {
				isCheck = true;
				break;
			}
			while(isCount[i]>0) {
				result[index]= (char)(i+'A');
				isCount[i]--;
				result[input.length()-1-index++]= (char)(i+'A');
				isCount[i]--;
			}
		}
```

## :black_nib: **Review**
- 실버인데도 너무 어려워요.
- 알고리즘 감 다 잃었음

## 📡 Link
https://www.acmicpc.net/problem/1213
