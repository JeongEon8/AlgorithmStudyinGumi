# [백준 - S1] 1105. 팔

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현

## ⏲️**Time Complexity**

$O(log(N))$

## :round_pushpin: **Logic**

- N 에 1부터 1씩 증가한 값을 곱해준다. 
- 곱값을 문자열로 바꾸고 chatAt을 사용해서 하나씩 뽑는다.
- 뽑은 값을 0 ~ 10 까지 있는 배열에 해당 인덱스를 true 바꿔서 해당 숫자가 한번 나온것을 표시해준다.
- 배열에서 0 ~ 10 까지 모두 true 이면 N 에 곱한 값을 출력해준다.

```
while(true) {
				int cN = N*i;
				
				String str = cN+"";
				for(int j = 0 ; j <str.length(); j++) {
					int num  = str.charAt(j) -'0';
					isSelected[num] = true;
				}
				
				i++;
				
				boolean check = false;
				for(int j = 0; j<10; j++) {
					if(isSelected[j]== false) {
						check = true;
						break;
					}
				}
				if(!check) {
					break;
				}
				
			}
}
```

## :black_nib: **Review**

## 📡**Link**

https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV18_yw6I9MCFAZN&categoryId=AV18_yw6I9MCFAZN&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=3
