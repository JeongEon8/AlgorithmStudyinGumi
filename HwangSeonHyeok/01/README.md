# [PGS - LV2] 49993. 스킬트리


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 브루트 포스

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
단계별로 올려야하는 스킬이 지금 몇단계를 올릴수 있는지 확인한다.  
그것보다 높은 스킬이 나오면 찍을 수 없다.
```java
for(String tree:skill_trees){
	int current = 1;
	boolean isPossible = true;
	for(int i = 0; i<tree.length();i++){
		char c = tree.charAt(i);
		if(skillRank[c-'A']==current){
			current++;
		}else if (skillRank[c-'A']>current){
			isPossible = false;
			break;
		}
	}
	if(isPossible)answer++;
}
```

## :black_nib: **Review** 

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/49993