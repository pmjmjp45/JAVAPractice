package JavaPractice;

import java.util.HashMap;

/*
 * Find only one alphabet's location
 * HashMap is useful tool to count numbers
 * .put(key,.getOrDefault(key,0) + 1) *****very important
 */
public class OnlyOneAlphabet {
	public int solution(String s){
		
		HashMap<Character, Integer> num = new HashMap<>();
		
		for (Character key : s.toCharArray()) {
			num.put(key, num.getOrDefault(key, 0) + 1);
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (num.get(s.charAt(i)) == 1) 
				return i + 1;
		}

		return -1;
	}

	public static void main(String[] args){
		OnlyOneAlphabet T = new OnlyOneAlphabet();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}
