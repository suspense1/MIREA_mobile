package ru.mirea.ishutin.httpurlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import ru.mirea.ishutin.httpurlconnection.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> onClick());
    }

    public void onClick() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = null;
        if (connectivityManager != null) {
            networkinfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkinfo != null && networkinfo.isConnected()) {
            new DownloadPageTask().execute("https://ipinfo.io/json"); // запуск нового потока
        } else {
            Toast.makeText(this, "Нет интернета", Toast.LENGTH_SHORT).show();
        }
    }

    private class DownloadPageTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadIpInfo(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject responseJson = new JSONObject(result);

                if (responseJson.has("current_weather")) {
                    JSONObject weatherJson = new JSONObject(responseJson.getString("current_weather"));
                    binding.weatherText.setText("Temp: " + weatherJson.getString("temperature") + "\n" +
                            "Wind Speed: " + weatherJson.getString("windspeed") + "\n" +
                            "Wind Direction: " + weatherJson.getString("winddirection"));
                } else {
                    ListView listSensor	= binding.listView;

                    //	создаем	список	для	отображения	в	ListView	найденных	датчиков
                    ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();

                    Iterator<String> iter = responseJson.keys(); //This should be the iterator you want.
                    while(iter.hasNext()){
                        String key = iter.next();

                        HashMap<String, Object> typeList = new HashMap<>();
                        typeList.put("Name", key);
                        typeList.put("Value", responseJson.get(key));

                        arrayList.add(typeList);
                    }

                    SimpleAdapter mHistory	=
                            new	SimpleAdapter(MainActivity.this,	arrayList,	android.R.layout.simple_list_item_2,
                                    new	String[]{"Name", "Value"},
                                    new	int[]{android.R.id.text1,	android.R.id.text2});
                    listSensor.setAdapter(mHistory);


                    String latitude = responseJson.getString("loc").split(",")[0];
                    String longitude = responseJson.getString("loc").split(",")[1];

                    String path = String.format("https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true", latitude, longitude);
                    new DownloadPageTask().execute(path);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            super.onPostExecute(result);
        }

        private String downloadIpInfo(String address) throws IOException {
            InputStream inputStream = null;
            String data = "";
            try {
                URL url = new URL(address);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setReadTimeout(100000);
                connection.setConnectTimeout(100000);
                connection.setRequestMethod("GET");
                connection.setInstanceFollowRedirects(true);
                connection.setUseCaches(false);
                connection.setDoInput(true);
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) { // 200 OK
                    inputStream = connection.getInputStream();
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int read = 0;
                    while ((read = inputStream.read()) != -1) {
                        bos.write(read); }
                    bos.close();
                    data = bos.toString();
                } else {
                    data = connection.getResponseMessage()+". Error Code: " + responseCode;
                }
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return data;
        }
    }
}