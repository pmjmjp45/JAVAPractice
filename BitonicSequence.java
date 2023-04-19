package JavaPractice;

import java.util.ArrayList;
/*
 * Find the length of the longest bitonic sequence
 */
public class BitonicSequence {
	public int solution(int[] nums){
		int answer = 0;
		int n = nums.length;
		ArrayList<Integer> peaks = new ArrayList<>();
		
		for (int i = 1; i < n - 1; i++) { // Find peaks
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				peaks.add(i);
			}
		}
		for (int x: peaks) {
			int left = x; // index of the smallest
			int right = x; // index of the biggest
			int cnt = 1; // count 1, because of the peak
			
			while (left - 1 >= 0 && nums[left - 1] < nums[left]) { // ascending
				left--;
				cnt++;
			}
			while (right + 1 < n && nums[right] > nums[right + 1]) { // descending
				right++;
				cnt++;
			}
			answer = Math.max(answer, cnt); // if cnt is bigger, answer is changed to cnt
		}
				
		return answer;	
	}

	public static void main(String[] args){
		BitonicSequence T = new BitonicSequence();
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
		System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}
}
