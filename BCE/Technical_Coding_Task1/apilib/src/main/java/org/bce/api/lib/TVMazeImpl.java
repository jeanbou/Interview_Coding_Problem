package org.bce.api.lib;

import java.util.ArrayList;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

class TVMazeImpl implements TVMaze {

    final String host = "https://api.tvmaze.com/search/shows";
    final String charset = "UTF-8";
    final String paramq = "?q=";
    final String x_rapidapi_host = "api.tvmaze.com";
    final String x_rapidapi_key_accessor = "x-rapidapi-key";

    TVMazeImpl() {
    }

    @Override
    public ArrayList<TVMazeContent> searchContent(String apiKey, String Query)  {
        ArrayList<TVMazeContent> aTVMazeContentList = new ArrayList<TVMazeContent>();
        String query = "";
        
        // Format query for preventing encoding problems
        try {
            query = String.format("s=%s",URLEncoder.encode(Query, charset));
        } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
        }
        try {
            JSONArray results = Unirest.get(host + paramq + query)
                    .header(x_rapidapi_host, x_rapidapi_host)
                    .header(x_rapidapi_key_accessor, apiKey)
                    .asJson().getBody().getArray();
            for(int i=0; i<results.length(); i++) {
                TVMazeContent aTVMazeContent = new TVMazeContent(results.getJSONObject(i).getJSONObject("show").get("id").toString(),
                                                                 results.getJSONObject(i).getJSONObject("show").get("name").toString(),
                                                                 results.getJSONObject(i).getJSONObject("show").get("premiered").toString(),
                                                                 results.getJSONObject(i).getJSONObject("show").getJSONObject("rating").get("average").toString());
                aTVMazeContentList.add(aTVMazeContent);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return aTVMazeContentList;
    }

}
