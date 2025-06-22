// This Program is demonstrating how to create a packed file from a directory of text files and Write Header information for each file into the packed file.

package Packer_Unpacker;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Program17 
{
    public static void main(String[] args) throws Exception 
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("------- Devang Packer Unpacker CUI Module -------");

            System.out.println("Enter the name of Directory that you want to open : ");
            String FolderName = sobj.nextLine();

            File fobj = new File(FolderName);

            System.out.println("Enter the name of Packed file that you want to create : ");
            String PackedFileName = sobj.nextLine();

            File packObj = new File(PackedFileName);

            boolean bRet = packObj.createNewFile(); // Create a new file Outside  Final_Destination Directory
            if(bRet == false)
            {
                System.out.println("Unable to create packed file, it may already exist.");
                return;
            }

            // Now we Write all Header files in the Packed file
            try(FileOutputStream fOut = new FileOutputStream(packObj))
            {
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

                            fOut.write(Header.getBytes(), 0, 100); // Write the header to the packed file for each file store 100 bytes of header
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
}
