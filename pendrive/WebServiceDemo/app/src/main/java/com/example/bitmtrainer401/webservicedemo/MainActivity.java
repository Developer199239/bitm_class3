package com.example.bitmtrainer401.webservicedemo;

import android.accounts.NetworkErrorException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    //String url="http://nerdcastlebd.com/_old-site/web_service/banglapoems/index.php/poets/all/format/json";
    String url="http://api.openweathermap.org/data/2.5/forecast/daily?lat=35&lon=139&cnt=10&mode=json&appid=7e1f2e5f657540ae37b23cfac170936c";
    ArrayList<String>nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.list);
        getDataFromWeb();

    }

    private void getDataFromWeb() {
        nameList=new ArrayList<>();
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                //Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                try {

                    //JSONObject city=response.getJSONObject("list");
                    JSONArray list=response.getJSONArray("list");
                    for(int i=0;i<list.length();i++){
                        String name=list.getJSONObject(i).getString("dt");
                        nameList.add(name);
                    }


                    ArrayAdapter<String>adapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,nameList);
                    listView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(error instanceof NoConnectionError){
                    Toast.makeText(MainActivity.this, "No internet Connection!!", Toast.LENGTH_SHORT).show();
                }
            }


        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

    }
}
