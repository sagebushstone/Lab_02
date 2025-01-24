//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public class Product {
    String name;
    String description;
    String ID;
    double cost;

    public Product() {

    }

    public Product(String ID, String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSV(){
        return ID + ", " + name + ", " + description + ", " + cost;
    }

    public String toJSON(){
        String Q = "\"";
        String QCM = "\", ";
        String QC = "\": \"";
        return "{" + Q + "ID" + QC + ID + QCM
                + Q + "name" + QC +  name + QCM
                + Q + "description" + QC + description + QCM
                + Q + "cost" + Q + ": " + cost  + "}";
    }

    public String toXML(){
        return "<Product>" +
                "<ID>" + ID + "</ID>" +
                "<name>" + name + "</name>" +
                "<description>" + description + "</description>" +
                "<cost>" + cost + "</cost>" + "</Product>";
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", cost=" + cost +
                '}';
    }
}
