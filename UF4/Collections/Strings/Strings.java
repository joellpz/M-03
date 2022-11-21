package UF4.Collections.Strings;

public class Strings {
    public static void main(String[] args) {
        String s1 = new String("java");
        String s2 = new String("java");

        System.out.println(s1 == s2); //FALSE

        String s3 = "java";
        String s4 = "java";
        System.out.println(s3 == s4); //TRUE

        String s5="jdk";
        String s6 = new String ("jdk");
        System.out.println(s5 == s6); //FALSE


    }
}
