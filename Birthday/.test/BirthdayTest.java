import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class BirthdayTest {
	static int testCaseIndex = 0;
	static String expectedOutput[] = new String[3];
	static String outputArr[] = new String[3];
	
	public static void main(String[] args) {
		
		try{
	        boolean isAllTestCasesPassed = true;
			String testCases[] = {"01/30/2016", "01/01/1970", "12/23/2012"};
			
			for (int i=0; i<testCases.length; i++) {
				testCaseIndex = i;
				if(testCode(testCases[i]))
					continue;
				else {
					isAllTestCasesPassed = false;
					break;
				}
			}
			if (isAllTestCasesPassed) {
				System.out.println("\nSUCCESS: your code has passed all the testcases.");
				for (int i=0; i<testCases.length; i++) {
					System.out.println("\n\n----------------------------------------------------------------------");
					System.out.println("\nINPUT: "+testCases[i]);
		        	System.out.println("\nOUTPUT: "+expectedOutput[i]);
		        	System.out.println("\nEXPECTED OUTPUT: "+outputArr[i]);
		        	System.out.println("\n----------------------------------------------------------------------");
				}
			}
	
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static boolean testCode(String input) throws Exception {
		Class cls;
		Constructor<?> cons;
		Object obj;
		String month = input.substring(0, 2);
        String day = input.substring(3, 5);
        String year = input.substring(6, 10);
        
		try {
			cls = Class.forName("Birthday");
			cons = cls.getConstructor(String.class);
			obj = cons.newInstance(input);
		} catch(Exception e) {
        	System.err.println("\nERROR: your code has failed the below testcase.\n");
			System.err.println("----------------------------------------------------------------------");
        	System.err.println("\nINPUT: "+input);
        	System.err.println("\nOUTPUT: "+" \t ,, \t ");
        	System.err.println("\nEXPECTED OUTPUT: "+day+", "+month+", "+year);
			System.err.println("----------------------------------------------------------------------");
			System.err.println("\nHINT: Are you sure your code is error free?");
			return false;
        }
		
		Birthday birth = (Birthday) obj;
		
        try {
			if(birth.day.equals(day) && 
				birth.month.equals(month) &&
				birth.year.equals(year)) {
				expectedOutput[testCaseIndex] = day+", "+month+", "+year;
				outputArr[testCaseIndex] = birth.day+", "+birth.month+", "+birth.year;
				return true;
			} else {
				System.err.println("\nERROR: your code has failed the below testcase.\n");
				System.err.println("----------------------------------------------------------------------");
	        	System.err.println("\nINPUT: "+input);
	        	System.err.println("\nOUTPUT: "+birth.day+", "+birth.month+", "+birth.year);
	        	System.err.println("\nEXPECTED OUTPUT: "+day+", "+month+", "+year);
				System.err.println("----------------------------------------------------------------------");
				System.err.println("\nHINT: Are you sure you are assigning the values to the day, month, year variables?");
				return false;
			}  
        } catch(Exception e) {
        	System.err.println("\nERROR: your code has failed the below testcase.\n");
        	System.err.println("----------------------------------------------------------------------");
        	System.err.println("\nINPUT: "+input);
        	System.err.println("\nOUTPUT: "+birth.day+", "+birth.month+", "+birth.year);
        	System.err.println("\nEXPECTED OUTPUT: "+day+", "+month+", "+year);
        	System.err.println("----------------------------------------------------------------------");
        	System.err.println("\nHINT: Are you sure you are assigning the values to the day, month, year variables?");
        	return false;
        }
	}
}
