dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

T = int(input())
for test_case in range(1, T + 1):

    N = int(input())
    foam = []
    for _ in range(N):
        foam.append(list(map(int, input())))
    center_idx = N//2

    center = N // 2
    total_profit = 0

    for i in range(N):
        start_col = center - abs(center - i)
        end_col = center + abs(center - i)
        total_profit += sum(foam[i][start_col:end_col + 1])
    print(total_profit)