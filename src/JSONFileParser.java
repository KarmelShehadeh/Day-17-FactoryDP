import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;

public class JSONFileParser implements FileParser{
    @Override
    public void pars() {
        JSONParser parser = new JSONParser();//here i have an error:(
        try {
            FileWriter resultFile=new FileWriter("D:\\result.txt");//txt file to print the result in it

            Object obj = parser.parse(new FileReader("SI1.json"));//also here there is an error

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray rows = jsonObject.getJSONArray("rows"); // Get all JSONArray rows

            for(int i=0; i < rows.length(); i++) { // Loop over each each row
                JSONObject row = rows.getJSONObject(i); // Get row object
                JSONArray elements = row.getJSONArray("note"); // Get all elements for each row as an array

                resultFile.write("----------------------------");

                for(int j=0; j < elements.length(); j++) { // Iterate each element in the elements array
                    JSONObject element =  elements.getJSONObject(j); // Get the element object
                    JSONObject to = element.getJSONObject("to"); // Get to sub object
                    JSONObject from = element.getJSONObject("from"); // Get from sub object
                    JSONObject heading = element.getJSONObject("heading"); // Get heading sub object
                    JSONObject body = element.getJSONObject("body"); // Get body sub object



                    resultFile.write("to: " + to.getInt("value")); // Print to value
                    resultFile.write("from: " + from.getInt("value")); // Print from value
                    resultFile.write("heading: " + heading.getInt("value")); // Print heading value
                    resultFile.write("body: " + body.getInt("value")); // Print body value

                } }}
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
