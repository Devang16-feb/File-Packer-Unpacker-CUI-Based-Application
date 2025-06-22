// This program reads data from a file and prints it to the console using FileInputStream in Java.

package Packer_Unpacker;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Program6 
{
    public static void main(String[] args) throws Exception
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("------ Devang Packer UnPacker CUI Module------");
            
            System.out.println("Enter the File name where you want to write data:");
            String File_Name = sobj.nextLine();

            File fobj = new File(File_Name); // Create a File object
                        
            if(fobj.exists()) // whether file is present or not in Current directory 
            {
                try (FileInputStream Aobj = new FileInputStream(fobj)) // Create a FileInputStream object to read from the file 
                {
                    byte Arr[] = new byte[20]; // Create a byte array to hold the data read from the file

                    Aobj.read(Arr); // Read data from the file into the byte array
                
                    // It will give Data from file is :[B@<hashcode> because we are reading this data in byte array format :
                    System.out.println("Data from file is :"+Arr);

                    // To Avoid This we have to convert byte array to String : 
                    String str = new String(Arr);
                    System.out.println("Data from file is :"+str);// This will read the first 20 bytes from the file

                    // Aobj.read(Arr);
                    // str = new String(Arr);
                    // System.out.println("Data from file is :"+str); // This will read the next 20 bytes from the file
                    
                }
            }
            else
            {
                System.out.println("There is no such File");
            }
        }
    }    
}
