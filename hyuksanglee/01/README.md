# [백준 - G5] 1759. 암호 만들기

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘
- 조합론
- 백트래킹

## ⏲️**Time Complexity**

$O(2^N)$

## :round_pushpin: **Logic**
입력받은 알파벳을 오름차순으로 정렬하고 조합을 찾기위해 재귀함수를 수행한다.  
원하는 길이의 문자열이 나오면 모음의 수를 세어 가능한 암호인지 판별하고 가능하면 출력하였다.

```java
	static boolean isAble(String str){
		int cnt = 0;

		for(int i = 0; i<str.length();i++){
			if(str.charAt(i)=='a' ||
					str.charAt(i)=='e' ||
					str.charAt(i)=='i' ||
					str.charAt(i)=='o' ||
					str.charAt(i)=='u'
			){
				cnt++;
			}
		}

		if(cnt==0||str.length()-cnt<2) {
			return false;
		}
		return true;
	}
	static void solve(int idx, String temp){
		if(temp.length()==L){
			if(isAble(temp)) {
				if (set.contains(temp)) {
					return;
				}
				set.add(temp);
				sb.append(temp).append("\n");
			}
			return;
		}
		if(L-temp.length()>C-idx){
			return;
		}
		for(int i = idx; i<C;i++){
			solve(i+1,temp+alph[i]);
			solve(i+1,temp);
		}
	}
```

## :black_nib: **Review**
백트래킹 조건을 더 걸어서 시간을 줄일 수 있지 않았을까..?  
set으로 검증하는 과정은 필요없다고 생각하는데 가끔 중복된게 문자가 출력된다..  
뭔가 잘못 푼거같긴함함

## 📡**Link**

https://www.acmicpc.net/problem/1759
