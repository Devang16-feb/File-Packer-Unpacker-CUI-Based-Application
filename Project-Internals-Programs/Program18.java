// In this program, we implement a simple file packing utility that reads all text files from a specified directory and packs them into a single file. 
//Each file's header contains its name and size, followed by the file's content. The packed file is created in the current working directory.

// till now, we have done packing of files, now we will implement the unpacking of files from the packed file, from next program onwards.
package Packer_Unpacker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Program18 
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

            System.out.println();
            System.out.println("Creating packed file with headers and contents of all text files in the specified directory...");
            try(FileOutputStream fOut = new FileOutputStream(packObj))
            {
                if(fobj.exists())
                {
                    String Header = null;
                    int j = 0, i = 0;

                    File Arr[] = fobj.listFiles();

                    System.out.println("Number of files in directory are : "+Arr.length);

                    int readBytes = 0;
                    byte[] buffer = new byte[1024]; // Buffer to read file contents
                    FileInputStream fIn = null;

                    for(i = 0; i < Arr.length; i++)
                    {
                        System.out.println("-------------------------------------------------");

                        Header = Arr[i].getName();
                        
                        if(Header.endsWith(".txt"))
                        {
                            Header = Header + " " + Arr[i].length(); // Adding file size to the header
                            
                            for(j = Header.length(); j < 100; j++)
                            {
                                Header += " "; // Adding spaces to make the header 100 bytes long
                            }
                            System.out.println("Header of file " + (i + 1) + " after updation is : "+ Header);   // "Demo.txt 10__...__"By adding spaces in it.
                            System.out.println("Length of header after updation is : "+Header.length()); // 100 Bytes

                            fOut.write(Header.getBytes(), 0, 100); // Write the header to the packed file for each file store 100 bytes of header
                            
                            fIn = new FileInputStream(Arr[i]); // Open the file to read its contents
                            while((readBytes = fIn.read(buffer)) != -1)
                            {
                                fOut.write(buffer, 0, readBytes); // Write the file contents to the packed file
                            }

                            System.out.println("Successfully we have create packed file with header and contents of file : " + Arr[i].getName());
                            fIn.close(); // Close the file input stream
                            System.out.println("-------------------------------------------------");
                        }
                    }

                }
                else
                {
                    System.out.println("There is no such directory");
                }
                fOut.close(); // Close the file output stream
            }
            
        }    
    }   
}
