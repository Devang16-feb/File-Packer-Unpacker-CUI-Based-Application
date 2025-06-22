package Packer_Unpacker;

import java.io.File;
import java.util.Scanner;

public class Program14 
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
                File Arr[] = fobj.listFiles();

                System.out.println("Number of files in directory are : "+Arr.length);

                String Header = Arr[0].getName();
                Header = Header + " " + Arr[0].length();

                System.out.println("Header of first file is : ");   // "Demo.txt 10"
                System.out.println(Header);

                System.out.println("Length of header is : "+Header.length()); // 11 bytes 
                // But Here We want 100 bytes size of Header file, So We have to add 89 bytes in it by adding space in betweem  them
                // By adding space in betwen them using loop

                int i = 0;

                for(i = Header.length(); i < 100; i++)
                {
                    Header += " ";
                }

                System.out.println("Header of first file after updation is : ");   // "Demo.txt 10__...__"By adding 89 space in it.
                System.out.println(Header);

                System.out.println("Length of header after updation is : "+Header.length()); // 100 Bytes
                // Now it cover 100 Bytes of Header file , According to diagram of packed File...

            }
            else
            {
                System.out.println("There is no such directory");
            }
        }    
    }    
}
