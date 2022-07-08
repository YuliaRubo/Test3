import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadFromFile {
    public static List<Product> getInfoFromFile() {
        JSONParser jsonParser = new JSONParser();
        List<Product> listOfProduct = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("file.txt"))) {
            checkFile();

            String line = bf.readLine();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(line);
            for(Object it: jsonArray) {
                JSONObject productJsonObject = (JSONObject) it;
                long id = (long) productJsonObject.get(("id"));
                String name = (String) productJsonObject.get("name");
                long price = (long) productJsonObject.get(("price"));
                String docDate = (String) productJsonObject.get("date");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
                simpleDateFormat.applyPattern("dd-MM-yyyy");
                Date date = simpleDateFormat.parse(docDate);

                Product product = new Product( (int)id, name,(int) price,  date);
                listOfProduct.add(product);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmtySourceFile emtySourceFile) {
            emtySourceFile.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return listOfProduct;
    }

    private static void checkFile() throws EmtySourceFile {
        File sourceFile = new File("file.txt");
        if (sourceFile.length() == 0) {
            throw new EmtySourceFile("Файл Пуст");
        }
    }
}


