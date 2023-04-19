package JavaPractice;

public class Password {
	public static int[] nowPlace(int[] keypad, int num) { 
		int[] now = new int [2];
		// make keypad
		int[][] pad = {{keypad[0],0,0},{keypad[1],1,0},{keypad[2],2,0},
				{keypad[3],0,1},{keypad[4],1,1},{keypad[5],2,1},
				{keypad[6],0,2},{keypad[7],1,2},{keypad[8],2,2}};
		// find location
		for (int i = 0; i < pad.length; i++) {
			if (pad[i][0] == num) {
				now[0] = pad[i][1];
				now[1] = pad[i][2];
			}
		}
		return now;
	}
	public int solution(int[] keypad, String password){
		int answer = 0;
		char[] cPassword = password.toCharArray();
		int[] iPassword = new int[password.length()];
		
		// change password type String -> integer
		for (int i = 0; i < password.length(); i++) {
			iPassword[i] = Character.getNumericValue(cPassword[i]);
		}

		int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; // parallel direction
		int[] dy = {1, 1, 0, -1, -1, -1, 0, 1}; // vertical direction
		int time = 0;
		int sumTime = 0;

		for (int i = 0; i < iPassword.length - 1; i++) {
			for (int j = 0; j < dx.length; j++) {
				if (nowPlace(keypad, iPassword[i])[0] + dx[j] == nowPlace(keypad, iPassword[i + 1])[0]
						&& nowPlace(keypad, iPassword[i])[1] + dy[j] == nowPlace(keypad, iPassword[i + 1])[1]) {
					time = 1; // touching block: 1 second
					break;
				} else if (nowPlace(keypad, iPassword[i])[0] == nowPlace(keypad, iPassword[i + 1])[0]
						&& nowPlace(keypad, iPassword[i])[1] == nowPlace(keypad, iPassword[i + 1])[1]) {
					time = 0; // same block: 0 second
					break;
				} else {
					time = 2; // distant block: 2 second
				}
			}
			sumTime += time;
		}

		return sumTime;
	}

	public static void main(String[] args){
		Password T = new Password();
		// {keypad}, password
		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));	
		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}
