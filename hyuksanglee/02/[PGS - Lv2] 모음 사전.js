const alpa = ['A','E','I','O','U'];

function solution(word) {
    var answer = 0;
    let count = 0;
    for(const c of alpa){
        let total ="";
        const result = dfs(word, total+c, count+1);
        count = result[1];
        
        // 💡 변수 count 대신 result[1]을 직접 리턴하셔야 안전합니다!
        if(result[0]) return result[1]; 
        
    }
    return answer;
}

function dfs(word, total, count){
    if(word===total){
        return [true,count];
    }
    if(total.length===5){
        return [false,count];
    }
    for(const w of alpa){
        const result = dfs(word,total+w, count+1);
        count = result[1];
        if(result[0]) return [true,count];
    }
    return [false,count];
}
