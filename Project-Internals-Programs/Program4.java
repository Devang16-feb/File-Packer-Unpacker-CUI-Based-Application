// This program checks if a file exists in the current directory.
package Packer_Unpacker;
import java.io.File;
import java.util.*;

public class Program4 
{
    public static void main(String[] args) 
    {
        try (Scanner sobj = new Scanner(System.in)) {
            System.out.println("------ Devang Packer UnPacker CUI Module------");
            
            System.out.println("Enter the File name that you want to Check that Exitst or not:");
            String File_Name = sobj.nextLine();

            File fobj = new File(File_Name); // Create a File object
            
            if(fobj.exists()) // Check if the file exists
            {
                System.out.println("File " + File_Name + " exists.");
            }
            else
            {
                System.out.println("File " + File_Name + " does not exist.");
            }
        }
    }
    
}
