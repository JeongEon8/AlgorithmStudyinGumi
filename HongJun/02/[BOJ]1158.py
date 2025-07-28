n, k = map(int, input().split())
li = [i for i in range(1, n + 1)]

cycle = k - 1  # 리스트 인덱스 번호를 고려한 주기
result = []
temp = 0  # 리스트에서 꺼낸 값

for i in range(n):
    if len(li) > cycle:  # 리스트의 길이가 주기보다 더 큼
        temp = li.pop(cycle)
        result.append(temp)  # 리스트에 해당 주기의 수 빼서 result에 넣음
        cycle = cycle + k - 1
    else:  # 리스트 길이보다 cycle이 더 큼
        cycle = cycle % len(li)  # 현재 cycle에서 리스트 길이만큼 나누고 그 나머지가 cycle이 됨
        temp = li.pop(cycle)
        result.append(temp)
        cycle = cycle + k - 1

print('<', ', '.join(str(i) for i in result), '>', sep='')