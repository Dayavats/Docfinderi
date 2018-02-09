package com.example.lenovo.docfinder;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayListView extends Activity {
    String JSON_String;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactAdapter contactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);
        listView = (ListView) findViewById(R.id.Listview);
        contactAdapter = new ContactAdapter(this, R.layout.row_layout);
        listView.setAdapter(contactAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String phoneno = String.valueOf(parent.getItemAtPosition(position));
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(phoneno));
                if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(DisplayListView.this, Manifest.permission.CALL_PHONE)) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });

        JSON_String=getIntent().getExtras().getString("json_data");
        try {
            //jsonObject=new JSONObject(JSON_String);
            jsonArray = new JSONArray(JSON_String);
            //jsonArray=jsonObject.getJSONArray("server_responds");
            int count=0;
            String name,phoneno;
            while (count<jsonArray.length()){
                JSONObject jo=jsonArray.getJSONObject(count);
                name=jo.getString("name");
                Log.i("TEST ", name);
                phoneno=jo.getString("phone_No");

                Log.i("TEST NAME", name);
                //Log.i("TEST NAME", email);
                Log.i("TEST NAME", phoneno);

                Contacts contacts=new Contacts(name,phoneno);
                contactAdapter.add(contacts);
                count++;



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
