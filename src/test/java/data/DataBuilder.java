package data;

import java.util.Random;
import util.RandomUtil;

/**
 * 
 * Generate random values for Employee and Visitor
 * @author cloverli
 * @date 15/02/2021
 *
 */
public class DataBuilder {
	
	private static int RANDOM_LENGTH = 3;
	
	public static String newVisitorName() {
		int tailLength = new Random().nextInt(RANDOM_LENGTH) + 1;
		return ( "visitor_" + RandomUtil.getRandom(tailLength, false));
	}
	
	public static String newEmloyeeFirstName() {
		int tailLength = new Random().nextInt(RANDOM_LENGTH) + 1;
		return ( "employee_" + RandomUtil.getRandom(tailLength, false));
	}
	
	public static String newEmloyeeLastName() {
		int tailLength = new Random().nextInt(RANDOM_LENGTH) + 1;
		return ( "lastname_" + RandomUtil.getRandom(tailLength, false));
	}
	
	public static String newCompany() {
		int tailLength = new Random().nextInt(RANDOM_LENGTH) + 1;
		return ( "company_" + RandomUtil.getRandom(tailLength, false));
	}
	
	public static String newEmail() {
		int numberLength = new Random().nextInt(RANDOM_LENGTH) + 1;
		return ( "email" + RandomUtil.getRandom(numberLength, false) + "@gmail.com" );
	}
	
	public static String newPhone(int phoneLen) {
		return ( RandomUtil.getRandom(phoneLen, true));
	}
}
