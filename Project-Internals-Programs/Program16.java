package Packer_Unpacker;

import java.io.File;
import java.util.Scanner;

public class Program16 
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
                String Header = null;
                int j = 0, i = 0;

                File Arr[] = fobj.listFiles();

                System.out.println("Number of files in directory are : "+Arr.length);

                for(i = 0; i < Arr.length; i++)
                {
                    System.out.println("-------------------------------------------------");
                    System.out.println("File number : " + (i + 1));
                    System.out.println("Path :"+Arr[i]);
                    System.out.println("Name of file :"+Arr[i].getName());
                    System.out.println("Size of file :"+Arr[i].length() + " bytes");
                    System.out.println();

                    Header = Arr[i].getName();
                    
                    if(Header.endsWith(".txt"))
                    {
                        Header = Header + " " + Arr[i].length(); // Adding file size to the header
                        System.out.println("Header of file " + (i + 1) + " is : "+ Header);   // "Demo.txt 10"
                        
                        for(j = Header.length(); j < 100; j++)
                        {
                            Header += " "; // Adding spaces to make the header 100 bytes long
                        }
                        System.out.println("Header of file " + (i + 1) + " after updation is : "+ Header);   // "Demo.txt 10__...__"By adding spaces in it.
                        System.out.println("Length of header after updation is : "+Header.length()); // 100 Bytes
                        System.out.println("-------------------------------------------------");
                    }
                }

            }
            else
            {
                System.out.println("There is no such directory");
            }
        }    
    }  
}
