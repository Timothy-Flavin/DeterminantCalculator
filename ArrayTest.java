//int[] x;
import java.util.*;
//x = new int[]

public class ArrayTest{
	int[][] da;
	Scanner poop;
	int x, y, posInt;
	boolean squareArray = true;


	public ArrayTest(){

	}
// i = row number. j = collumn  x = num row   y = num collumn
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void printArray(){
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++){
				System.out.print((i+1) + "," + (j+1) + "  " + da[i][j] + ";  ");
			}
			System.out.println();
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getDeterminant(int[][] b){
		int determinant = 0;
		if(squareArray){
			if(b.length == 2){
				determinant = b[0][0]*b[1][1] - b[0][1]*b[1][0];
				//System.out.println("determinant: " + determinant);
				return determinant;
			}
			else if(b.length == 1){
				return b[0][0];
			}
			else{
				for(int c = 0; c < b.length; c++){
					if((c+2)%2 == 0){
						posInt = 1;
					}
					else{
						posInt = -1;
					}

					determinant += posInt * b[0][c] * getDeterminant(makeSmallerArray(b.length, b, c));
				//	System.out.println("determinant: " + determinant);
				}
				return determinant;
			}

		}
		else{
			System.out.println("dude, you can't ge a determinant that does not exist!!");
			return 10101010;
		}

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int[][] makeArray(int row, int col){
		x = row;
		y = col;
		if(x != y){
			System.out.println("not a square array. gtfo");
			squareArray = false;
		}

		da = new int[x][y];
		poop = new Scanner(System.in);
		//Random rand = new Random();

		for(int i = 0; i < x; i++){

			for(int j = 0; j < y; j++){

				System.out.print("enter value " + i + ", " + j + ":");
				int r = poop.nextInt();
				da[i][j] = r;
			}
		}
		return da;
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private int[][] makeSmallerArray(int rowColNum, int[][] oldArray, int colNum){
		int[][] miniArray = new int[rowColNum-1][rowColNum-1];
		//Random rand = new Random();
		boolean testCollumn = false;
		for(int i = 0; i < rowColNum-1; i++){
			testCollumn = false;
			//do a test to make sure that j does not equal the old row number
			for(int j = 0; j < rowColNum; j++){

				if(j != colNum && !testCollumn){
					miniArray[i][j] = oldArray[i+1][j];
					//System.out.print("its doing the if:  ");
				}
				else if(j == colNum){
					testCollumn = true;
					//System.out.print("its doing the j == colNum:  ");
				}
				else if(testCollumn){
					miniArray[i][j-1] = oldArray[i+1][j];
					//System.out.print("its doing the testCollumn:  ");
				}
				//System.out.println("i: " + i + ",   j: " + j + "    colNum: " + colNum);

			}
		}
		/*for(int k = 0; k<rowColNum-1; k++){
			for(int l = 0; l<rowColNum-1; l++){
				System.out.print(miniArray[k][l]+ ", ");
			}
			System.out.println();
		}*/
		return miniArray;
	}
}
