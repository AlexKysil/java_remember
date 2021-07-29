import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arraysTest {
    public static void main(String[] args){
        String[] array1 = new String [4];
        array1[0] = "Java";
        array1[1] = "Python";
        array1[2] = "C#";
        array1[3] = "JavaScript";

        for (int i = 0; i < array1.length; i++){
            System.out.println("Here is new sctring with " + array1[i]);
        }

        System.out.println("\n \n");

        String[] array2 = {"Java", "Python", "C#", "JavaScript"};
        for(String i : array2){
            System.out.println("Here is new sctring with " + i);
        }

        System.out.println("\n \n");

        ArrayList<String> langs1 = new ArrayList<String>();
        langs1.add("Java");
        langs1.add("Python");
        langs1.add("C#");
        langs1.add("JavaScript");

        for (int i = 0; i < langs1.size(); i++){
            System.out.println("ArrayList "  + langs1.get(i));
        }

        System.out.println("\n \n");

        List<String> lang2 = Arrays.asList("Java", "Python", "C#", "JavaScript");

        for(String language : lang2){
            System.out.println("List here: " + language);
        }
    }
}
