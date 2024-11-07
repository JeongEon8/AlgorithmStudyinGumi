A, B = map(str, input().split())

len_a = len(A)
len_b = len(B)

answer = 0
# 두 문자열의 길이가 같을 때는 바로 비교
if len_a == len_b:
    for i in range(len_a):
        if A[i] != B[i]:
            answer += 1
# 다를 때는 경우를 생각해서 비교
else:
    n = len_b - len_a
    MIN = 50

    for i in range(n+1):  # 0 1 2
        answer = 0
        tmp = B[i:i+len_a]
        for i in range(len_a):
            if A[i] != tmp[i]:
                answer += 1
        MIN = min(MIN, answer)
    answer = MIN

print(answer)