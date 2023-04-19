package JavaPractice;

public class FindDog {
	public int solution(int[][] board){

		int n = board.length; 
		int[] dx = {-1, 0, 1, 0}; // vertical direction
		int[] dy = {0, 1, 0, -1}; // parallel direction
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0; // (x1,y1): my location (x2,y2): dog's location
		int d1 = 0, d2 = 0, cnt = 0; // d1(my direction), d2(dog's direction), cnt(for time limit) 
		
		for (int x = 0; x < n; x++) { // find where I am and where the dog is
			for (int y = 0; y < n; y++) {
				if (board[x][y] == 2) {
					x1 = x; 
					y1 = y;
				}
				if (board[x][y] == 3) {
					x2 = x; 
					y2 = y;
				}
			}
		}
		/*
		 * both going 1 block and changing direction takes 1 cnt
		 * time limit is 10000
		 */
		while (cnt < 10000) {

			boolean flag1 = true, flag2 = true;
			
			cnt++;
			int nx1 = x1 + dx[d1];
			int ny1 = y1 + dy[d1];
			int nx2 = x2 + dx[d2];
			int ny2 = y2 + dy[d2];
			
			if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1) {
				d1 = (d1 + 1) % 4;
				flag1 = false;
			}
			if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1) {
				d1 = (d1 + 1) % 4;
				flag1 = false;
			}
			
			if (flag1 == true) {
				x1 = nx1;
				y1 = ny1;
			}
			
			if (flag2 == true) {
				x2 = nx2;
				y2 = ny2;
			}
			if (x1 == x2 && y1 == y2) break;
		}
		if (cnt >= 10000) return 0;
		return cnt;
	}

	public static void main(String[] args){
		FindDog T = new FindDog();
		int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; 
		System.out.println(T.solution(arr1));
		int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}}; 
		System.out.println(T.solution(arr2));
	}
}