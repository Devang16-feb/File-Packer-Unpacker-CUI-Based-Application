// This program reads the whole contents of file till the end and prints it to the console.
// it reads the data in chunks of 1024 bytes (1 KB) at a time.

package Packer_Unpacker;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class Program7 
{
    public static void main (String[] args) throws Exception
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
                try(FileInputStream fIn = new FileInputStream(fobj))
                {
                    // size 1024 because we are reading 1 KB of data at a time
                    byte[] Arr = new byte[1024]; // Create a byte array to hold the data read from the file
                    String str = null; // String to hold the converted data

                    while((fIn.read(Arr)) != -1) // Read data from the file into the byte array
                    {
                        str = new String(Arr); // Convert the byte array to a string and print it
                        System.out.print(str); // Print the data read from the file
                    }

                }
            }
            else
            {
                System.out.println("File " + File_Name + " does not exist.");
            }
        }

    }    
}
