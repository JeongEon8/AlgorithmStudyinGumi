# [PGS - Lv2] 02_짝지어 제거하기

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- 스택

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 이전값과 지금 값을 비교하기 위해서 스택을 생성
2. 입력값 s를 for문에서 char형식으로 하나씩 뽑아서 스택을 활용해서 비교
- 스택에 아무것도 없으면 넣고
- 스택에 있을경우 비교해서 같으면 꺼내주고 다르면 스택에 추가를 한다.
3. 스택에 개수가 0이면 다 맞아 떨어져서 제거되었으므로 결과를1로 해주고 아닐경우 0으로 출력
   ```
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            }else{
                if (st.peek() == c){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12973
