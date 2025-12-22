from collections import Counter

def solution(k, tangerine):
    answer = 0
    
    counter = Counter(tangerine)
    counts = sorted(counter.values(), reverse=True)
    
    total = 0
    for c in counts:
        total += c
        answer += 1
        if total >= k:
            break
    
    return answer