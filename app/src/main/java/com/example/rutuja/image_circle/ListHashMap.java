package com.example.rutuja.image_circle;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ListHashMap extends ActionBarActivity {

    ArrayList<HashMap<String,ArrayList<HashMap<Integer,String>>>> mapArrayList;
    ArrayList<HashMap<Integer,String>> courseArrayList;
    HashMap<Integer,String> main_Course;
    HashMap<Integer,String> starter;
    HashMap<Integer,String> desserts;

    Spinner spinner;
    SpinnerAdapter spinerAdaptor;
    ArrayAdapter <ArrayList<HashMap<Integer,String>>> hashMapArrayAdapter;
    ListView hashMapListVeiw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hash_map);

        main_Course= new HashMap<Integer,String>();
        starter = new HashMap<Integer,String>();
        desserts = new HashMap<Integer,String>();

        mapArrayList = new ArrayList<HashMap<String, ArrayList<HashMap<Integer,String>>>>();
        courseArrayList =new ArrayList<HashMap<Integer, String>>();
        main_Course.put(1,"Roti");
        main_Course.put(2,"Paneer Akhabari");
        main_Course.put(3,"Dal Mkhani");
        main_Course.put(4,"raita");
        main_Course.put(5,"shahi paneer");
        main_Course.put(6,"kadhai paneer");
        main_Course.put(7,"meethi");
        main_Course.put(8,"gobi");
        main_Course.put(9,"palak paneer");
        main_Course.put(10,"Baigan");

        starter.put(1,"a");
        starter.put(2,"b");
        starter.put(3,"c");
        starter.put(4,"d");
        starter.put(5,"e");
        starter.put(6,"f");

        desserts.put(1,"kheer");
        desserts.put(2,"khulphi");
        desserts.put(3,"gulabjamun");
        desserts.put(4,"rasmalai");
        desserts.put(5,"fruitsalad");
        desserts.put(6,"ice cream");
        desserts.put(7,"Milkshake");
        desserts.put(8,"puran poli");
        desserts.put(9, "shrikhand");

        courseArrayList.add(starter);
        courseArrayList.add(main_Course);
        courseArrayList.add(desserts);

        courseArrayList.add(starter);
        courseArrayList.add(main_Course);
        courseArrayList.add(desserts);

        Log.v("coursearraylist", courseArrayList.toString());

        hashMapListVeiw = (ListView)findViewById(R.id.hashMapList);
        spinner = (Spinner)findViewById(R.id.hashMapSpinner);

        for(Map.Entry<Integer,String> map : desserts.entrySet())
        {
            Log.v("desserts key",map.getKey().toString());
            Log.v("desserts value",map.getValue());
        }


        for(Integer key:desserts.keySet())
        {
            Log.v("keyset",desserts.get(key));
        }

        for(String value:desserts.values())
        {
            Log.v("valueset",value);
        }
        /*int size= mapArrayList.size();
        for(  int i=0;i<size;i++)
        {
            HashMap<String,ArrayList<HashMap<Integer,String>>> temp =mapArrayList.get(i);
            Log.v("HashMap",temp.get())

           *//* for(Map.Entry<String,ArrayList> map :temp.entrySet())
            {

            }*//*
        }
*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_hash_map, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
