// This program checks if a directory exists or not based on user input.
package Packer_Unpacker;

import java.io.File;
import java.util.Scanner;

public class Program11 
{
    public static void main(String Arg[]) throws Exception
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("------- Devang Packer Unpacker CUI Module -------");

            System.out.println("Enter the name of Directory that you want to open : ");
            String FolderName = sobj.nextLine();

            File fobj = new File(FolderName);

            if(fobj.exists())
            {
                System.out.println("Directory is present");
            }
            else
            {
                System.out.println("There is no such directory");
            }
        }
     
    }
    
}
