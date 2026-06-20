# [PGS - Lv2] 01_[3차] 파일명 정렬

## ⏰**time**

- 50분

## :pushpin: **Algorithm**

- 정렬
- 문자열

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

1. 먼저 head의 대소문자를 구별하지 않기 때문에 head를 전부 대문자로 바꿔주고 head를 기준으로 오름차순 정렬하고 head가 같다면 num기준으로 오름차순 정렬, num이 같다면 들어온 순서인 index순으로 정렬하도록 해준다. 
   ``` java
    @Override
    public int compareTo(Info other){
        String thead = this.head.toUpperCase();
        String ohead = other.head.toUpperCase();
        
        if(thead.equals(ohead)){
            if(this.num == other.num){
                return Integer.compare(this.index, other.index);
            }
            return Integer.compare(this.num, other.num);
        }
        
        return thead.compareTo(ohead);
    }
   ```

2. num 기준으로 head와 tail을 나눠주고 있어서 num의 처음 시작부분과 끝부분을 찾아 head와 num을 구해서 Info 객체를 넘겨준다.
   ``` java
    public Info division(String file, int index){
        String head = "";
        int num = 0;
        
        int size = file.length();
        int left = -1;
        for(int i = 0; i < size; i++){
            if((file.charAt(i) >= '0' && file.charAt(i) <= '9')){
                left = i;
                break;
            }
        }
        
        int right = left;
        while(right < size && (file.charAt(right) >= '0' && file.charAt(right) <= '9')) {
            right++;
        }
        
        head = file.substring(0, left);
        num = Integer.parseInt(file.substring(left, right));
        
        return new Info(file, head, num, index);
    }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/17686?language=java
