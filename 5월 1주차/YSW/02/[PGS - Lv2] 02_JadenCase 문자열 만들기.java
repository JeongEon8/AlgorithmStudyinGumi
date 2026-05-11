class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        String[] arr = s.split("");
        
        boolean isFirst = true;
        for(String word : arr){
            sb.append(isFirst ? word.toUpperCase() : word);
            
            isFirst = word.equals(" ") ? true : false;
        }
        
        return sb.toString();
    }
}