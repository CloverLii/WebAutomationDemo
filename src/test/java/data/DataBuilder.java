package data;

import java.util.Random;
import util.RandomUtil;

/**
 * 
 * @author cloverdolphin
 *
 */
public class DataBuilder {
	
	public static String newVisitorName() {
		int numberLength = new Random().nextInt(3) + 1;
		return ( "visitor " + RandomUtil.getRandom(numberLength, false));
	}
	
	public static String newCompany() {
		int numberLength = new Random().nextInt(3) + 1;
		return ( "company " + RandomUtil.getRandom(numberLength, false));
	}
	
	public static String newEmail() {
		int numberLength = new Random().nextInt(3) + 1;
		return ( "email" + RandomUtil.getRandom(numberLength, false) + "@gmail.com" );
	}
	
	public static String newPhone() {
		int numberLength = new Random().nextInt(8) + 1;
		return ( RandomUtil.getRandom(numberLength, true));
	}
}
