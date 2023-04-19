package JavaPractice;

import java.util.Arrays;
/*
 * 1~2 people can move at once
 */
public class Titanic {
	public int solution(int[] nums, int limitWeight){
		int answer = 0;
		
		Arrays.sort(nums);
		
		int left = 0; // index of the lightest
		int right = nums.length - 1; // index of the heaviest
		
		while (left <= right) {
			if (nums[left] + nums[right] <= limitWeight) { // if two can move at once 
				answer++;
				left++;
				right--;
			} else { // if not, only the heaviest moves
				answer++;
				right--;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Titanic T = new Titanic();
		// int[]{weight of people}, limitWeight
		System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
		System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
		System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
	}
}