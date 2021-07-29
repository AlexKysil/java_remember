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
    }
}
