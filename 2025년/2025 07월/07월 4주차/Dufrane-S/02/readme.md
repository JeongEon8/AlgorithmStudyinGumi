# [백준- S2] 2607. 비슷한 단어
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 사용된 알파벳 빈도를 배열에 저장해두고 서로 비교하며 차이를 확인
```java
 		for(int i=0;i<n-1;i++){
		    String wordTmp = br.readLine();
		    if(Math.abs(wordTmp.length()-word.length())>1)continue;
		    
		    
		    int[]wordCountTmp = new int[26];
    		for(int j=0;j<wordTmp.length();j++){
    		    wordCountTmp[(int)wordTmp.charAt(j)-65]+=1;
    		}
    		int diff=0;
    		
    		for(int j=0;j<26;j++){
    		    diff+=Math.abs(wordCount[j]-wordCountTmp[j]);
    		}
    		if(wordTmp.length()-word.length()==0)diff--;
    		if(diff<=1)answer++;
		}
```

## :black_nib: **Review**
단어의 길이가 같을 때 한 글자씩 차이나는 것은 상쇄할 수 있으므로 -1 해준다
## 📡**Link**
- https://www.acmicpc.net/problem/2607
