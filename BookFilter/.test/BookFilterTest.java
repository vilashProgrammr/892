import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class BookFilterTest {
	
	public static void main(String[] args) {
		
		try{
			
			if(testCode())
				System.out.println("\nSUCCESS: your code has passed all the testcases.");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static boolean testCode() throws Exception {
		Class noparams[] = {};
		Class cls;
		Constructor<?> cons;
		Object obj;
		String input = "";
		String expectedOutput[] = {"Wild Cards: Suicide Kings", "A Game of Thrones", "Test Book", "Test Book New"};
		ArrayList<String> outputValue;
		try {
			cls = Class.forName("BookFilter");
		    cons = cls.getConstructor();
			obj = cons.newInstance();
			
		} catch (Exception e) {

			reportError(input, "", "", "Are you sure your code is error free?");
			return false;
		}
		
		try {
			Method method = cls.getDeclaredMethod("read", String.class);
			String param[] = {"./.test/book.xml"};
			Object output = method.invoke(obj, param);
			outputValue = (ArrayList<String>) output;
		} catch (Exception e) {
			reportError("", "", "", "There seems to be issue while accessing the file?");
			return false;
		}
		
        try {
    			
        		boolean isAllOutputsIdentical = true;
	    		for(int i=0; i<expectedOutput.length; i++) {
	    			
	        		if(outputValue.get(i).equals(expectedOutput[i])) {
	        			continue;
	        		} else {
	        			isAllOutputsIdentical = false;
	        			reportError("", outputValue.get(i), expectedOutput[i], "The testcase booknames doesnt match with expected output.");
	        			return false;
	        		}
	        	}
	    		
	    		if(isAllOutputsIdentical)
	    			return true;
        	
        	
        } catch(Exception e) {
    		reportError("", "", expectedOutput[0], "Are you sure you're adding book titles to bookList variable?");
			
        }
        return false;
       
	}
	
	public static void reportError(String input, String output, String expectedOutput, String hint){
		System.err.println("\nERROR: Your code has failed below testcase.\n");
		System.out.println("\nINPUT \t OUTPUT \t EXPECTED OUTPUT");
		System.out.println(input+" \t "+output+" \t "+expectedOutput);
		System.err.println("\nHINT: "+hint);
	}
}
