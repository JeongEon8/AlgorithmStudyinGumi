# [프로그래머스 - Lv2] 봉인된 주문

## ⏰  **time**
50분

## :pushpin: **Algorithm**
- 정렬

## ⏲️**Time Complexity**
$O(log n)$

## :round_pushpin: **Logic**
1. bans배열을 문자수 작은순, 알파벳 순 으로 정렬
    
    ex) ["d", "e", "bb", "aa", "ae"] ⇒ [”d”, “e”, “aa”, “ae”, “bb”]    
2. 정렬된 bans배열에서 하나씩 꺼내서 해당 알파벳이 몇번째인지 알아낸다.
3. n보다 작으면 total을 하나 증가 시킴
4. n보다 클경우 n - total을 해주고 해당 인덱스에 해당하는 알파벳 찾아준다.
```java
    int len = bans.length;
        Alpha[] alphas = new Alpha[len];
        for(int i = 0; i<len; i++){
            Alpha alpha = new Alpha(bans[i]);
            alphas[i] = alpha;
        }
        Arrays.sort(alphas);
        
        int total = 0;
        for(int i =0; i<len; i++){
            String s = alphas[i].alphabet;
            long index = getIndexOf(s);
            if(index-total <=n){
                total++;
            }else{
                break;
            }
        }
        
        
        
        String answer = getStringAt(n+total);
        return answer;
```
- 해당 문자가 몇번째 인덱스 인지
```java
    static long getIndexOf(String s) {
        long result = 0;
        for (char ch : s.toCharArray()) {
            result = result * 26 + (ch - 'a' + 1);
        }
        return result;
    }
```
- 해당 인덱스에 어떤 문자인지
```java
   static String getStringAt(long n) {
        StringBuilder sb = new StringBuilder();
        long num = n;

        while (num > 0) {
            num -= 1;  
            long remainder = num % 26;
            sb.append((char)('a' + remainder));
            num /= 26;
        }

        return sb.reverse().toString();
    }
```


## :black_nib: **Review**

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/389481
