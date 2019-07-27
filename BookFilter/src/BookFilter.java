import java.io.*;
import java.util.ArrayList;

import nu.xom.*;

public class BookFilter {
    
    public BookFilter() {
    	// no initialization needed
    }
    
    public ArrayList<String> read(String filePath) { 
    	ArrayList<String> bookList = new ArrayList<String>();
    	
    	//write down your code here
        //start
			///{
    

    		///}
        //end
        
        
        return bookList;
    }
      		
    
    public static void main(String[] arguments) {
        BookFilter bf = new BookFilter();
        ArrayList<String> bookList = bf.read("/home/project/BookFilter/book/book.xml");
        System.out.println("done"+bookList);
        for (int i=0; i<bookList.size(); i++) {
        	System.out.println(bookList.get(i));
        }
    }
}