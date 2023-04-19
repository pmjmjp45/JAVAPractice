package JavaPractice;

import java.util.Arrays;

public class CleaningRobot {

	public int[] solution(int[][] board, int timeLimit){
		int[] answer = new int[2]; 
		int n = board.length; 
		int[] dx = {-1, 0, 1, 0}; // vertical direction
		int[] dy = {0, 1, 0, -1}; // parallel direction
		int x = 0, y = 0, d = 1, cnt = 0; // x(vertical location), y(parallel location), d(direction), cnt(for time limit) 

		while(cnt < timeLimit) {
			cnt++;
			int nx = x + dx[d];
			int ny = y + dy[d];

			// if robot goes out of the map, or bumps into obstacles, change the direction
			if (nx < 0 || nx >= n || ny < 0|| ny >= n || board[nx][ny] == 1) {
				d = (d + 1) % 4;
				continue;
			}
			x = nx;
			y = ny;
		}
		answer[0] = x;
		answer[1] = y;

		return answer;
	}

	public static void main(String[] args){
		CleaningRobot T = new CleaningRobot();
		int[][] arr1 = {{0, 0, 0, 0, 0}, 
				{0, 1, 1, 0, 0}, 
				{0, 0, 0, 0, 0}, 
				{1, 0, 1, 0, 1}, 
				{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10))); // map, timeLimit
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
				{0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 1}, 
				{1, 1, 0, 0, 1, 0}, 
				{0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
				{0, 1, 0, 0, 0}, 
				{0, 0, 0, 0, 0}, 
				{1, 0, 0, 0, 1}, 
				{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));

	}

}