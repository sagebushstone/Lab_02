public class Sandbox {
    public static void main(String args[]){
        Product pers = new Product("000001", "apple", "fuji", 2005);
        System.out.println(pers.toJSON());

        Person p = new Person("000001", "Sage", "BS", "dr.", 2005);
        System.out.println(p.toXML());
    }
}
