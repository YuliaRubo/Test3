import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ReadFromFile {
    public static List<Product> getInfoFromFile() {
       //JSONParser jsonParser = new JSONParser();
        List<Product> myObjects = new ArrayList<>();
        List<Product> newProduct = new ArrayList<>();
        List<Product> newProductLessPrice = new ArrayList<>();
        List<Product>newProductMorePrice = new ArrayList<>();
        List<Product>newProductDate = new ArrayList<>();
        String result=null;
       try (BufferedReader bf = new BufferedReader(new FileReader("file.txt"))) {
            checkFile();
           String line = bf.readLine();
           ObjectMapper mapper = new ObjectMapper();
           myObjects = mapper.readValue(line, new TypeReference<List<Product>>(){});
//           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

           DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
           mapper.setDateFormat(df);
           line = bf.readLine();
           String NAME_CONTAINS = ReadUtil.getNewString(line);
           String notebook = ReadUtil.getNewStringTwo1(line);
           line = bf.readLine();
           String PRICE_GREATER_THAN = ReadUtil.getNewString(line);
           Integer priceGreaterThen = ReadUtil.getNewNumber(line);
           line = bf.readLine();
           String PRICE_LESS_THAN = ReadUtil.getNewString(line);
           Integer priceLessThen = ReadUtil.getNewNumber(line);
           line=bf.readLine();
           String DATE_AFTER = ReadUtil.getNewString(line);
           Date dateAfter = ReadUtil.getNewDate(line);
           line=bf.readLine();
           String DATE_BEFORE = ReadUtil.getNewString(line);
           Date dateBefore = ReadUtil.getNewDate(line);

           newProduct=ReadUtil.getOnlyAsStringCome(myObjects,notebook);
           newProductLessPrice= ReadUtil.getProductFromPrice(newProduct, priceLessThen);
           newProductMorePrice = ReadUtil.getProductFromPriceMore(newProductLessPrice, priceGreaterThen);
           newProductDate=ReadUtil.getProductOnlySort(newProductMorePrice, dateAfter, dateBefore);
            //result = ReadUtil.getJsonFromList(newProductDate);


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
        } catch (ParseException e) {
           e.printStackTrace();
       }
        return newProductDate;
    }

    private static void checkFile() throws EmtySourceFile {
        File sourceFile = new File("file.txt");
        if (sourceFile.length() == 0) {
            throw new EmtySourceFile("Файл Пуст");
        }
    }
}


