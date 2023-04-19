package JavaPractice;
/*
 * each people can have the least number of fruit in each one's basket
 * Exchange fruit and make the least number bigger
 * Count the number of fruits that people have
 * 
 * <Exchange Rule>
 * 1. exchanging in order
 * 2. only can exchange once
 * 3. exchange occurs when both of people are beneficial
 */
public class FruitExchange {
	public int getMin(int[] fruit){ /// find the least fruit
		int min = 50;
		
		for(int x : fruit){
			min = Math.min(min, x); // if x is smaller than min, min is replaced to x
		}
		return min;
	}
	public Boolean isMinUnique(int[] fruit){ // minimum should be unique
		int cnt = 0;
		int min = getMin(fruit);
		
		for(int x : fruit) {
			if(x == min) cnt++;
		}
		return cnt == 1; // if cnt = 1, return 'true', if not, return 'false'
	}
	public int getMinIndex(int[] fruit){ // Find the type of the least fruit 
		int min = getMin(fruit);
		
		for(int i = 0; i < 3; i++){
			if(fruit[i] == min) return i;
		}
		return 0;
	}
	public int solution(int[][] fruit){
		int answer = 0; 
		int n = fruit.length;
		int[] ch = new int[n]; // to check exchanged or not
		
		for(int i = 0; i < n; i++){
			if(ch[i] == 1) continue; // if exchanged, 'ch = 1' 
			if(isMinUnique(fruit[i]) == false) continue; // if minumum is not unique
			
			for(int j = i+1; j < n; j++){
				if(ch[j] == 1) continue; // check partner
				if(isMinUnique(fruit[j]) == false) continue; 
				
				int myFruit = getMinIndex(fruit[i]);
				int yourFruit = getMinIndex(fruit[j]); 
				
				if(myFruit != yourFruit && fruit[i][yourFruit] > 0 && fruit[j][myFruit] > 0){ // fruit type should be different, each fruit > 0
					if(fruit[i][myFruit] + 1 <= fruit[i][yourFruit] - 1 && fruit[j][yourFruit] + 1 <= fruit[j][myFruit] - 1){ // after exchange the type of the least fruit should not be changed
						fruit[i][myFruit]++;
						fruit[i][yourFruit]--;
						fruit[j][yourFruit]++;
						fruit[j][myFruit]--;
						ch[i] = 1; // to check exchanged
						ch[j] = 1;
						break;
					}
				}
			}
		}
		for(int[] x : fruit){
			answer += getMin(x); // add each one's minimum
		}
		return answer;
	}

	public static void main(String[] args){
		FruitExchange T = new FruitExchange();
		// {apple, pear, orange}
		System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
		System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));	
		System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
		System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
	}
}