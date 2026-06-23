import heapq
def solution(n, k, enemy):
    answer = 0
    
    pq = []
    for i, e in enumerate(enemy):
        heapq.heappush(pq, e)
        if len(pq) > k:
            n -= heapq.heappop(pq)
            
            if n < 0:
                return i
        
        
    return len(enemy)