// This program is a simple command-line interface (CUI) module for a Packer Unpacker application.

package Packer_Unpacker;
import java.util.Scanner;

public class Program2 
{
    public static void main(String[] args) 
    {
        try (Scanner Sobj = new Scanner(System.in)) 
        {
            System.out.println("------ Devang Packer UnPacker CUI Module------");

            System.out.println("Enter the File Name :");
            String File_Name = Sobj.nextLine();

            System.out.println("Entered file name is :"+File_Name);
        }
    }
}
