import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class FileHandling{
    public static void main(String []args) throws Exception{
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("1. Create a New File");
            System.out.println("2. Write inside a file");
            System.out.println("3. Read a file");
            System.out.println("4. Delete a file");
            String fileName;
            char c = in.next().charAt(0);
            switch(c){
                case '1': System.out.print("Enter a file name: ");
                          fileName = in.next();
                          File myFile = new File(fileName);
                          if(myFile.createNewFile())
                             System.out.println("File is created !");
                          else
                             System.out.println("File is already exist!");
                break;

                case '2': System.out.println("Enter a file name: ");
                          fileName = in.next();
                          FileWriter fileWriter = new FileWriter(fileName);
                          fileWriter.write("message");
                          
                          fileWriter.close();

                break;

                case '3': System.out.println("Enter a file name: ");
                          fileName = in.next();
                          File file = new File(fileName);
                          Scanner sc = new Scanner(file);

                          while(sc.hasNextLine())
                            System.out.println(sc.nextLine());

                          sc.close();
                break;

                case '4': System.out.println("Enter a file name: ");
                          fileName = in.next();
                          File dfile = new File(fileName);
                          if(dfile.delete())
                            System.out.println("Sucessfully Delete file");
                          else 
                            System.out.println("Faild to delete a file");

                default: in.close();
                         System.exit(0); 
            }
        }        
    }
}