package com.example.android.footballteam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TeamAdpter adapter;
    RecyclerView rvTeam;
    ArrayList<Team> listTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new TeamAdpter(this);
        rvTeam = findViewById(R.id.rvTeam);
        listTeam = new ArrayList<>();

        LoadAPI();
    }

    private void LoadAPI() {
        String Url = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier% 20League";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj_1 = new JSONObject(response);
                    JSONArray array = obj_1.getJSONArray("teams");

                    for (int i = 0; 1<array.length();i++){
                        JSONObject obj_2 = array.getJSONObject(i);
                        Team team = new Team(obj_2);
                        listTeam.add(team);

                        rvTeam.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        adapter.setListTeam(listTeam);
                        rvTeam.setAdapter(adapter);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
