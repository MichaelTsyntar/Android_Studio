package com.example.meteo;

import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText user_field;
    private Button main_btn;
    private Button moreBtn;
    private TextView result_info;
    private ImageView mainBack;

    private String description;
    private String temp_min;
    private String temp_max;
    private String pressure;
    private String humidity;
    private String lon;
    private String lat;
    private String temp;
    private String feels_like;
    private String visibility;
    private String  speed;
    private String sunrise;
    private String sunset;
    private String timezone;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_field = findViewById(R.id.user_field);
        main_btn = findViewById(R.id.main_btn);
        result_info = findViewById(R.id.result_info);
        mainBack = findViewById(R.id.main_back);
        moreBtn = findViewById(R.id.more_btn);

        main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_field.getText().toString().trim().equals(""))
                    Toast.makeText(MainActivity.this, R.string.no_user_input, Toast.LENGTH_LONG).show();
                else {
                    String city = user_field.getText().toString();


                    String key = "dd9d44598c2d27b9970b892289bc60a2";
                    String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key + "&units=metric&lang=ru";

                    new GetURLData().execute(url);
                }
            }
        });

    }



    private class GetURLData extends AsyncTask<String, String, String> {


        protected void onPreExecute() {
            super.onPreExecute();
            result_info.setText("Очікуйте...");
        }

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null)
                    buffer.append(line).append("\n");
                return buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null)
                    connection.disconnect();
                try {
                    if (reader != null)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result);

            try {
                JSONObject jsonObject = new JSONObject(result);

                result_info.setText("Температура: " + jsonObject.getJSONObject("main").getDouble("temp"));

                //Toast.makeText(MainActivity.this, jsonObject.getJSONArray("weather").getJSONObject(0).getString("description"), Toast.LENGTH_SHORT).show();
                lon = "Довгота: " +jsonObject.getJSONObject("coord").getString("lon");
                lat = "Широта: " +jsonObject.getJSONObject("coord").getString("lat");

                temp = "Температура: " + jsonObject.getJSONObject("main").getString("temp");
                feels_like = "Відчувається як: " + jsonObject.getJSONObject("main").getString("feels_like");
                temp_min = "Мінімальна температура: " + jsonObject.getJSONObject("main").getString("temp_min");
                temp_max = "Максимальна температура: " + jsonObject.getJSONObject("main").getString("temp_max");
                pressure = "Атмосферний тиск: " +jsonObject.getJSONObject("main").getString("pressure");
                humidity = "Вологість: " +jsonObject.getJSONObject("main").getString("humidity");
                visibility = "Видимість: "+jsonObject.getString("visibility");
                speed = "Швидкість вітру: "+jsonObject.getJSONObject("wind").getString("speed");
                sunrise = "Схід сонця: "+jsonObject.getJSONObject("sys").getString("sunrise");
                sunset = "Захід сонця: "+jsonObject.getJSONObject("sys").getString("sunset");
                timezone = "Таймзона: "+jsonObject.getString("timezone");;
                 name ="Назва міста: "+jsonObject.getString("name");;

                description = "Опис: "+ jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");

                switch (jsonObject.getJSONArray("weather").getJSONObject(0).getString("description")){

                    case "ясно" : {
                        Glide.with(MainActivity.this)
                                .load(R.drawable.easno)
                                .into(mainBack);
                    }break;
                    case "пасмурно" : {
                        Glide.with(MainActivity.this)
                                .load(R.drawable.pasmurno)
                                .into(mainBack);
                    }break;
                    case "переменная облачность" : {
                        Glide.with(MainActivity.this)
                                .load(R.drawable.pasmurno)
                                .into(mainBack);
                    }break;
                    case "туман" : {
                        Glide.with(MainActivity.this)
                                .load(R.drawable.pasmurno)
                                .into(mainBack);
                    }break;
                }


            } catch (Exception e) {
                e.printStackTrace();
                result_info.setText("Введите правильное название города");
            }
            moreBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("DESCRIPTION1", lon);
                    intent.putExtra("DESCRIPTION2", lat);
                    intent.putExtra("DESCRIPTION3", description);
                    intent.putExtra("DESCRIPTION4", temp);
                    intent.putExtra("DESCRIPTION5", feels_like);
                    intent.putExtra("DESCRIPTION6", temp_max);
                    intent.putExtra("DESCRIPTION7", temp_min);
                    intent.putExtra("DESCRIPTION8", pressure);
                    intent.putExtra("DESCRIPTION9", humidity);
                    intent.putExtra("DESCRIPTION10", visibility);
                    intent.putExtra("DESCRIPTION11", speed);
                    intent.putExtra("DESCRIPTION12", sunrise);
                    intent.putExtra("DESCRIPTION13", sunset);
                    intent.putExtra("DESCRIPTION14", timezone);
                    intent.putExtra("DESCRIPTION15", name);


                    startActivity(intent);

                }
            });

        }
    }
}

