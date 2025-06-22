// Now we start the Unpacking process of Packed file, First we have to open the packed file and 
//read the header of each file, then we will create a new file with the same name and write the data into it.

package Packer_Unpacker;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Program19 
{
    public static void main(String[] args) throws Exception
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("------ Devang Packer UnPacker CUI Module------");
            
            System.out.println("Enter the name of packed file that you want to unpack :");
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

                String H = new String(headerBuffer); // Convert the byte array to a string
                System.out.println("Header read from packed file: " + H); // Print the header read

            }
        }
        
    }

    
}
