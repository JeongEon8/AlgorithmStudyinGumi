from itertools import combinations

N = int(input())

# 인구수 입력
people = [0] + list(map(int, input().split()))

graph = [[]]
result_min = []
def find(x):
    if x != init[x]:
        init[x] = find(init[x])
    return init[x]

def union(a, b, init):
    root_a = find(a)
    root_b = find(b)

    init[root_b] = root_a



# 인접한 도시 입력
for i in range(N):
    line = list(map(int, input().split()))
    graph.append(line[1:])

# 모든 부분집합 경우의 수 구하기
for i in range(1, N//2+1):
    # 초기화
    init = [i for i in range(1, N + 1)]
    set1_combinations = combinations(init, i)
    for set1 in set1_combinations:
        set1 = list(set1)
        set2 = list(set(init) - set(set1))


        print(set1)
        print(set2)
        # 두 부분집합을 유니온 파인드해서 최상단 부모로 바꿔주는 과정
        for x in range(len(set1) - 1):
            for y in range(x+1, len(set1)):
                union(x, y, init)
        for x in range(len(set2) - 1):
            for y in range(x+1, len(set2)):
                union(x, y, init)
        # for check in list(combinations(set1, 2)):
        #     union(check[0], check[1], init)
        # for check in list(combinations(set2, 2)):
        #     union(check[0], check[1], init)

        count = len(set(init))
        if count == 2:
            value1 = 0
            value2 = 0
            for j in set1:
                value1 += people[j]
            for j in set2:
                value2 += people[j]

            res_value = abs(value2-value1)
            result_min.append(res_value)

if not result_min:
    print(-1)
else:
    print(min(result_min))