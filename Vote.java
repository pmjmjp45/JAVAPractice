package JavaPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/*
 * 1. final candidates are whom get larger votes than barLine
 * 2. for every final candidates, their voters receive gifts  
 * 3. Find the person who gets gifts most
 */
public class Vote {
	public String solution(String[] votes, int barLine){
		HashMap <String,Integer> map1 = new HashMap<>(); // candidate(key) - votes(values)
		HashMap <String,Integer> map2 = new HashMap<>(); // voter(key) - gifts(values)

		for (int i = 0; i < votes.length; i++) { // map1: count the votes each candidate gets
			String[]names = votes[i].split(" ");
			map1.put(names[1], map1.getOrDefault(names[1], 0) + 1);
		}
		ArrayList<String> finalCandidates = new ArrayList<>(); // name of final candidates
		for (String key : map1.keySet()) {
			if (map1.get(key) >= barLine) {
				finalCandidates.add(key);
			}
		}
		for (String name : finalCandidates) { // map2: count the gifts each voter gets
			for (int i = 0; i < votes.length; i++) {
				String[]names = votes[i].split(" ");
				if (names[1].equals(name)) {
					map2.put(names[0], map2.getOrDefault(names[0], 0) + 1);
				}
			}
		}
		int max = 0; // the biggest number of gifts 
		for (String key : map2.keySet()) {
			if (map2.get(key) > max) max = map2.get(key);
		}

		ArrayList<String> gifts = new ArrayList<String>(); // The name of a person who gets the biggest number of gifts
		for (String key : map2.keySet()) {
			if (map2.get(key) == max) {
				gifts.add(key);
			}
		}
		Collections.sort(gifts); 

		return gifts.get(0);

	}

	public static void main(String[] args){
		Vote T = new Vote();
		// "voter candidate"
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}