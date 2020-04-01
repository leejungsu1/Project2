import java.util.Random;
import java.util.Scanner;

public class ThreeByThree {
	
	static int x, y;
	public static boolean gameCheck(String[][] puz) {
		String[][] puzzle = {
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "X"}
		};
		for(int i=0 ; i<puzzle.length ; i++) {
			for(int j=0 ; j<puzzle[i].length ; j++) {
				if(puzzle[i][j] != puz[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static String[][] shuffle(String[][] puz){
		Random random = new Random();
		for(int i=1 ; i<=3 ; i++) {
			try {
				switch ((int)(((Math.random()*100)) % 4)+1) {
				case 1:
					puz[x][y] = puz[x+1][y];
					puz[x+1][y] = "X";
					x += 1;
					break;
				case 2:
					puz[x][y] = puz[x-1][y];
					puz[x-1][y] = "X";
					x -= 1;
					break;
				case 3:
					puz[x][y] = puz[x][y+1];
					puz[x][y+1] = "X";
					y += 1;
					break;
				case 4:
					puz[x][y] = puz[x][y-1];
					puz[x][y-1] = "X";
					y -= 1;
					break;
				}
			}
			
			catch (Exception e) {
			
			}
		}
		return puz;
	}
	public static void gameRule() {
		x=2;
		y=2;
		String[][] puz = {
				{"1", "2", "3"},
				{"4", "5", "6"},
				{"7", "8", "X"}
		}; 
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			try {
				puz = shuffle(puz);
				for(int i=0 ; i<puz.length ; i++) {
					for(int j=0 ; j<puz[i].length ; j++) {
						System.out.print(puz[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println("[이동] a:Left d:Right w:Up s:Down");
				String key = scan.next();
				if(key.equals("w")) {
					puz[x][y] = puz[x+1][y];
					puz[x+1][y] = "X";
					x += 1;
				}
				else if(key.equals("s")) {
					puz[x][y] = puz[x-1][y];
					puz[x-1][y] = "X";
					x -= 1;
				}
				else if(key.equals("a")) {
					puz[x][y] = puz[x][y+1];
					puz[x][y+1] = "X";
					y += 1;
				}
				else if(key.equals("d")) {
					puz[x][y] = puz[x][y-1];
					puz[x][y-1] = "X";
					y -= 1;
				}
			}
			catch (Exception e) {
				System.out.println("xxxxxxx이동불가xxxxxxx");
				System.out.println("다른키를 누르세요.");
			}
			for(int i=0 ; i<puz.length ; i++) {
				for(int j=0 ; j<puz[i].length ; j++) {
					System.out.print(puz[i][j]+" ");
				}
				System.out.println();
			}
			if(gameCheck(puz)==true) {
				System.out.println("성공하였습니다.");
				System.out.println("재시작(0), 종료(1)을 누르세요.");
				int choice = scan.nextInt();
				if(choice==0) {
					System.out.println("게임을 재시작합니다.");
					continue;
				}
				else if(choice==1) {
					System.out.println("게임을 종료합니다.");
					break;
				}
			}
			else {
				System.out.println("다시 하세요.");
				continue;
			}
		}
	}
	public static void main(String[] args) {
		gameRule();
	}
}
