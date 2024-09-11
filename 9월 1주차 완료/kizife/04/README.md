# [SWEA] 1221. [S/W 문제해결 기본] 5일차 - GNS   
 
## ⏰  **time**
15분 

## :pushpin: **Algorithm**
 

## ⏲️**Time Complexity**
513 ms

## :round_pushpin: **Logic**
- list에 문자열 미리 저장해준다.
  ```java
  	private static void add() {
		list = new ArrayList<>();
		list.add("ZRO");
		list.add("ONE");
		list.add("TWO");
		list.add("THR");
		list.add("FOR");
		list.add("FIV");
		list.add("SIX");
		list.add("SVN");
		list.add("EGT");
		list.add("NIN");
	}
  ```

- 입력되는 단어가 list에 저장된 단어와 동일할 경우, 해당 list의 인덱스를 number에 저장함.
  ```java
  				for (int k = 0; k <= 9; k++) {
					if (input.equals(list.get(k))) {
						number.add(k);
					}
				}
  ```
  
- number를 오름차순 정렬한다.
- number의 요소들을 순차적으로 꺼내면서, 해당 인덱스에 해당하는 list의 단어를 출력한다.
  ```java
  			for (int j = 0; j < number.size(); j++) {
				int index = number.get(j);
				
				System.out.print(list.get(index) + " "); 
			}
  ```

## :black_nib: **Review**
-  ArrayList와 Collections.sort만 안다면 쉽게 풀 수 있는 문제였다.

## 📡**Link**
- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD
