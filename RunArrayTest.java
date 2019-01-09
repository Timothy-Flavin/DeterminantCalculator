import java.util.*;

public class RunArrayTest{
	Scanner s;
	int x, y;
	public RunArrayTest(){
		s = new Scanner(System.in);

		System.out.println("enter rows: ");
		x = s.nextInt();
		s.nextLine();
		System.out.println("enter collumns: ");
		y = s.nextInt();

		ArrayTest apple = new ArrayTest();
		int[][] array1 = new int[x][y];
		array1 = apple.makeArray(x, y);
		apple.printArray();
		int det = apple.getDeterminant(array1);
		System.out.println("determinant: " + det);
	}
	public static void main(String[] args){
		new RunArrayTest();
	}
}
