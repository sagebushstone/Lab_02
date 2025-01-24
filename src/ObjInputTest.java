public class ObjInputTest {
    public static void main(String args[]) {
        SafeInputObj sio = new SafeInputObj();

        String nonZeroString = sio.getNonZeroLenString("Enter a non zero length string");
        System.out.println(nonZeroString);
        int getRangedInt = sio.getRangedInt("Enter an int", 0, 10);
        System.out.println(getRangedInt);
        int getInt = sio.getInt("Enter an int");
        System.out.println(getInt);
        double getRangedDouble = sio.getRangedDouble("Enter a double", 0, 10);
        System.out.println(getRangedDouble);
        double getDouble = sio.getDouble("Enter a double");
        System.out.println(getDouble);
        boolean getYN = sio.getYNConfirm("Yes or no?");
        System.out.println(getYN);
        String getRegex = sio.getRegExString("Enter regex", "hi*");
        System.out.println(getRegex);
    }
}