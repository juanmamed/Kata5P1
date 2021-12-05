/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juanma
 */
public class MailListReader {
     public static List<String> read(String nameFile) {
        List<String> list = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
            while(true){
                String line = reader.readLine();
                if (line == null) break;
                if (MailListReader.isMail(line)) list.add(line);
            }
        }
        catch(FileNotFoundException exception) {
            System.out.println("Error MailListReader::read (FileNotFound)" + exception.getMessage());
        }
        catch(IOException exception){
            System.out.println("Error MailListReader::read (IO)" + exception.getMessage());
        }
        
        return list;
    }
     
    public static boolean isMail(String line){
        return line.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    }
}
