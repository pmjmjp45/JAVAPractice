package JavaPractice;

import java.util.HashMap;
/*
 * Count the number of sequence of which sum is 'm'
 */
public class SumSequence {
	public int solution(int[] nums, int m){
		int answer = 0;
		HashMap<Integer,Integer> nh = new HashMap<>();
		int sum = 0;
		nh.put(0, 1); /// set 0
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			 // �������� m�� �Ǳ� ���ؼ��� "sum-m"�� ���� �ȴ�
			if (nh.containsKey(sum - m)) {
				answer += nh.get(sum - m); // "sum-m"�� ����� �� nh.get(sum-m)
			}
			nh.put(sum,nh.getOrDefault(sum, 0) + 1);
		}
		return answer;
	}

	public static void main(String[] args){
		SumSequence T = new SumSequence();
		System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));	
		System.out.println(T.solution(new int[]{-1, 0, 1}, 0));	
		System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));	
	}
}
