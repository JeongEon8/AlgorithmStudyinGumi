# [PGS - Lv2] 02_뒤에 있는 큰 수 찾기

## ⏰**time**

- 40분

## :pushpin: **Algorithm**

- Stack

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 먼저 answer 배열을 -1로 초기화한다. 이렇게 하면 오른쪽에서 자신보다 큰 수를 끝까지 찾지 못한 경우에도 별도의 처리 없이 -1이 유지된다.
   ```java
        Arrays.fill(answer, -1);
   ```
2. numbers 배열을 순회하면서 아직 자신보다 큰 수를 찾지 못한 인덱스를 stack에 저장한다. 현재 값 numbers[i]가 stack의 최상단 인덱스가 가리키는 값보다 크다면, 현재 값이 해당 원소의 뒤에 있는 큰 수가 된다.
따라서 stack이 비어 있지 않고 numbers[stack.peek()] < numbers[i]인 동안 반복하면서, answer[stack.pop()]에 numbers[i]를 저장한다.
이 과정을 통해 현재 값보다 작은 원소들은 모두 자신의 뒤에 있는 큰 수를 찾게 된다.
반복이 끝나면 현재 인덱스 i를 stack에 추가하여 이후에 등장할 더 큰 수를 기다리도록 한다.
   ```java
        for(int i = 0; i < size; i++){
            while(!stack.isEmpty()){
                if(numbers[stack.peek()] < numbers[i]){
                    answer[stack.pop()] = numbers[i];
                }else{
                    break;
                }
            }
            
            stack.push(i);
        }
   ```

## :black_nib: **Review**

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/154539
