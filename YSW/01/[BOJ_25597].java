import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_25597 {
	public static class ButtonPressRecord {
		int startTime;
		int buttonType;

		public ButtonPressRecord(int startTime, int buttonType) {
			this.startTime = startTime;
			this.buttonType = buttonType;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int targetDistance = Integer.parseInt(inputs[0]);
		int targetTime = Integer.parseInt(inputs[1]);
		int remainTime = targetTime;
		int[] D = { 1, 4, 8 };
		int eightDiv = 0;
		int fourDiv = 0;
		int oneDiv = 0;
		int count = 0;

		if (targetDistance % 8 == 0 && targetDistance / 8 <= targetTime) {
			eightDiv = targetDistance / 8;
		} else if (targetDistance % 4 == 0 && targetDistance / 4 <= targetTime) {
			fourDiv = targetDistance / 4;
		} else if (targetDistance / 1 <= targetTime) {
			oneDiv = targetDistance / 1;
		} else if ((targetDistance % 8) % 4 == 0 && (targetDistance / 8) + ((targetDistance % 8) / 4) <= targetTime) {
			eightDiv = targetDistance / 8;
			targetDistance %= 8;
			fourDiv = targetDistance / 4;
		} else if ((targetDistance % 8) % 1 == 0 && (targetDistance / 8) + (targetDistance % 8) <= targetTime) {
			eightDiv = targetDistance / 8;
			targetDistance %= 8;
			oneDiv = targetDistance;
		} else if (((targetDistance % 8) % 4) % 1 == 0
				&& (targetDistance / 8) + ((targetDistance % 8) / 4) + ((targetDistance % 8) % 4) <= targetTime) {
			eightDiv = targetDistance / 8;
			targetDistance %= 8;
			fourDiv = targetDistance / 4;
			targetDistance %= 4;
			oneDiv = targetDistance;
		} else {
			System.out.println(-1);
			return;
		}

		int[] arr = { oneDiv, fourDiv, eightDiv };
		List<ButtonPressRecord> records = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (arr[i] != 0) {
				count++;
				records.add(new ButtonPressRecord(remainTime - arr[i], D[i]));
				remainTime -= arr[i];
			}
		}
		sb.append(count + "\n");

		for (int i = records.size() - 1; i >= 0; i--) {
			ButtonPressRecord record = records.get(i);
			sb.append(record.startTime + " " + record.buttonType + "\n");
		}

		System.out.println(sb.toString());
	}
}