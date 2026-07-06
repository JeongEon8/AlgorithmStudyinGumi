def solution(citations):
    citations = sorted(citations)
    ans = 0
    
    for i in range(len(citations)):
        remains = len(citations) - i
        if citations[i] >= remains:
            ans = remains
            break
            
    return ans