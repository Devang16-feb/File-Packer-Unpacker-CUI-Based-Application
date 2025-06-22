// This is the Final program to demostrate combined use of packing and unpacking functionality in a Packer Unpacker application.

package Packer_Unpacker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;


public class Packing_Unpacking_Final 
{
    public static void main(String[] args) throws Exception 
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("----------------------------------------------------------");
            System.out.println("------- Devang Packer Unpacker Complete CUI Module -------");
            System.out.println("----------------------------------------------------------");
            System.out.println("Welcome to the Packer Unpacker Application!");

            System.out.println("please choose an option from the menu below:");
            System.out.println("1. Packing");
            System.out.println("2. Unpacking");
            System.out.println("3. help");
            System.out.println("4. Exit");
            System.out.println();

            
            int choice = 0, iRet = 0;
            
            while(true)
            {
                System.out.println("Enter your choice (1-4): ");
                choice = sobj.nextInt();
                sobj.nextLine();  // clears newline buffer

                if(choice == 1)
                {
                    System.out.println("You have chosen Packing.");
                    PackingFunctionality Aobj = new PackingFunctionality();
                    iRet = Aobj.packing(sobj);

                    if(iRet == 0)
                    {
                        System.out.println("Succesfully completed Packing Activity....");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Unable to complete packing Activity....");
                        break;
                    }
                }
                else if(choice == 2)
                {
                    System.out.println("You have chosen Unpacking.");
                    UnpackingFunctionality Bobj = new UnpackingFunctionality();
                    iRet = Bobj.unpacking(sobj);

                    if(iRet == 0)
                    {
                        System.out.println("Succesfully completed Unpacking Activity....");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println("Unable to complete packing Activity....");
                        break;
                    } 
                }
                else if(choice == 3)
                {
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println("Help Section:");
                    System.out.println("1. Packing: This option allows you to pack files into a compressed format.");
                    System.out.println("2. Unpacking: This option allows you to unpack files from a compressed format.");
                    System.out.println("3. Help: This option will help you to get list function cases in our application");
                    System.out.println("4. Exit: This option exits the application.");
                    System.out.println("------------------------------------------------------------------------------");
                    System.out.println();
                }
                else if(choice == 4)
                {
                    System.out.println("Exiting the application. Thank you for using Packer Unpacker!");
                    break;
                }
                else
                {
                    System.out.println("Invalid choice! Please select a valid option from the menu.");
                }
            }
        }
    }
    
}


class PackingFunctionality 
{
    private FileOutputStream fOut;
    private FileInputStream fIn;
    private String FolderName;
    private File folderObj;
    private String PackedFileName;
    private File packedFileObj;
    private boolean bRet;

    public PackingFunctionality() 
    {
        this.fOut = null;
        this.fIn = null;
        this.FolderName = null;
        this.folderObj = null;
        this.PackedFileName = null;
        this.packedFileObj = null;
        this.bRet = false;
    }

    public int packing(Scanner sobj) throws Exception
    {
        System.out.println("Enter the name of Directory that you want to open for packing: ");
        FolderName = sobj.nextLine();

        folderObj = new File(FolderName);

        System.out.println("Enter tha name of packed file that you want to create: ");
        PackedFileName = sobj.nextLine();
        System.out.println();

        packedFileObj = new File(PackedFileName);

        bRet = packedFileObj.createNewFile();

        if(bRet == false)
        {
            System.out.println("Unable to create packed File....!");
            return -1;
        }

        fOut = new FileOutputStream(packedFileObj);
        
        if(packedFileObj.exists())
        {
            byte []DataBuffer = new byte[1024];
            String Header = null;
            int readData = 0, iCount = 0;

            File Arr[] = folderObj.listFiles();
            System.out.println("No of Files in Directory that you want to packed are :"+ Arr.length);
            System.out.println();

            System.out.println("Packing Activity Start........");

            for(int i=0; i < Arr.length; i++)
            {
                Header = Arr[i].getName();

                if(Header.endsWith(".txt"))
                {
                    Header = Header + " " + Arr[i].length();

                    for(int j = Header.length(); j < 100; j++)
                    {
                        Header = Header + " ";
                    }
                    System.out.println("Header file name of file no "+(i+1)+" is : "+Header);
                    
                    fOut.write(Header.getBytes(), 0, 100);

                    fIn = new FileInputStream(Arr[i]);

                    while((readData = fIn.read(DataBuffer)) != -1)
                    {
                        fOut.write(DataBuffer, 0, readData);
                    }
                    iCount++;
                    fIn.close();
                }
            }
            System.out.println();
            System.out.println("Here we have packed Total "+iCount+" no. of files into :"+PackedFileName);
            fOut.close();
        }
        else
        {
            System.out.println("There is no such directory !");
            return -1;
        }

        return 0;

    }
}

class UnpackingFunctionality 
{
    private byte[] headerBuffer;// new byte[100];
    private byte[] dataBuffer;
    private String packedFileName;
    private File packedObj;
    private String Headerx;
    private String[] headerParts;
    private File unpackedObj;
    private int FileSize;
    private FileOutputStream fOut;
    private FileInputStream fIn;
    private int iCount;
    private boolean bRet;

    public UnpackingFunctionality()
    {
        this.headerBuffer = new byte[100];
        this.dataBuffer = null;
        this.packedFileName = null;
        this.packedObj = null;
        this.Headerx = null;
        this.headerParts = null;
        this.unpackedObj = null;
        this.FileSize = 0;
        this.fOut = null;
        this.fIn = null;
        this.iCount = 0;
        this.bRet = false;
    }

    public int unpacking(Scanner sobj) throws Exception
    {
        System.out.println("Enter the name of packed file that you want to open for unpacking file :");
        packedFileName = sobj.nextLine();

        packedObj = new File(packedFileName);

        if(!packedObj.exists())
        {
            System.out.println("File " + packedFileName + " does not exist !");
            return -1;
        }

        fIn = new FileInputStream(packedObj);

        System.out.println();
        System.out.println("Unpacking Activity Starts.......");
        System.out.println();

        while(fIn.read(headerBuffer, 0, 100) > 0)
        {
            Headerx = new String(headerBuffer);
            Headerx = Headerx.trim();

            headerParts = Headerx.split(" ");

            unpackedObj = new File(headerParts[0]);
            System.out.println("Unpacking file Name :"+headerParts[0]);
            bRet = unpackedObj.createNewFile();

            if(bRet == false)
            {
                System.out.println("Unable to create unpacked file....!");
                return -1;
            }

            FileSize = Integer.parseInt(headerParts[1]);
            dataBuffer = new byte[FileSize];

            fIn.read(dataBuffer, 0, FileSize);

            fOut = new FileOutputStream(unpackedObj);

            fOut.write(dataBuffer, 0, FileSize);
            System.out.println("  No "+(iCount+1)+" unpacked file from packed file is: " + unpackedObj.getName());

            iCount++;
            System.out.println();
            fOut.close();
        }
        fIn.close();
        System.out.println("Here we have Unpacked Total "+iCount+" no. of files form :"+packedFileName);
        return 0;
    }
}


