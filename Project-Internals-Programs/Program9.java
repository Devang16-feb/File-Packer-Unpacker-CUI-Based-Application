
// This Java program copies data from a source file to a destination file using FileInputStream and FileOutputStream.
// Now Here Problem is that it Copy the data but after data get,s copied it again write the data from the start of the file.

package Packer_Unpacker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Program9 
{
    public static void main(String[] args) throws Exception
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("------ Devang Packer UnPacker CUI Module------");

            System.out.println("Enter the Source File Name :");
            String Source_File = sobj.nextLine();

            System.out.println("Enter the Destinaton File Name :");
            String Dest_File = sobj.nextLine();
            
            File Source_obj = new File(Source_File); // Create a File object for the source file

            if(Source_obj.exists()) // Check if the source file exists
            {
                File Dest_obj = new File(Dest_File); // Create a File object for the destination file

                boolean bRet = Dest_obj.createNewFile(); // Create the destination file if it does not exist

                if(bRet == false) // Check if the file was created successfully
                {
                    System.out.println("Destination file unable to create.");
                    return; // Exit if the file creation failed
                }

                try(FileInputStream fIn = new FileInputStream(Source_obj)) // Create a FileInputStream object for reading the source file
                {
                    try(FileOutputStream fOut = new FileOutputStream(Dest_obj)) // Create a FileOutputStream object for writing to the destination file
                    {
                        byte[] buffer = new byte[1024]; // Create a byte array to hold the data read from the source file
                        int bytesRead; // Variable to hold the number of bytes read
                        int totalBytesCopied = 0; // Variable to hold the total number of bytes copied  
                        
                        while((bytesRead = fIn.read(buffer)) != -1) // Read data from the source 
                        {
                            fOut.write(buffer); // Write the data to the destination file
                            totalBytesCopied += bytesRead; // Accumulate the number of bytes copied
                        }
                        System.out.println("Total Bytes of Data copied successfully from " + Source_File + " to " + Dest_File + " is: " + totalBytesCopied + " bytes."); // Print the total number of bytes copied
                    }
                }
            }
            else
            {
                System.out.println("Source file " + Source_File + " does not exist.");
            }
        }
            
    }    
}