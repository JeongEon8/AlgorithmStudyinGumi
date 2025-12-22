n = int(input())
words = []
for _ in range(n):
    words.append(input())
result = 0

for w in words:
    stack = []

    for i in w:
        if not stack:
            stack.append(i)
        elif stack[-1] != i:
            stack.append(i)
        else:
            stack.pop()

    if not stack:
        result += 1

print(result)