t = int(input())
for _ in range(t):
    key = input()

    stack = []  # 출력될 문자열
    tmp = []   # 커서 이동 시 문자 임시 보관
    for i in key:

        # 커서 왼쪽 이동 = stack에서 꺼내서 임시 보관
        if i == '<':
            # 입력한 문자열이 있을 때만 실행
            if stack:
                s = stack.pop()
                tmp.append(s)

        # 커서 오른쪽 이동 = 임시 보관에서 pop해서 stack에 넣기
        elif i == '>':
            # 임시에 문자가 있을 떄만
            if tmp:
                s = tmp.pop()
                stack.append(s)

        # 삭제
        elif i == '-':
            # 입력한 문자열이 있을 때만
            if stack:
                stack.pop()

        else:
            stack.append(i)

    # 임시 저장에 있는거 빼서 입력에 넣기
    while tmp:
        stack.append(tmp.pop())
        
    print(''.join(stack))