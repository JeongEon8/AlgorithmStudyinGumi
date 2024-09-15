# [SWEA - SSAFY Pro 연습4] No2. 승강제리그
 
## ⏰  **time**
5시간

## :pushpin: **Algorithm**
- 구현, 정렬


## :round_pushpin: **Logic**
1. init 단계에서 입력 받은 선수들을 해당 리그 배열에 넣어준다.
   - 선수들의 전체수에 리그수를 나누어 수 만큼 각 리그에 선수를 넣어준다.(N/L)
   - 리그 배열 안에는 리스트로 선수의 데이터를 담는다.
      - 선수의 데이터를 넣을때는 리스트에 먼저 들어있는 선수들이랑 비교하여 맞는 인덱스에 값을 넣어준다.
        
2. move 단계에서는 해당 리그에 마지막 선수랑 다음 리드에 첫번째 선수를 교환해준다.
    - 교환해야하는 선수들을 교환될 리그에 큐를 만들어서 해당 선수를 넣어주고 해당 선수의 id를 total변수에 합해준다.
       ex) 1리그에 마지막 선수a는 다음리그로 이동될 2리그에 큐에 담긴다.
    - 큐에 담긴 선수들을 하나씩 뽑아서 해당 리그에 리스트에 있는 선수들과 비교하여 능력과 id에 맞는 위치에 값을 넣어준다.
    - total변수를 리턴 해준다.
      
3. trade 단계에서는 해당 리그에 중간 선수와 다음 리그에 첫번째 선수를 교환한다.
    - 교환해야할 선수를 2번과 같이 해당 리그에 큐에 담아준다.
    - 큐에 담긴 선수들을 하나씩 뽑아서 해당 리그에 리스트에 있는 선수들과 비교하여 능력과 id에 맞는 위치에 값을 넣어준다.
    - total변수를 리턴 해준다.
    - 
```
java
// 값을 추가 할때 크기에 맞게 추가
	public static void insertSort(int l, Player player) {
		int index = 0;
		for (Player p : teamList[l]) {
			if (p.ability > player.ability) {
				index++;
			} else if (p.ability == player.ability) {
				if (p.id < player.id) {
					index++;
				}
			} else {
				break;
			}
		}
		teamList[l].add(index, player);
	}
```

## :black_nib: **Review**
- 처음에 클래스에 Comparable를 사용해서 Arrays.sort를 이용해서 구현했지만 시간초과로 실패했지만 정렬부분 직접구현해서 해결했었요



## 📡 Link
https://swexpertacademy.com/main/code/codeBattle/problemDetail.do?contestProbId=AYH2FcG6secDFATO&categoryId=AZEGCEMa7TkDFAQW&categoryType=BATTLE&battleMainPageIndex=1
