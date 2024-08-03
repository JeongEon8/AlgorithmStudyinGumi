import sys
input = sys.stdin.readline


n1, n2 = map(int, input().split())
first = list(input().strip())
second = list(input().strip())

t = int(input())
# 첫 번째 그룹을 뒤집어서 하나의 개미 배열로 만듦
ant = first[::-1] + second

for _ in range(t):
    # 전체 개미의 수에서 -1만큼 반복
    for i in range(n1+n2-1):
        # 서로 붙어있는 개미가 각각 다른 그룹일 때 바꿔줌
        if ant[i] in first and ant[i+1] in second:
            # 자리 바꾸기
            tmp = ''
            tmp = ant[i]
            ant[i] = ant[i+1]
            ant[i+1] = tmp
            # ant[i], ant[i+1] = ant[i+1], ant[i] 이렇게도 가능

            # 반복문을 멈취기 위한 break 조건
            # 첫 번쨰 그룹의 맨 앞이 자리가 바뀌었을 떄 멈춤
            # first[0]인 이유
            # 앞에서 부터 하나씩 자리를 바꾸다 보면 맨 마지막에 위치가 변경되기 때문
            if first[0] == ant[i+1]:
                # print(ant[i], ant[i+1])
                # print("멈춰!")
                break
print(''.join(ant))