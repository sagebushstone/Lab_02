import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args){
        String userId = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int birthYear = 0;
        ArrayList<String> userList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean allUsers = true;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        do {
            userId = SafeInput.getNonZeroLenString(in, "Enter the User ID");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the First Name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the Last Name");
            title = SafeInput.getNonZeroLenString(in, "Enter the Title");
            birthYear = SafeInput.getRangedInt(in, "Enter the Year of Birth", 1000, 9999);
            allUsers = SafeInput.getYNConfirm(in, "Do you wish to enter another user?");

            String concatRecord = userId + ", " + firstName + ", " + lastName + ", " +
                    title + ", " + birthYear;

            userList.add(concatRecord);
        } while (allUsers);

        for(int i=0; i<userList.size(); i++){
            System.out.println(userList.get(i));
        }

        // copied from NIOWriteText
        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String rec : userList)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line
            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}

