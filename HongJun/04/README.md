# [백준 - S3] 1966. 프린터 큐

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현, 큐, 자료구조

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

```python
for _ in range(t):
    n, m = map(int, input().split())    # 문서 개수, 찾을 문서
    import_list = list(map(int, input().split()))       # 중요도 입력
    index_list = list(i for i in range(1, n+1))     # 찾을 문서 위치
    index_list[m] = 'target'        # 찾을 문서 m번 째를 target으로
    idx = 0     # 프린트 순서

    while 1:
        # import 리스트에서 첫 번째 값이 최대값이면 pop
        if import_list[0] == max(import_list):
            idx += 1    # 프린트 순서 다음으로

            if index_list[0] == 'target':   # 출력순위가 최댓값이고
                                            # target이 맨 앞에 위치해있으면 출력 
                print(idx)
                break
            else:
                index_list.pop(0)
                import_list.pop(0)

        else:   # 첫 번째 값이 최대값이 아님 -> 맨 앞을 pop하고 맨 뒤로 옮김
            import_list.append(import_list.pop(0))
            index_list.append(index_list.pop(0))
```


## :black_nib: **Review**  


## 📡**Link**
https://www.acmicpc.net/problem/1966
