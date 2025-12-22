# \[백준 - 골드 5] 1759. 암호 만들기

## ⏰  **time**

50분

## \:pushpin: **Algorithm**

백트래킹

## ⏲️**Time Complexity**

O(C + L)


## \:round\_pushpin: **Logic**

1. 입력 받은 문자 정렬 시키기
2. 처음부터 하나씩 뽑아서 C크기의 배열에 담기
3. 암호가 모음한개이고 자음 2개 포함될 경우 출력


```java
static void back(int count, int index, String result) {
		if(count == L) {
			if(vowel >0 && consonant>1){
				System.out.println(result);
			}
			return;
		}
		for(int j =index+1; j<C; j++) {
			String newSt = result+ ch[j];
			
			
			
			if(ch[j] == 'a'||ch[j] == 'e'||ch[j] == 'i'||ch[j] == 'o'||ch[j] == 'u' ) {
				vowel++;
				
				back(count+1,j, newSt);
				vowel--;
			}else {
				consonant++;
				back(count+1,j, newSt);
				consonant--;
			}
			
			
			
		}
		
		
	}
```


## \:black\_nib: **Review**

* 시간 초과뜰줄 알았는데 아니네요 나이스!!

## 📡 Link

[https://www.acmicpc.net/problem/1759)
