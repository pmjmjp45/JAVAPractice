package JavaPractice;

import java.util.ArrayList;
import java.util.Collections;
/*
 * Create a sequence by randomly shuffling the doubled values of the elements in the original sequence.
 * Find the original sequence
 */
public class OriginalSequence {
	public ArrayList<Integer> solution(int[] nums){

		ArrayList<Integer> numbers = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			numbers.add(nums[i]);
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (numbers.contains(nums[i] * 2)) {
				numbers.remove(Integer.valueOf(nums[i] * 2));
			} 
		}
		Collections.sort(numbers);
		return numbers;
	}

	public static void main(String[] args){
		OriginalSequence T = new OriginalSequence();
		System.out.println((T.solution(new int[]{1, 10, 2, 3, 5, 6})).toString());
		System.out.println((T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})).toString());
		System.out.println((T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})).toString());
	}
}
