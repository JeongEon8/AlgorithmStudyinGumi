# [프로그래머스 -L2] 연속된 부분 수열의 합

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 배열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 입력 받은 배열안에 숫자를 하나씩 뽑아낸다.

2. 그 숫자를 k랑 비교해서 크면 넘긴다.

3. 작으면 total 변수에 합해주고 count 변수에 숫자를 1증가 시킨다.

4. total이 k보다 크면 작아질때까지 제일 마지막에 total에 합한 값을 빼준다.
   	- index변수를 만들어서 뺄때마다 index값 증가 해준다.

5. total 값이랑 k값이 같고 count 값이 최소이면 index변수와 현재 배열에서 뽑은 인댁스를 저장 한다.
   


```java
for(int i= 0; i<sequence.length; i++){
            if(k<sequence[i]){
                break;
            }
            total+= sequence[i];
            count+=1;
            while(total>k){
                total-= sequence[index++];
                count--;
            }
            if(total==k && minC>count){
                minC=count;
                answer[0]= index;
                answer[1] = i;
            }
        }
```

## :black_nib: **Review**
so easy !!

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/178870?language=java
