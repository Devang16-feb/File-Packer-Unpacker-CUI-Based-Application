// This program reads a file and prints its contents to the console and also give the size of the file in bytes.
package Packer_Unpacker;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Program8 {
    public static void main(String[] args) throws Exception
    {
        try (Scanner Sobj = new Scanner(System.in)) 
        {
            System.out.println("------ Devang Packer UnPacker CUI Module------");

            System.out.println("Enter the File Name :");
            String File_Name = Sobj.nextLine();

            System.out.println("Entered file name is :" + File_Name);

            File fobj = new File(File_Name); // Create a File object

            if(fobj.exists()) // Check if the file exists
            {
                try(FileInputStream fIn = new FileInputStream(fobj)) // Create a FileInputStream object to read from the file
                {
                    // size 1024 because we are reading 1 KB of data at a time
                    byte[] Arr = new byte[1024]; // Create a byte array to hold the data read from the file
                    String str = null; // String to hold the converted data
                    int iRet = 0, iSum = 0; // Initialize variables for reading data

                    while((iRet = (fIn.read(Arr))) != -1) // Read data from the file into the byte array
                    {
                        iSum += iRet; // Accumulate the number of bytes read
                        str = new String(Arr); // Convert the byte array to a string and print it
                        System.out.print(str); // Print the data read from the file
                    }
                    System.out.println("\nTotal number of bytes read from file is (Size of File) :" + iSum); // Print the total number of bytes read
                    // System.out.println("Size of file :"+fobj.length()); // directly gives the size of the file in bytes
                }
            }
            else
            {
                System.out.println("File " + File_Name + " does not exist.");
            }
        }
        
    }
    
}
