import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        SafeInputObj sio = new SafeInputObj(in);

        // ArrayList of type Person to hold the objects
        ArrayList<Person> userList = new ArrayList<>();
        boolean moreUsers = true;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.csv");
        Path fileJSON = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.json");
        Path fileXML = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.xml");

        do {
            Person pers = new Person();
            pers.setId(sio.getNonZeroLenString("Enter the User ID"));
            pers.setFirstName(sio.getNonZeroLenString("Enter the First Name"));
            pers.setLastName(sio.getNonZeroLenString("Enter the Last Name"));
            pers.setTitle(sio.getNonZeroLenString("Enter the Title"));
            pers.setYob(sio.getRangedInt("Enter the Year of Birth", 1000, 9999));
            moreUsers = sio.getYNConfirm( "Do you wish to enter another user?");

            userList.add(pers);
        } while (moreUsers);

        for(int i=0; i<userList.size(); i++){
            System.out.println(userList.get(i));
        }

        // copied from NIOWriteText
        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // creates objects for JSON
            OutputStream outJSON =
                    new BufferedOutputStream(Files.newOutputStream(fileJSON, CREATE));
            BufferedWriter writerJSON =
                    new BufferedWriter(new OutputStreamWriter(outJSON));

            // creates objects for XML
            OutputStream outXML =
                    new BufferedOutputStream(Files.newOutputStream(fileXML, CREATE));
            BufferedWriter writerXML =
                    new BufferedWriter(new OutputStreamWriter(outXML));

            writerJSON.write("{\"Person\":[");
            writerXML.write("<Persons>");
            for(Person rec : userList)
            {
                // writes the line in CSV format
                writer.write(rec.toCSV());
                writer.newLine();

                // writes the line in JSON file
                writerJSON.write(rec.toJSON());
                if(!rec.equals(userList.get(userList.size()-1))){
                    writerJSON.write(",");
                }
                else{
                    writerJSON.write("]}");
                }
                writerJSON.newLine();

                // writes the XML file
                writerXML.write(rec.toXML());
                if(rec.equals(userList.get(userList.size()-1))){
                    writerXML.write("</Persons>");
                }
                writerXML.newLine();
            }
            writer.close();
            writerJSON.close();
            writerXML.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}

