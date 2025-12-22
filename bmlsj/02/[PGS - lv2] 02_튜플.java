import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        
        int[] answer = {};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = null;
        StringBuilder num = new StringBuilder();

        
        for(char c: s.toCharArray()) {
            if (c == '{') {
               arr = new ArrayList<>();
            } else if (c == '}') {
                 if (num.length() > 0) {     // 아직 안 넣은 숫자 있으면 처리
                     arr.add(Integer.parseInt(num.toString()));
                     num.setLength(0);
                 }
                 list.add(arr);
            }  else if (Character.isDigit(c)) { // 숫자
                num.append(c);              
            } else {
                if (num.length() > 0) {     // 숫자 종료 시 리스트에 넣기
                    arr.add(Integer.parseInt(num.toString()));
                    num.setLength(0);
                }
            }
        }
        
        list.sort(Comparator.comparingInt(List::size));
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for(List<Integer> l : list) {
            for(int x: l) {
                if(set.add(x)) {
                    result.add(x);
                }
            }
        }
        return result;
    }
}