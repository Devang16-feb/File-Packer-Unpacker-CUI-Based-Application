// This proram lists all files in a specified directory.
package Packer_Unpacker;

import java.io.File;
import java.util.Scanner;

public class Program12 
{
    public static void main(String[] args) 
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("------- Devang Packer Unpacker CUI Module -------");

            System.out.println("Enter the name of Directory that you want to open : ");
            String FolderName = sobj.nextLine();

            File fobj = new File(FolderName);

            if(fobj.exists())
            {
                File Arr[] = fobj.listFiles(); // Get the list of files in the directory

                System.out.println("Number of files in directory are : "+Arr.length);  
            }
            else
            {
                System.out.println("There is no such directory");
            }
        }
    }    
}
