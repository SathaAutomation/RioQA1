package Utils;

import java.lang.reflect.Array;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] array2= {{1,2,3},{2,8,7}};
		int[][] array3= new int[5][5];
		array2[0][0]=5;
		
		
		int[] testArray1= new int[]{1,2,3,4};
		int[] testArray2= new int[]{1,2,3,4};
		System.out.println(testArray1.length);
		System.out.println(testArray2.length);
		for(int i=0;i<testArray1.length;i++)
		{
			for(int j=0;j<testArray2.length;j++)
			{
				int c=testArray1[i]+testArray1[j];
				System.out.println(c);
				if(c==7)
				{
					System.out.println("Sum give 7 is"+ testArray1[i] +testArray1[j]);
				}
			}
		}
		

	}

}
