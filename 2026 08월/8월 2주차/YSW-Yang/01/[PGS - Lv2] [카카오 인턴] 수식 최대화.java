import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        String[][] priorities = {
            {"+","-","*"},
            {"+","*","-"},
            {"-","+","*"},
            {"-","*","-"},
            {"*","-","+"},
            {"*","+","-"}
        };
        List<Long> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.equals("+") || token.equals("-") || token.equals("*")){
                operations.add(token);
            }else{
                numbers.add(Long.parseLong(token));
            }
        }
        
        for(String[] priority : priorities){
            List<Long> tempNumbers = new ArrayList<>(numbers);
            List<String> tempOperations = new ArrayList<>(operations);
            for(int i = 0; i < 3; i++){
                String currentOperation = priority[i];
                for(int j = 0; j < tempOperations.size(); j++){
                    if(currentOperation.equals(tempOperations.get(j))){
                        long tempRes = calc(tempNumbers.get(j), tempNumbers.get(j + 1), currentOperation);
                        
                        tempNumbers.set(j, tempRes);
                        tempNumbers.remove(j + 1);
                        tempOperations.remove(j);
                        j--;
                    }
                }
            }
            
            long res = Math.abs(tempNumbers.get(0));
            answer = Math.max(answer, res);
        }
        
        return answer;
    }
    
    public long calc(long a, long b, String op){
        if(op.equals("+")){
            return a + b;
        }else if(op.equals("-")){
            return a - b;
        }else{
            return a * b;
        }
    }
}
