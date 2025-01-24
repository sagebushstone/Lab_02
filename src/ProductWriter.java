import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args){
        SafeInputObj sio = new SafeInputObj();

        ArrayList<Product> productList = new ArrayList<>();
        boolean moreProducts = true;

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.csv");
        Path fileJSON = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.json");
        Path fileXML = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.xml");

        do {
            Product prod = new Product();
            prod.setID(sio.getNonZeroLenString("Enter the Product ID"));
            prod.setName(sio.getNonZeroLenString("Enter the Product Name"));
            prod.setDescription(sio.getNonZeroLenString( "Enter the Description"));
            prod.setCost(sio.getRangedDouble("Enter the Cost", 0, 99999));
            moreProducts = sio.getYNConfirm("Do you wish to enter another product?");

            productList.add(prod);
        } while (moreProducts);

        for(int i=0; i<productList.size(); i++){
            System.out.println(productList.get(i));
        }

        // copied from NIOWriteText
        try
        {
            OutputStream outCSV =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writerCSV =
                    new BufferedWriter(new OutputStreamWriter(outCSV));

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

            writerJSON.write("{\"Product\":[");
            writerXML.write("<Products>");
            for(Product rec : productList)
            {
                writerCSV.write(rec.toCSV());
                writerCSV.newLine();

                writerJSON.write(rec.toJSON());
                if(!rec.equals(productList.get(productList.size()-1))){
                    writerJSON.write(",");
                }
                else{
                    writerJSON.write("]}");
                }
                writerJSON.newLine();

                // writes the XML file
                writerXML.write(rec.toXML());
                if(rec.equals(productList.get(productList.size()-1))){
                    writerXML.write("</Products>");
                }
                writerXML.newLine();
            }
            writerCSV.close();
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
