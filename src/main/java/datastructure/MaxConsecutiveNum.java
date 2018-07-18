package datastructure;

public class MaxConsecutiveNum {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 3, 3, 1 };
		System.out.println(new MaxConsecutiveNum().findMaxConsecutiveNumber(arr));
	}

	public int findMaxConsecutiveNumber(int[] nums) {
		int maxHere = 0, max = 0;
		for (int n : nums) {
			max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
		}
		return max;
	}
}