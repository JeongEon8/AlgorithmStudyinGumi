# [백준 - S2] 8989. 시계 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 구현
- 정렬
- 시뮬레이션

## ⏲️**Time Complexity**

$O(5log5)$

## :round_pushpin: **Logic**

각도 클래스를 만들어서 시간과 분에 따라 각도를 계산한다 시침은 1시간에 30도이고 1분이 지날때마다 분침은 6도 이동하고 시침은 0.5도 이동하므로 시간당 30(hour % 12) 각도를 갖고 1분에 5.5도를 빼 값의 절대값을 각도로 한다.
해당 시간들의 초를 시간당 3600초를 곱하고 분당 60을 곱한 값을 더해서 해당 시간의 초를 계산한다.
각도로 오름차순 정렬하고 각도가 같으면 해당 시간의 초를 이용해서 오름차순한 후 중앙 값의 시간과 초를 출력한다.

```java
	public static class Angle {
		int hour;
		int minute;
		int second;
		double angle;

		public Angle(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
			this.second = hour * 3600 + minute * 60;
			this.angle = calcAngle(hour, minute);
		}

		private double calcAngle(int hour, int minute) {
			double ang = Math.abs(30 * (hour % 12) - 5.5 * minute);
			return ang > 180 ? 360 - ang : ang;
		}

		public double getAngle() {
			return angle;
		}

		public int getSecond() {
			return second;
		}
	}

	Arrays.sort(angles, Comparator.comparing(Angle::getAngle).thenComparing(Angle::getSecond));
	System.out.printf("%02d:%02d\n", angles[2].hour, angles[2].minute);
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/8989
