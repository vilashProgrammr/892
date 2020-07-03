/* Solution to Chapter 15, Exercise 2 in Teach Yourself Java in 21 Days (Covering Java 8
   and Android by Rogers Cadenhead. */

package com.java21days;

import java.io.*;

/* before running this program, create a file called junkfile.dat in
   the top-level folder of Java21 and put some text or other data into
   it. */
public class FileWiper {
    public static void main(String[] arguments) {
        try {
            FileInputStream file = new FileInputStream("junkfile.dat");
            boolean eof = false;
            int size = 0;
            while (!eof) {
                int input = file.read();
                if (input == -1) {
                    eof = true;
                } else {
                    size++;
                }
            }
            file.close();
            FileOutputStream outFile = new FileOutputStream("junkfile.dat");
            for (int i = 0; i < size; i++) {
                outFile.write( (byte) 0 );
            }
            outFile.close();
        } catch (IOException e) {
            System.out.println("Error -- " + e.toString());
        }
    }
}