import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args){
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();

        final int FIELDS_LENGTH = 4;

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                try(InputStream in = new BufferedInputStream(Files.newInputStream(file));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
                {
                    int line = 0;
                    while (reader.ready()) {
                        rec = reader.readLine();
                        lines.add(rec);  // read all the lines into memory in an array list
                        line++;
                        // echo to screen
                        System.out.printf("\nLine %4d %-60s ", line, rec);
                    }
                }
                System.out.println("\n\nData file read!");


                String[] fields;
                for(String l:lines)
                {
                    fields = l.split(",");

                    if(fields.length == FIELDS_LENGTH)
                    {
                        Product prod = new Product(fields[0].trim(), fields[1].trim(), fields[2].trim(),
                                Double.parseDouble(fields[3].trim()));

                        System.out.printf("\n%8s%15s%30s%10.2f", prod.getID(), prod.getName(), prod.getDescription(), prod.getCost());
                    }
                    else
                    {
                        System.out.println("Found a record that may be corrupt: ");
                        System.out.println(l);
                    }
                }

            }
            else
            {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        }
           catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
           catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
