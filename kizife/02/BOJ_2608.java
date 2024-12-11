import java.util.Scanner;

public class BOJ_2608 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        int arabic1 = toArabic(num1);
        int arabic2 = toArabic(num2);
        int sum = arabic1 + arabic2;

        System.out.println(sum);
        System.out.println(toRoman(sum));
    }

    // 로마->아라비아숫자
    static int toArabic(String num) {
        int result = 0; //변환값 초기화
        int prevValue = 0; //이전에 검토한 값 저장

        for (int i = num.length() - 1; i >= 0; i--) { //오른쪽 자리부터 검토함
            int currentValue = getRomanValue(num.charAt(i)); //해당 자리의 값
            if (currentValue < prevValue) { //이전값보다 작으면
                result -= currentValue; //빼줘야 한다
            } else {
                result += currentValue; //아니면 더해주고...
            }
            prevValue = currentValue;
        }

        return result;
    }

    //아라비아->로마숫자
    static String toRoman(int num) {
        int[] arabicNums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanChars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder(); //변환값 저장할 객체

        for (int i = 0; i < arabicNums.length; i++) {
            while (num >= arabicNums[i]) { //arabicNums 현재자리 값보다 num이 크면
                roman.append(romanChars[i]); //해당 Char 추가해줌
                num -= arabicNums[i]; //num에서는 그 값을 뺌
            }
        }

        return roman.toString(); //결과값 반환
    }

    //로마자를 변환함
    static int getRomanValue(char a) {
        switch (a) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new RuntimeException("오류");
        }
    }
}
