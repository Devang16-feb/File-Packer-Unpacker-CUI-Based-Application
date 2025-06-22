// In this program, we only read header of first file form existing packed file
//  In Header from Name we create a new file with the same name 
// and using Size we create a byte array to hold the data of that file 
// and then we read the data of that file from packed file and write it to the new file.

// This program we work on only one file, which demonstrate how to unpacked only one files
package Packer_Unpacker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Program20 
{
    public static void main(String[] args) throws Exception
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("------ Devang Packer UnPacker CUI Module------");
            
            System.out.println("Enter the name of packed file that you want to open for unpack :");
            String PackedFileName = sobj.nextLine();

            File fobj = new File(PackedFileName); // Create a File object for the packed file

            if(!fobj.exists())
            {
                System.out.println("Packed file " + PackedFileName + " does not exist.");
                return; // Exit if the packed file does not exist
            }

            try(FileInputStream fIn = new FileInputStream(fobj)) // Create a FileInputStream to read the packed file
            {
                byte[] headerBuffer = new byte[100]; // Buffer to read headers is 100 bytes
                
                fIn.read(headerBuffer); // Read the first header

                String Headerx = new String(headerBuffer); // Convert the byte array to a string
                System.out.println("Header read from packed file: " + Headerx); // Print the header read

                Headerx = Headerx.trim(); // Trim any leading or trailing whitespace from the header string
                // it means that we are removing any extra spaces at end or begaining or new lines from the header string

                String[] headerParts = Headerx.split(" "); // Split the header by spaces to get individual parts
                System.out.println("File name: " + headerParts[0]); // Print the file name from the header
                System.out.println("File size: " + headerParts[1]); // Print the file size from the header

                
                File obj = new File(headerParts[0]); // Create a new File object with the name from the header
                obj.createNewFile(); // Create the new individual (Unpacked)file if it does not exist

                int FileSize = Integer.parseInt(headerParts[1]); // Parse the file size from the header
                byte[] dataBuffer = new byte[FileSize]; // Create a buffer to hold the file data

                fIn.read(dataBuffer, 0, FileSize); // Read the file data into the buffer

                String Data = new String(dataBuffer); // Convert the byte array to a string
                System.out.println("Data read from packed file: " + Data); // Print the data read from the packed file

                // Here we can write the data to the new file
                try(FileOutputStream fOut = new FileOutputStream(obj)) // Create a FileOutputStream to write to the new file
                {
                    fOut.write(dataBuffer, 0, FileSize); // Write the data to the new file
                    System.out.println("Data written to file: " + headerParts[0]); // Print confirmation of data written
                }
            }
        }
        
    }   
}
