// This program demonstrates how to write data to a file using FileOutputStream in Java

// if you run this  code again, it will overwrite the existing data in the file with "Marvellous". 

package Packer_Unpacker;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Program5 
{
    public static void main(String[] args) throws Exception
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("------ Devang Packer UnPacker CUI Module------");
            
            System.out.println("Enter the File name where you want to write data:");
            String File_Name = sobj.nextLine();

            File fobj = new File(File_Name); // Create a File object
            
            if(fobj.exists()) // Check if the file exists
            {
                try (FileOutputStream fOut = new FileOutputStream(fobj)) // Create a FileOutputStream object
                {
                    String str = "Marvellous";
                    byte[] Arr = str.getBytes(); // Convert the string to a byte array
                    fOut.write(Arr); // Write the byte array to the file
                    System.out.println("Data written successfully.");
                }
            }
            else
            {
                System.out.println("File " + File_Name + " does not exist.");
            }
        }
    }
}
