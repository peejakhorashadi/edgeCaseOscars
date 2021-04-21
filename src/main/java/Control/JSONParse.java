package Control;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParse{
    public static void main(String[] args) throws IOException, ParseException{
        JSONParser jParse = new JSONParser();
        Object oscarEntity = jParse.parse(new FileReader("oscar_data.json"));
        JSONArray oscarList = (JSONArray) oscarEntity;
        String keyWord0 = "", keyWord1 = "", keyWord2 = "", keyWord3 = "";
        Scanner input = new Scanner(System.in);
        System.out.print("SEARCH BY: category, entity, winner, or year? ");
        switch(keyWord0 = input.nextLine()){
            case "category" -> {
                System.out.print("ENTER Category: ");
                keyWord1 = input.nextLine();
                System.out.print("EXPAND SEARCH by entity, winner, or year? (ENTER no if otherwise): ");
                switch(keyWord2 = input.nextLine()){
                    case "entity" -> {
                        System.out.print("ENTER Entity name: ");
                        keyWord3 = input.nextLine();
                    }
                    case "winner" -> {
                        // keyWord2 = "winner";
                    }
                    case "year" -> {
                        System.out.print("What year? ");
                        keyWord2 = input.nextLine();
                    }
                }
            }
            case "entity" -> {
                System.out.println("entity");
            }
            case "winner" -> {
                System.out.println("winner");
            }
            case "year" -> {
                System.out.println("year");
            }
        }
        for(Object obj: oscarList) displayJSON((JSONObject) obj, keyWord1, keyWord2, keyWord3);
    }

    private static void displayJSON(JSONObject oscar, String keyWord1, String keyWord2, String keyWord3){
        if(keyWord1.equals(oscar.get("category"))){
            if(keyWord2.equals("no")) soutJSON(oscar);
            if(keyWord2.equals("entity") && keyWord3.equals(oscar.get("entity"))) soutJSON(oscar);
            if(keyWord2.equals("winner") && (boolean) oscar.get("winner")) soutJSON(oscar);
            if(keyWord2.equals(Long.toString((Long) oscar.get("year")))) soutJSON(oscar);
        }
    }

    private static void soutJSON(JSONObject oscar){
        System.out.print("category : ");
        System.out.println(oscar.get("category"));
        System.out.print("entity   : ");
        System.out.println(oscar.get("entity"));
        System.out.print("winner   : ");
        System.out.println(oscar.get("winner"));
        System.out.print("year     : ");
        System.out.println(oscar.get("year"));
        System.out.println();
    }
}