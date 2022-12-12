package page;

import java.util.Random;

public class BasePage

{
	public int generateRandomNum(int bountryNum)
	{
		Random rd = new Random();
	   int generateNum =  rd.nextInt();
	   return generateNum;
	}
}
