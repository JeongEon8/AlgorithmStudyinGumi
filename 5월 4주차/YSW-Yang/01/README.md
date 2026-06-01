# [PGS - Lv2] 01_[1차] 뉴스 클러스터링

## ⏰**time**

- 40분

## :pushpin: **Algorithm**

- HashMap
- Set
- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

   ```
        for(int i = 0; i < str1.length() - 1; i++){
            if(str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z' && str1.charAt(i + 1) >= 'A' && str1.charAt(i + 1) <= 'Z'){
                str1HashMap.put(str1.charAt(i) + "" + str1.charAt(i + 1), str1HashMap.getOrDefault(str1.charAt(i) + "" + str1.charAt(i + 1), 0) + 1);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z' && str2.charAt(i + 1) >= 'A' && str2.charAt(i + 1) <= 'Z'){
                str2HashMap.put(str2.charAt(i) + "" + str2.charAt(i + 1), str2HashMap.getOrDefault(str2.charAt(i) + "" + str2.charAt(i + 1), 0) + 1);
            }
        }
        
        for(String key : str1HashMap.keySet()){
            if(str2HashMap.containsKey(key)){
                count1 += Math.min(str1HashMap.get(key), str2HashMap.get(key)); 
            }else{
                count2 += str1HashMap.get(key);
            }
        }
        
        for(String key : str2HashMap.keySet()){
            if(str1HashMap.containsKey(key)){
                count2 += Math.max(str1HashMap.get(key), str2HashMap.get(key)); 
            }else{
                count2 += str2HashMap.get(key);
            }
        }
        
        answer = answer * count1 / count2;
   ```

## :black_nib: **Review**

통과가 되어서 생각을 못했는데 전부 특수문자여서 count2 가 0 일때를 고려하지 못했다. 다시 해야겠다.

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17677
