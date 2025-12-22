# [백준 - S4] 1969. DNA

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그리디, 브루트포스

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
A C G T를 key로 하는 딕셔너리를 만든다.
딕셔너리는 같은 위치에 있는 알파벳의 개수를 저장하는 역할을 한다.
n개의 문자열을 2차원 배열에 넣고 
각 리스트의 자리 수에 해당하는 n개의 알파벳의 개수들을 카운트해서 딕서너리에 넣는다.
사전 순서로 value의 최대값을 찾으면 break해서 반복문을 종료하고 결과값에 추가한다.
Hamming distance는 입력한 n에서 value의 최댓값을 뺀 값을 더해주면 된다.

```python
for i in range(m):
    diction = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
    for j in range(n):
        diction[dna_li[j][i]] += 1

    max_value = max(diction.values())

    for key in diction.keys():
        if diction[key] == max_value:
            result_dna.append(key)
            break
    result_num += (n - max_value)
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/1969
