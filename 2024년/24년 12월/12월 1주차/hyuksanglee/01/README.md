# [SWEA] K번째 문자열
 
## ⏰  **time**
3시간

## :pushpin: **Algorithm**
trie

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. 입력받은 문자열을 charAt을 활용하여 1개씩 뽑는다.
2. Trie 클래스에 트리의 같은 레벨에 해당 문자가 있으면 넘어가고 없으면 노드를 추가 해준다.
3. 노드가 추가 될때 마다 부모 노드에 자식 개수 추가 해준다.
4. dfs를 사용하여 a~z까지 순차적으로 찾아준다.
5. 찾을때 마다 K를 감소 해준다
6. K가 0이 되면 해당 알파벳까지 값 출력

   ```
   java
       class KTrie{
		char alphabet;
		int cnt=0;
		Map<Character, KTrie>chidren = new TreeMap<Character, KTrie>();
		
		KTrie(char alphabet){
			this.alphabet = alphabet;
		}
		
		KTrie(){
			}
	}
   ```

## :black_nib: **Review**
- 너무 어려줘요

## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18KWf6ItECFAZN&categoryId=AV18KWf6ItECFAZN&categoryType=CODE&problemTitle=K%EB%B2%88%EC%A7%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
