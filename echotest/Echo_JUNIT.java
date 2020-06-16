import static org.junit.Assert.assertEquals;
import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;


import org.junit.Test;

public class Echo_JUNIT {
	public Boolean CHECK_SUCCESS = true;
	public String  CHECK_ERROR_MESSAGE="";
	public Boolean ENTRY_ADDED=false;
	public static void main(String args[])throws Exception{
    Echo_JUNIT sj=new Echo_JUNIT();
    //File file = new File(args[0]);
   
    FileInputStream fis = new FileInputStream(args[0]);
    byte[] buffer = new byte[10];
    StringBuilder sb = new StringBuilder();
    while (fis.read(buffer) != -1) {
	    sb.append(new String(buffer));
	    buffer = new byte[10];
    }
    fis.close();

String content = sb.toString();

	sj.testMain(content);
	
	
	}
	
	public String combine(String[] s, String glue)
{
  int k=s.length;
  if (k==0)
    return null;
  StringBuilder out=new StringBuilder();
  out.append(s[0]);
  for (int x=1;x<k;++x)
    out.append(glue).append(s[x]);
  return out.toString();
}
//----------Code to gerate testcase table in HTML format
 public String WriteTestCaseTable(String rowEntries){
    String str="<table border=1 class=testcase>"+
	"<tr class=testcase_header><td>Our Input</td><td>Expected Output</td><td>Your code's output</td></tr>"+rowEntries+"</table>";
  return str;
 }
 public String addEnteries(String input,String expected_output,String actual_output,String rowClass){
  //input=input.replaceAll("\r\n","<span class=newl>\\\\n</span>");
  expected_output=expected_output.replaceAll("\r\n","<span class=newl> </span>");
  actual_output=actual_output.replaceAll("\r\n","<span class=newl> </span>");
 return "<tr class="+rowClass+"><td>"+input+"</td><td>"+expected_output+"</td><td>"+actual_output+"</td></tr>";
 }
//-----------------------------

		public ArrayList<String>right_testcase=new ArrayList<String>();
		 public ArrayList<String>wrong_testcase=new ArrayList<String>();
		 public ArrayList<String>outputerror=new ArrayList<String>();
		 
@Test

	public void testMain(String code) throws IOException {
            String user_code=code; 
            user_code=java.net.URLDecoder.decode(code, "ISO-8859-1"); 
		
	                 //------filterout the comments
            user_code=java.net.URLDecoder.decode(code, "ISO-8859-1"); 
	      //Pattern pattern=Pattern.compile("\\/\\/.*",Pattern.UNIX_LINES);
		Pattern pattern=Pattern.compile("\\/\\/.*",Pattern.MULTILINE);
          

            Matcher matcher =pattern.matcher(user_code);
             if(matcher.find()){
		     user_code=matcher.replaceAll("");
			}

              Pattern pattern2 =Pattern.compile("\\/\\*.*?\\*\\/",Pattern.DOTALL);
              Matcher matcher2=pattern2.matcher(user_code);
		if(matcher2.find()){
		     user_code=matcher2.replaceAll("");
			}
               //System.out.println("AfterallCOMMENT:"+user_code);
               //------------comments----------	

			
		 
		 
		checkProgram(new String[] {"John"},new String[]{"Hello John"});
		checkProgram(new String[] {"Mike"},new String[]{"Hello Mike"});
		checkProgram(new String[] {"ny"},new String[]{"Hello ny"});
		//checkProgram(new String[] {"susan@gmail.com"},new String[]{"gmail.com"});
		//checkProgram(new String[] {"0"},new String[]{""});

		if(CHECK_SUCCESS==false){
			try{
			System.out.println("<br/><b>Uh-oh!</b><ul>");
		
			  for(String s:outputerror)
			    System.out.println("<li>"+s+"</li>");
				System.out.println("</ul>");
		  
	System.out.println("<b>TestCase table:</b><br/>");
				Random rn = new Random();
						int i=rn.nextInt(wrong_testcase.size());
						
				String row_entry=wrong_testcase.get(i);
             	String table=WriteTestCaseTable(row_entry);
                System.out.println(table);				
				//DJ:			
				stripTest2 s = new stripTest2();
				s.testMain(user_code);
			
				
				}
				catch (Exception ex){
				
				ex.printStackTrace();
				}
		    }
			else{
			System.out.println("<result>Great job!</result><br><br>");
                     System.out.println("Perfect result. No bugs found.");
			System.out.println("<br/><br><b>TestCase Table:</b><br/>");
			String str="";
			for (String s : right_testcase)
						{
							str+=s;
						}
			String table=WriteTestCaseTable(str);
			System.out.println(table);
			
			}
	
	}
     
	 
	public void checkProgram(String[] inputs,String[] output){
		Boolean erroradded=false;
		Boolean flag = true;
	
		
		String input_data="";
		 for(int i=0;i<inputs.length;i++)
		  input_data+=inputs[i]+"\r\n";
		
       		
		System.setIn(new ByteArrayInputStream(input_data.getBytes()));
		  
		PrintStream original = new PrintStream(System.out);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		try{
			Echo.main(new String[]{""});}
			catch (Exception e){System.out.println(e.getMessage());}
			try {
					baos.flush();
				} catch (Exception ex){}
					String whatWasPrinted = new String(baos.toByteArray());

					String[] linesOfOutput = whatWasPrinted.split(//
					System.getProperty("line.separator"));

			 		System.setOut(original);
					System.out.println("");
		 	 
				//pos1---
				String expected_op="";
			try{
				if(output.length >1)
				{
				for(int i=0;i<output.length;i++)
				expected_op+=output[i];
				}
				else
			       expected_op=output[0];
				  input_data=input_data.replaceAll("\r\n"," ");
				 whatWasPrinted=whatWasPrinted.substring(whatWasPrinted.lastIndexOf(":")+1);
								whatWasPrinted=whatWasPrinted.trim();
				
				
				assertEquals(expected_op, whatWasPrinted);

				right_testcase.add(addEnteries(input_data,expected_op,whatWasPrinted,"right_entry"));
			}
			catch (java.lang.AssertionError e){
		//whatWasPrinted=whatWasPrinted.replaceAll(System.getProperty("line.separator")," ");
				//System.out.println("The output is incorrect2:"+expected_op+"|"+whatWasPrinted+"|");
				//String msg="f() does not return the correct string";
				String msg2="Incorrect result. Please revise your code and try again.";
			
				if(ENTRY_ADDED==false){
					//outputerror.add(msg);
					outputerror.add(msg2);
					}
				CHECK_SUCCESS=false;
				wrong_testcase.add(addEnteries(input_data,expected_op,whatWasPrinted,"wrong_entry"));
				  ENTRY_ADDED=true;
			}
              //----pos1
		
			
            

			}//check program

}


 class stripTest2

{
	private Boolean findStringToken(String patterns,String subject){
	Pattern pattern = Pattern.compile(patterns);
	Matcher matcher=pattern.matcher(subject);
	if(matcher.find()){
		System.out.println();
		return true;
		} else{
		return false;
		}
	}
	
	public boolean isLoopUsed(String code){

Pattern forloopPattern=Pattern.compile("\\breverse\\(",Pattern.DOTALL);


Matcher forloop_matcher=forloopPattern.matcher(code);

  if(!forloop_matcher.find()){
   return false; 
  }
  else
  return true;
 
}

	public ArrayList helptip(String str){
    
	String[] searchtoken = {"\"Hello \"","name","=",";"};
	String[] searchtokenregex={"\"Hello \"","\\bname\\b","=",";"};
	ArrayList s = new ArrayList();
	for(int i=0;i<searchtokenregex.length;i++){
	
		//if(str.indexOf(searchtoken[i])==-1){

		if(!findStringToken(searchtokenregex[i],str)){

			if(searchtoken[i].contains("."))
				searchtoken[i]+="(period)";
			else if(searchtoken[i].contains("("))
				searchtoken[i]+=")";
			else if(searchtoken[i].contains(")"))
				searchtoken[i]="("+searchtoken[i];
				//System.out.println("You should be using: "+searchtoken[i]);
			if(searchtoken[i].contains("text"))
				s.add("You might want to use: "+searchtoken[i]);
			else
				s.add("You should be using: "+searchtoken[i]);
		}
	}

	return s;
	}
	public String[] findDuplicates(String [] str){

	
	for(int i=0;i<str.length;i++)
	str[i]=str[i].replaceAll("\\s","");
	
	for(int i=0;i<str.length;i++){
		for(int j=0;j<str.length;j++){
			if(str[i].equals(str[j])&& i!=j)
                str[j]="";
             if(str[j].equals("Hello")){
                    str[j]="";
            }    
            }
           
		}
		//for(int i=0;i<str.length;i++)
		//System.out.println(str[i]);
	return str;
	}
	
	
	public static String readFile(String str_file){
	
	String str="";
	try{

		FileInputStream fstream = new FileInputStream(str_file);
	// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
			// Print the content on the console
			str+=strLine;
		}
		Pattern p = Pattern.compile("(\\/\\/\\/\\{ your logic here)(.*)(\\/\\/\\/\\})",Pattern.DOTALL);
		Matcher m=p.matcher(str);
		if(m.find()){
			str=m.group(2);
		}
	
		}catch (Exception e){//Catch exception if any
		System.err.println("Error: " + e.getMessage());
		}
		return str;
	}
	public void testMain(String user_code) throws Exception

	{
      
	ArrayList a = new ArrayList();
	/*BufferedReader br = new BufferedReader(
	new InputStreamReader(System.in));*/
	String str = user_code;
	 ArrayList b=null;
	try{ b = helptip(str);}
	catch(Exception e){
	e.printStackTrace();
	}
 
	String[] searchtoken = {"\"Hello \"","\\becho\\b","\\bname\\b","\\bSystem\\b","\\bout\\b","\\bprintln\\b","=",";","\\.","\\(","\\)"};
	for(int i=0;i<searchtoken.length;i++){
		//if(str.contains(searchtoken[i])){
		str=str.replaceAll(searchtoken[i]," ");
		//System.out.println(str);
		//}
	}
	
	str = str.replace("("," ");
	str = str.replace(")"," ");

	System.out.println("<br><b>Remarks:</b><ul>");
	
	System.out.println("<li>Your code had an error during execution</li>");
	 //if(isLoopUsed(user_code)==false)
	//System.out.println("<li>You are not using the recursion</li>"); 
	
	if(str.length()>0){
        String str2 = str;
         str2 = str2.replaceAll("Hello ", "");
		//System.out.print("Unexpected identifiers:");
		String ss="";
        str2 = str2.replaceAll("\\b\\d+\\b"," ");
       
       // System.out.println("RRRRRR"+str2);
		String[] str1 = str2.split(" ");
		str1 = findDuplicates(str1);
		for(int i=0;i<str1.length;i++){
			if(!str1[i].equals("")){
				str1[i] = str1[i].replaceAll("[\\+\\-\\*\\/]+"," ");
				ss+=str1[i];
				if(i!=str1.length-1){
				//System.out.print(",");
				ss+=" ";
				}
			}
		}
		ss=ss.trim();
		if(!ss.equals("")){
			//ss=ss.replaceAll(",$","");
		 System.out.println("<li>Unexpected identifiers: "+ss+"</li>");
		}
	}
	System.out.println("</ul>");
	System.out.println("<b>More Hints:</b><ul>");
	int count =0;
	for(int i=0;i<b.size();i++){
		if(i<3)
			System.out.println("<li>"+b.get(i)+"</li>");
		count++;
	}
	if(count<3){    
		if(str.length()>0){
            str = str.replaceAll("Hello ","");
            str = str.replaceAll("\\s+","");
            str = str.replaceAll("\\t+","888");
			String[] str1 = str.split(" ");
			str1 = findDuplicates(str1);
            for(int i=0;i<1000000000;i++){
                
            }
			for(int i=0;i<str1.length-1;i++){
				//System.out.println("str i =|"+str1[i]+"|");
				
				if(!str1[i].equals("")){
					if(count<3){
						System.out.println("<li>Are you sure you want to use: <b>"+str1[i]+"</b> ? </li>");
						count ++;
					}
				}
	
			}
		}
	}
	System.out.println("</ul>");
	}
}	 