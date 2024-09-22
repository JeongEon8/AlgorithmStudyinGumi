# [SWEA - SSAFY Pro 연습4] No5. 메모장 프로그램
 
## ⏰  **time**
6시간

## :pushpin: **Algorithm**
- 구현, 정렬


## :round_pushpin: **Logic**
1. init 단계
   - 입력받은 문자 수, 커서의 위치 변수를 초기화
   - 커서 뒤에 각 알파벳의 개수 받는 배열, 지금까지 입력 받은 리스트 초기화 시켜주기
   -  초기에 mStr로 받는 문자들 알파벳 배열에 해당 알파벳칸을 +1해준다.
2. insert 단계
   - 성별을 char[] -> Int형으로 변경
   - 해당 학년과 성별 칸에 정렬 기준에 맞게 해당 칸에 추가하고 리스트에 추가 한다.
   - size와 커서의 위치를 +1해준다.
        
2. moveCursor 단계
   - 2차원의 좌표로 위치의 데이터를 받는데 (mRow - 1) * W + mCol - 1식으로 1차원에 인덱스 위치로 바꾸어준다.
   - 이동 시킬 커서의 위치가 현재 위치보다 뒤에 있으면 알파벳 배열에서 현재있던 이동한 커서 사이에 알파벳들 수만큼을 빼준다.
   - 앞에 있으면 이동한 커서 사이에 알파벳들 수만큼을 더해준다.
   - 이동 시킬 위치가 입력한 문자 수보다 많을 경우 알파벳 배열을 초기화 시켜주고 커서의 위치는 문자의 수로 바꾸어준다.
      
4. countCharacter 단계
    - 알파벳 배열에서 해당 알파벳칸에 수를 리턴해준다.
```
java
char moveCursor(int mRow, int mCol) {

		char result = '$'; // 커서뒤에 있는 문자 받는 변수

		int move = (mRow - 1) * W + mCol - 1; // 이동할 인덱스의 위치
		if (move < size) {
		if(cursor>move) {
			for(int i = move; i< cursor; i++) {
				alphabet[list.get(i)-'a'] += 1;
			}
		}else if(cursor<move) {
			for(int i = cursor; i< move; i++) {
				alphabet[list.get(i)-'a'] -= 1;
			}
		}
		
			result = list.get(move);
			cursor = move;
		} else {
			cursor = size;
			alphabet = new int[26];
		}

		return result;
	}
```


## :black_nib: **Review**
- 처음에는 countCharacter단계에서 커서위치에서 리스트 끝까지 탐색하면서 값을 리턴하려했지만 시간초과가 떠서 커서를 이동하는 함수에서 계산하게 설정했더니 성공



## 📡 Link
https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AX4uQEB6N6wDFAQm&categoryId=AZEGCEMa7TkDFAQW&categoryType=BATTLE&battleMainPageIndex=1#none
