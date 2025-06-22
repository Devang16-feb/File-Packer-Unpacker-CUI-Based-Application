// Now in this Program we wiil work on all 3 progams togeter to perform unpacking of packed file.

// This Program is Final Program for unpacking of packed File.

package Packer_Unpacker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Program21 
{
    public static void main(String[] args) throws Exception
    {
        try (Scanner sobj = new Scanner(System.in)) 
        {
            System.out.println("This program will work on all 3 programs together to perform unpacking of packed file.");
            System.out.println();

            System.out.println("-----------------------------------------------------");
            System.out.println("--------- Devang Packer Unpacker CUI Module ---------");
            System.out.println("-----------------------------------------------------");

            System.out.println("---------------- Unpacking Activity -----------------");
            System.out.println();

            System.out.println("Enter the name of packed file that you want to open to unpacked file :");
            String packedFileName = sobj.nextLine();

            File packedObj = new File(packedFileName);

            if(!packedObj.exists())
            {
                System.out.println("File " + packedFileName + " does not exist.");
                return;
            }

            byte[] headerBuffer = new byte[100];
            byte[] dataBuffer;
            String Headerx = null;
            String[] headerParts = null;
            File unpackedObj = null;
            int FileSize = 0;
            FileOutputStream fOut = null;
            int iCount = 0; // Initialize a counter to keep track of the number of files unpacked

            FileInputStream fIn = new FileInputStream(packedObj);
            
            while((fIn.read(headerBuffer, 0, 100)) > 0)
            {
                Headerx = new String(headerBuffer); // Convert the byte array to a string
                Headerx = Headerx.trim(); // Trim any leading or trailing whitespace from the header string

                headerParts = Headerx.split(" "); // Split the header by spaces to get individual parts

                unpackedObj = new File(headerParts[0]); // Create a new File object with the name from the header
                System.out.println("Unpacking file: " + headerParts[0]);
                unpackedObj.createNewFile(); // Create the new individual (Unpacked) file if it does not exist

                FileSize = Integer.parseInt(headerParts[1]); // Parse the file size from the header
                dataBuffer = new byte[FileSize]; // Create a buffer to hold the file data

                fIn.read(dataBuffer, 0, FileSize); // Read the file data into the buffer

                fOut = new FileOutputStream(unpackedObj);// Create a FileOutputStream to write to the new file
                
                fOut.write(dataBuffer, 0, FileSize); // Write the data to the new file
                System.out.println("Data unpacked successfully to " + unpackedObj.getName());

                fOut.close(); // Close the FileOutputStream after writing the datas
                iCount++; // Increment the counter for each file unpacked
                System.out.println();
            }

            System.out.println("-----------------------------------------------------");
            System.out.println("Unpacking activity completed..");
            System.out.println("Number of files unpacked : "+iCount);
            System.out.println("-----------------------------------------------------");

            System.out.println("Thank you for using Devang Packer Unpacker tool");

            fIn.close(); // Close the FileInputStream after reading the data
        }
    }
}
