package chapter1_1;

public class Ex11 {
	public static void print2DArrayBoolean(boolean[][] b){
		System.out.print("   ");
		for (int i = 0; i < b[0].length; i++){
			System.out.printf("%-3d", i);
		}
		System.out.println();
		for (int j = 0; j < b.length; j++){
			for (int k = 0; k < b[j].length; k++){
				if (k == 0){
					System.out.printf("%-3d", j);
				}
				if (b[j][k] == true){
					System.out.print("*  ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int col = 17;
		int raw = 11;
		boolean[][] b = new boolean[raw][col];
		for (int i = 0; i < b.length; i++){
			for (int j = 0; j < b[i].length; j++){
				if (Math.random() < 0.5){
					b[i][j] = true;
				} else {
					b[i][j] = false;
				}
				
			}
		}
		
		print2DArrayBoolean(b);

	}

}
