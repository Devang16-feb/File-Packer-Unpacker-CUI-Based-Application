// In this program we provide solution for previous program where we read data from a file and write it to another file.
// The issue in the previous program was that it copied the data but then wrote the data again from the start of the file.
// to solve this issue, we need to ensure that we only write the bytes that were actually read from the source file to the destination file.
// We use : fOut.write(buffer, 0, bytesRead); 

package Packer_Unpacker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Program10 
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
                            fOut.write(buffer, 0, bytesRead); // here we write only the bytes read to the destination file
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
