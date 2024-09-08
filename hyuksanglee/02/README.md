# [백준 - 골드 3] 4386. 별자리 만들기
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
MST

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. 별과 별 사이의 거리를 계산해서 넣어준다.

2. MST를 사용해서 모든 별들의 연결하는데 최소 비용을 구해준다.

3. 구한 최소비용 총합에서 소수 둘째자리까지 반올림해서 출력해준다.
```java
public static void mst(int n) {
		int index = 0;
		float min = INF;
		
		for (int i = 0; i < N; i++) {
			if (n != i) {
				if(isSelected[i]==false) {
					if( minD[i] > distance[n][i]) {
						minD[i]=distance[n][i];
					}
					if(min>minD[i]) {
						min = minD[i];
						index = i;
					}
				}
				
			}
		}
		if(index !=0) {
			isSelected[index]= true;
			result+=minD[index];
			mst(index);
		}
		
	
	}
```

```java
	// 별과 별 사이의 거리를 구하는 식
	public static float math(float a, float b) {
		return (float) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
```

## :black_nib: **Review**
- mst 짜기는 했는데 저렇게 짜는게 맞을까요?

## 📡 Link
https://www.acmicpc.net/problem/4386
