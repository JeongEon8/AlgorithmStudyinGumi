import java.util.*;

public class Main {
    static class Person {
        String name;
        int day, month, year;

        Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();

            people.add(new Person(name, day, month, year));
        }

        // 생년월일 기준 정렬 (늦게 태어난 사람이 앞으로 오게)
        people.sort((a, b) -> {
            if (a.year != b.year) return b.year - a.year;
            if (a.month != b.month) return b.month - a.month;
            return b.day - a.day;
        });

        System.out.println(people.get(0).name); // 가장 어린 사람
        System.out.println(people.get(people.size() - 1).name); // 가장 나이 많은 사람
    }
}
