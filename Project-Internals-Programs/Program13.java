// This proram lists all files in a specified directory
// This Program also give relative path of files in the directory
// Example:
// Final_Destination\Demo.txt
// Final_Destination\Hello.txt
// Final_Destination\PPA.txt

package Packer_Unpacker;

import java.io.File;
import java.util.Scanner;

public class Program13
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
                int i = 0;

                System.out.println("Details of files in the directory : ");
                System.out.println("-------------------------------------------------");
                for(i = 0; i < Arr.length; i++)
                {
                    System.out.println("File number : " + (i + 1));
                    System.out.println("Path :"+Arr[i]);
                    System.out.println("Name of file :"+Arr[i].getName());
                    System.out.println("Size of file :"+Arr[i].length() + " bytes");
                    System.out.println("Is it a file? " + Arr[i].isFile());
                    System.out.println();
                }
                System.out.println("-------------------------------------------------");
            }
            else
            {
                System.out.println("There is no such directory");
            }
        }
    }    
}
