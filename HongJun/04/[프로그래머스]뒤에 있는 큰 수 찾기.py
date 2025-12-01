def solution(numbers):
    lng = len(numbers)
    answer = [-1 for _ in range(lng)]
    stack = []

    for i in range(lng):
        while stack and numbers[stack[-1]] < numbers[i]:
            answer[stack.pop()] = numbers[i]
        stack.append(i)

    return answer