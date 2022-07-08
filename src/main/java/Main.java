import java.util.List;

public class Main {
    public static void main(String[] args) {
      List<Product> newMy = ReadFromFile.getInfoFromFile();
        System.out.println(newMy);
    }
}
