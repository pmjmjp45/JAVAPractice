package JavaPractice;

import java.util.*;
class Plane_DFS {
	// 결과값을 저장할 arraylist 전역변수에 설정
	public static ArrayList<Integer> prices = new ArrayList<>();
	public int solution(int n, int[][] flights, int s, int e, int k){
		calc(n, flights, s, e, k, 0);
		
		if (prices.size() == 0) { // 불가능했다면 -1리턴
			return -1;
		} else {
			Collections.sort(prices); //정렬
			//System.out.println(prices.toString());
			return prices.get(0); //최소값 리턴
		}
	}
	// 경로에 따른 price 계산하는 함수
	public static void calc(int n, int[][] flights, int s, int e, int k, int price) {
		
		if (s == e) { //목적지 도착한 경우
			prices.add(price); // arraylist에 저장하고 반환
			return;
		} else if (k < 0) { // 경유 회수 초과한 경우 반환
			return;
		} else { 
			for (int i = 0; i < flights.length; i++) {
				if (flights[i][0] == s) { // 출발지 s와 같은 배열
					// 출발지를 현재 배열의 도착지로 바꾸고, k 회수 줄이고, 가격 누적해서 다시 함수 돌리기
					calc(n, flights, flights[i][1], e, k - 1, price + flights[i][2]);
				}
			}
		}
	}
		
	public static void main(String[] args){
		Plane_DFS T = new Plane_DFS();
		System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
		System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
		System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
		System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
	}
}