function solution(clothes) {
    var answer = 1;
    const map ={};
    for(const [name, type] of clothes){
        map[type] = (map[type] || 0) +1;
    }
    
    
    for(const count of Object.values(map)){
        answer *= (count+1)   
    }
    return answer-1;
}
