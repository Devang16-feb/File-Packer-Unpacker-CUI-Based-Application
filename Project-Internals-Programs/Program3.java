// This program creates a new file in the current directory using Java's File class.

package Packer_Unpacker;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program3 
{
    public static void main(String[] args) throws IOException 
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("------ Devang Packer UnPacker CUI Module------");
            
            System.out.println("Enter the File name that you want to create:");
            String File_Name = sobj.nextLine();
            
            // In File class, we can create a file using the createNewFile() method
            File fobj = new File(File_Name); // Create a File object

            fobj.createNewFile(); // Create a new file 
        }  
    }
    
}
