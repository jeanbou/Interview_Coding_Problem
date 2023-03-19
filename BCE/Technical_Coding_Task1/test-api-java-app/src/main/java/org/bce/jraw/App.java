package org.bce.jraw;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	// Host url
        String host = "https://api.tvmaze.com/search/shows";
        String charset = "UTF-8";
        // Headers for a request
        String x_rapidapi_host = "api.tvmaze.com";
        String x_rapidapi_key = "Nv7wn_uV7yc2N-Jkh3e94AKGLOECzChY";//Type here your key
        // Params
        String s = "girls";
        String query = "";
       // Format query for preventing encoding problems
        try {
           query = String.format("s=%s",URLEncoder.encode(s, charset));
        } catch (UnsupportedEncodingException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        HttpResponse<JsonNode> response;
        try {
            /*response = Unirest.get(host + "?q=" + query)
                    .header("x-rapidapi-host", x_rapidapi_host)
                    .header("x-rapidapi-key", x_rapidapi_key)
                    .asJson();
          //Prettifying
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(response.getBody().toString());
            String prettyJsonString = gson.toJson(je);
            System.out.println(prettyJsonString);*/
            JSONArray results = Unirest.get(host + "?q=" + query)
                    .header("x-rapidapi-host", x_rapidapi_host)
                    .header("x-rapidapi-key", x_rapidapi_key)
                    .asJson().getBody().getArray();
            //Prettifying
            // myObj = response.getBody().getObject();
            
            for(int i=0;i<results.length();i++)
            {
                JSONObject jsonObject = results.getJSONObject(i);

                //names [i] = jsonObject.getString("id");
                //formattedNames [i] = jsonObject.getString("formattedName");
                //System.out.println(" : "+jsonObject.toString());
                //System.out.println("id : "+jsonObject.getJSONObject("show"));
                //System.out.println("title : "+jsonObject.getJSONObject("show").get("name").toString());
                //System.out.println("year : "+jsonObject.getJSONObject("show").get("premiered").toString());
                //System.out.println("id : "+jsonObject.getJSONObject("show").get("id").toString());
                //System.out.println("year : "+jsonObject.getJSONObject("show").getJSONObject("rating").get("average").toString());
                        //String("imbd"));
              }
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        System.out.println( "Hello World!" );
    }
}
