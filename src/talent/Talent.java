/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talent;
import java.util.Scanner;
import com.opencsv.*;
import java.io.*;
/**
 *
 * @author roberto.cervantesana
 */
public class Talent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Scanner scan = new Scanner( System.in );
        System.out.println( "Enter CSV File to modify" );
        String fileName = scan.next();
        System.out.println( "Enter the new CSV File name" );
        String newFile = scan.next();
        System.out.println( "Enter your own separator" );
        char separator = scan.next().charAt( 0 );
        System.out.println( "Enter new separator" );
        char newSeparator = scan.next().charAt( 0 );
        File newFiles = new File( newFile );
        try
        {
            CSVReader reader = new CSVReader( new FileReader( fileName ) , separator );
            CSVWriter writer = new CSVWriter( new FileWriter( newFiles ), newSeparator );
            String[] nextLine;
            while( ( nextLine = reader.readNext() ) != null )
            {
                writer.writeNext( nextLine );
                writer.writeNext( "\n" );
            }
        }
        catch( FileNotFoundException ex )
        {
                  System.out.println( "File Not Found" );  
        }
        catch( IOException io )
        {
            
        }
    }
    
}
