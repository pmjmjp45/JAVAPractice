package JavaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Plane_BFS2 {

	public int solution(int n, int[][] flights, int s, int e, int k) {
		Queue<int[]> queue = new LinkedList<>();
		ArrayList<Integer> prices = new ArrayList<>();
		
		int price = 0;
		int[] arr = {s, k, price};
		
		queue.offer(arr);
		
		while (!queue.isEmpty()) {
			
			int[] now = queue.poll();
			
			if (now[0] == e) {
				prices.add(now[2]);
				continue;
			} else if (now[1] < 0) {
				continue;
			} else {
				for (int j = 0; j < flights.length; j++) {
					int[] next = now.clone();
					if (flights[j][0] == now[0]) {
						next[0] = flights[j][1];
						next[1]--;
						next[2] += flights[j][2];
						queue.offer(next);
					}
				}
			}
		}
		if (prices.size() == 0) { // 불가능했다면 -1리턴
			return -1;
		} else {
			Collections.sort(prices); //정렬
			return prices.get(0); //최소값 리턴
		}
	}
	public static void main(String[] args){
		Plane_BFS2 T = new Plane_BFS2();
		System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
		System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
		System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
		System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
	}
}
