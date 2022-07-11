import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadUtil {
    public static String getNewString(String str) {
        String newStr = str;
        String[] myNewArray = newStr.split(" ");
        String namePerson = myNewArray[0];
        String vacancyName = myNewArray[1];
        return namePerson;
    }

    public static Integer getNewNumber(String str) {
        String newStr = str;
        String[] myNewArray = newStr.split(" ");
        String namePerson = myNewArray[0];
        String vacancyName = myNewArray[1];
        int num = Integer.parseInt(vacancyName);
        return num;
    }

    public static String getNewStringTwo(String str) {
        String newStr = str;
        String[] myNewArray = newStr.split(" ");
        String namePerson = myNewArray[0];
        String vacancyName = myNewArray[1];
        return namePerson;
    }

    public static String getNewStringTwo1(String str) {
        String newStr = str;
        String[] myNewArray = newStr.split(" ");
        String namePerson = myNewArray[0];
        String vacancyName = myNewArray[1];
        return vacancyName;
    }

    public static Date getNewDate(String str) throws ParseException {
        String newStr = str;
        String[] myNewArray = newStr.split(" ");
        String namePerson = myNewArray[0];
        String vacancyDate = myNewArray[1];
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String dateVac = vacancyDate;
        Date date = formatter.parse(dateVac);
        return date;
    }

    public static List<Product> getOnlyAsStringCome(List<Product> prt, String line) {
        List<Product> prst = prt;
        List<Product> prst1 = new ArrayList<>();
        String lineNew = line;
        for (Product p : prst) {
            if (p.getName().contains(lineNew))
                prst1.add(p);
        }

        return prst1;
    }

    public static List<Product> getProductFromPrice(List<Product> list, Integer numLess) {
        List<Product> listNew = list;
        Integer num = numLess;
        List<Product> listNewLess = new ArrayList<>();
        for (Product p : listNew) {
            if (p.getPrice() < numLess)
                listNewLess.add(p);
        }

        return listNewLess;
    }

    public static List<Product> getProductFromPriceMore(List<Product> list, Integer numLess) {
        List<Product> listNew = list;
        Integer num = numLess;
        List<Product> listNewLess = new ArrayList<>();
        for (Product p : listNew) {
            if (p.getPrice() > numLess)
                listNewLess.add(p);
        }

        return listNewLess;
    }

    public static List<Product> getProductOnlySort(List<Product> list, Date dateAfter, Date dateBefor) {
        List<Product> listProduct = list;
        List<Product>newList = new ArrayList<>();
        Date date1 = dateAfter;
        Date date3 = dateBefor;
        for(Product p: listProduct) {
            Date date2 = p.getDate();
            if(date2.after(date1)&&date2.before(date3))
                newList.add(p);
        }
        return newList;
    }
public static List<String> getJsonFromList(List<Product>list) throws ParseException, JsonProcessingException {
    List<String> listNew = new ArrayList<>();
    String json = null;
    for (Product p : list) {
        Product product = new Product();
        product.setId(p.getId());
        product.setName(p.getName());
        product.setPrice(p.getPrice());
        product.setDate(p.getDate());
        ObjectMapper objectMapper = new ObjectMapper();
        json = objectMapper.writeValueAsString(product);
        listNew.add(json);
        //System.out.println(json);
    }
    return listNew;
}
//    List<Product> listNew = list;
//    ObjectMapper mapper = new ObjectMapper();
//    String json = null;
//    for (Product p : listNew) {
//        Product pd = new Product();
//        SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
//
//        json = mapper.writeValueAsString(pd);
//    }
//
//
//    return json;

//        List<Product>listNew = list;
//        //for (Product p: listNew){
//           // String jsonA = JSONArray.toJSONString(listNew);
//    Product product = new Product();
//    SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
//    product.setDate(dateformat.parse(product.getDate()));
//
//    ObjectMapper mapper = new ObjectMapper();
//    String json = mapper.writeValueAsString(product);
//    System.out.println(json);
//    return json;
//}
}


