import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReadFromFile {
    public static List<Product> getInfoFromFile() {
       //JSONParser jsonParser = new JSONParser();
        List<Product> myObjects = new ArrayList<>();

       try (BufferedReader bf = new BufferedReader(new FileReader("file.txt"))) {
            checkFile();
           String line = bf.readLine();
           ObjectMapper mapper = new ObjectMapper();
           myObjects = mapper.readValue(line, new TypeReference<List<Product>>(){});
//           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

           DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
           mapper.setDateFormat(df);


//           Product product= gson.fromJson(line, Product.class);
//           listOfProduct.add(product);
//            JSONArray jsonArray = (JSONArray) jsonParser.parse(line);
//            for(Object it: jsonArray) {
//                JSONObject productJsonObject = (JSONObject) it;
//                long id = (long) productJsonObject.get(("id"));
//                String name = (String) productJsonObject.get("name");
//                long price = (long) productJsonObject.get(("price"));
//                String docDate = (String) productJsonObject.get("date");
//               DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
//                 //simpleDateFormat.applyPattern("dd.MM.yyyy");
//             LocalDate date = LocalDate.parse(docDate,format );
//                Product product = new Product( (int)id, name,(int) price,  date);
//                listOfProduct.add(product);
//            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmtySourceFile emtySourceFile) {
            emtySourceFile.printStackTrace();

//        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return myObjects;
    }

    private static void checkFile() throws EmtySourceFile {
        File sourceFile = new File("file.txt");
        if (sourceFile.length() == 0) {
            throw new EmtySourceFile("Файл Пуст");
        }
    }
}


