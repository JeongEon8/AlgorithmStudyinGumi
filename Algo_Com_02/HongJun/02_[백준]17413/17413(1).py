from collections import deque


S = input() + ' '
isTag = False
stack = deque()
res = ''

for i in S:
    # 괄호가 시작되면 태그가 시작됨
    # 스택에 있던 요소들을 전부 pop으로 뒤집어서 꺼낸다.
    if i == '<':
        # 스택에 있는 단어 뒤집어서 출력
        for _ in range(len(stack)):
            res += stack.pop()
        isTag = True
        stack.append(i)
        continue
    
    # 문자를 스택에 추가
    stack.append(i)

    # 태그를 닫는 괄호가 나오면
    if i == '>':
        isTag = False
        # 스택에서 그대로 꺼냄
        for _ in range(len(stack)):
            res += stack.popleft()

    # 일반 단어
    if i == ' ' and isTag == False: # 공백이면서 태그가 아님
        # 마지막 공백을 없앰
        stack.pop()
        for _ in range(len(stack)):
            res += stack.pop()
        # 공백 추가
        res += ' '
print(res)