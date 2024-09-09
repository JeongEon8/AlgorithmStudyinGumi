# [백준 - s1] 21314. 민겸 수

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 그리디 알고리즘

## :round_pushpin: **Logic**

M은 K와 결합하는게 최대이고 M끼리만 결합될때가 최소이다.  
최소인 경우 뒤에서 K를 만나더라도 M끼리만결합+5를 해주면된다.

```java
    	for(int i = 0;i<mk.length();i++) {
			if(mk.charAt(i)=='M') {
				continuousM++;
			}else {
				if(continuousM == 0) {
					maxAns += '5';
					minAns += '5';
				}else {
					maxAns += '5';
					minAns += '1';
					for(int j = 0; j<continuousM-1;j++) {
						maxAns+='0';
						minAns+='0';
					}
					maxAns+='0';
					minAns+='5';
					continuousM = 0;
				}
			}
		}
		if(continuousM!=0) {
			minAns+='1';
			for(int i = 0; i<continuousM-1;i++) {
				minAns+='0';
				maxAns+='1';
			}
			maxAns+='1';
		}

```

## :black_nib: **Review**

M을 단독으로 쓸지 K와 연결해서 쓸지를 그리디하게 판단해주는 문제였다.  
for문이 끝나고 마지막 m들의 처리에서 MMM등이 100, 111같이 최대 최소에 따라 2가지 종류인데 1가지 종류로 처리해서 틀렸었다.

## 📡**Link**

https://www.acmicpc.net/problem/21314
