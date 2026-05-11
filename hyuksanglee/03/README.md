# [PGS - lv2] 03.소수 찾기

## ⏰**time**

30분

## :pushpin: \*\*Algorith

- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 문자에서 나올수 있는 숫자 조합을 먼저 구하고 TreeSet에 담는다
   - TreeSet에 담는 이유는 중복된 숫자 없이 정렬 시키기 위해
2. 에라토스테네스의 체를 이용해서 소수를 체크한다
3. set에서 하나씩 꺼내서 소수인지 판결하고 소수이면 count해준다.

```java
            public void dfs(int depth, int len, String num){
	        if(depth>=len){
	            return;
	        }
	        
	        for(int i =0; i<len; i++){
	            if(!check[i]){
	                check[i] = true;
	                
	                set.add(Integer.parseInt(num+ arr[i]));
	                dfs(depth+1, len, num+ arr[i]);
	                check[i] = false;
	            }
	        }
	        
	        
	    }
```

```java
             for (int i = 2; i * i <= max; i++) {
                        if (!isNotPrime[i]) {
                            for (int j = i * i; j <= max; j += i) {
                                isNotPrime[j] = true;
                            }
                        }
                    }
```

## :black_nib: **Review**

## 📡 Link
<https://school.programmers.co.kr/learn/courses/30/lessons/42839>
