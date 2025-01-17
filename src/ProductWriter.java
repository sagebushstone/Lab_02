import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args){
        String userId = "";
        String name = "";
        String description = "";
        double cost = 0;
        ArrayList<String> productList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean moreProducts = true;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        do {
            userId = SafeInput.getNonZeroLenString(in, "Enter the Product ID");
            name = SafeInput.getNonZeroLenString(in, "Enter the Product Name");
            description = SafeInput.getNonZeroLenString(in, "Enter the Description");
            cost = SafeInput.getRangedDouble(in, "Enter the Cost", 0, 99999);
            moreProducts = SafeInput.getYNConfirm(in, "Do you wish to enter another product?");

            String concatRecord = userId + ", " + name + ", " + description + ", " +
                    cost;

            productList.add(concatRecord);
        } while (moreProducts);

        for(int i=0; i<productList.size(); i++){
            System.out.println(productList.get(i));
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

            for(String rec : productList)
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
