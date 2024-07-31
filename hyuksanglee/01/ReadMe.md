# [백준 - S4] 1920. 수 찾기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
이진 탐색

## ⏲️**Time Complexity**
$O((N+M)logN)$

## :round_pushpin: **Logic**
1. 이진 탐색을 위해 A배열 정렬 시키기
  
2. for문을 사용해서 찾고자 하는 값들 차례대로 이진 탐색
```java
		while(true) {
			if(arr[mid] == n) { // 찾고자하는 값이 있으면 1을 출력하고 종료
				System.out.println(1);
				break;
			}
			
			if(st>ed) { // 시작 점이 끝 점보다 클경우 0을 출력하고 종료
				System.out.println(0);
				break;
			}
			
			if(arr[mid]<n) { // 찾고자하는 값이 중간 값보다 클 경우 
				st = mid +1; // 탐색을 시작 점을 중간 점보다 1크게 설정
			}else { // 찾고자하는 값이 중간 값보다 작을 경우
				ed = mid - 1; // 끝 점을 중간 점보다 1작게 설정
			}
			
			mid = (st + ed) /2; // 변경된 값을 기준으로 중간 점 설정
		}
```

## :black_nib: **Review**
- 메모리가 부족해서 틀렸어요!!
- <img
  src="./public/stamp.PNG"
  width="400"
  height="200"
/>
 <img
  src="./public/stamp.PNG"
  width="400"
  height="200"
/>

  
