from collections import deque


S = input() + ' '
isTag = False
tag = ''
stack = []
res = ''

for i in S:
    # 태그 시작인 <가 나옴
    if i == '<':
        for _ in range(len(stack)):
            res += stack.pop()
        isTag = True
        tag += i
        continue
    # 태그 안에 있는 문자일 경우
    if isTag == True:
        tag += i
        if i == '>':
            isTag = False
            res += tag
            tag = ''
    # 일반 문자일 경우
    else:
        if i != ' ':
            stack.append(i)
        else:
            # 스택에서 pop을 해서 뒤집어서 꺼냄
            for _ in range(len(stack)):
                res += stack.pop()
            # 공백 추가
            res += ' '

print(res)
