class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();

        // food[0]은 물이므로 제외
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;

            for (int j = 0; j < count; j++) {
                left.append(i);
            }
        }

        return left.toString() + "0" + left.reverse().toString();
    }
}
