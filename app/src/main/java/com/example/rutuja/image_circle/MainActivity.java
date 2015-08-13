package com.example.rutuja.image_circle;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class MainActivity extends ActionBarActivity {



    ListView listView;
    ListView drawerListVeiw;

    ArrayList<String> drawerArray;
    ArrayList<String> spinnerList;
    ArrayList<String> arrayList;

    ArrayList<Boolean> arraylistboolean;

    ArrayList<String> menuArrayList;

    ArrayList<Integer> countArrayListStarter;
    ArrayList<Integer> countArrayListMainCourse;
    ArrayList<Integer> countArrayListDesserts;
    ArrayList<Integer> countArrayList;
    String selected_course;
    Integer starterBackgnd;
    Integer mainCourseBackgnd;
    Integer dessertsBackgnd;

    LayoutInflater layoutInflater;
    MyAdaptor myAdaptor;
    MenuAdaptor menuAdaptor;
    ArrayAdapter arrayAdapter;

    DrawerLayout drawerLayout;
    EditText editTextDrawer;

    Spinner spinnerMenu;
    SpinnerAdapter spinnerAdapter;

    Button orderButton;
    Button listHashmapbutton;
    Button scrollView;
    Intent intent,intentHM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listveiw);

       /* int[] array = getResources().getIntArray(R.array.int_array);
        Integer[] arr = new Integer[array.length];

        for(int i=0; i<array.length; i++){
            arr[i] = array[i];
        }

        ArrayList<Integer>  list = new ArrayList<Integer>(Arrays.asList(arr));*/

        //list view********
        layoutInflater=getLayoutInflater();
        String []array=getResources().getStringArray(R.array.location);

        //String []arraycopy=getResources().getStringArray(R.array.location_copy);

        listView =(ListView) findViewById(R.id.list_veiw);
        drawerListVeiw= (ListView)findViewById(R.id.drawer_list);

        List<String> list_array = Arrays.asList(array);
       // List<String> list_veiw_copy =Arrays.asList(arraycopy);

        arrayList =new ArrayList<String>(list_array);
        drawerArray =new ArrayList<String>(list_array);
        menuArrayList =new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.location)));
        final List<String> main_course =Arrays.asList(getResources().getStringArray(R.array.location));
        final List<String> starter =Arrays.asList(getResources().getStringArray(R.array.number));
        final List<String> desserts =Arrays.asList(getResources().getStringArray(R.array.alphanumeric));
        selected_course="Main Course";
        mainCourseBackgnd=-1;
        starterBackgnd=-1;
        dessertsBackgnd=-1;
       // menuArrayList =new ArrayList<String>(list_veiw_copy);
        arraylistboolean =new ArrayList<Boolean>();
         int size= arrayList.size();
         int menu= menuArrayList.size();

            countArrayListDesserts =new ArrayList<Integer>();//(Arrays.asList(getResources().getIntArray(R.array.initialarray)));
            countArrayListMainCourse =new ArrayList<Integer>();
        countArrayListStarter = new ArrayList<Integer>();
        countArrayList = new ArrayList<Integer>();

        int val=0;
        for(int j=0;j<menu;j++)
        {
            countArrayList.add(val);
            countArrayListDesserts.add(val);
            countArrayListMainCourse.add(val);
            countArrayListStarter.add(val);
        }
        //String[] str = drawerArray.toArray();
        for(int i=0;i<size;i++)
        {
            arraylistboolean.add(i,false);
        }
       // Log.v("arrayboolean", arraylistboolean.toString());
        //Log.v("arrayboolean SIZE",Integer.toString(arraylistboolean.size()));


        //used fr array adaptor
   //  ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drawerArray);
//        Log.v("OUTPUT", arrayList.toString());

        //use of myadapter created by extendng baseadaptor
        myAdaptor =new MyAdaptor();
        drawerListVeiw.setAdapter(myAdaptor);


        menuAdaptor= new MenuAdaptor();
        listView.setAdapter(menuAdaptor);


       // listView.setAdapter(myAdaptor);
       // Log.v("OUTPUT", arrayList.toString());
       // Log.v("OUTPUT SIZE", Integer.toString(arrayList.size()));

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.v("ITEM ","ITEM CLICKED");
                Boolean status =arraylistboolean.get(position);

                if(selected_course.equals("Main Course")){
                    mainCourseBackgnd=position;
                    Log.v("Maincback",mainCourseBackgnd.toString());


                }
                else if (selected_course.equals("Starter")) {
                   starterBackgnd=position;
                    Log.v("startreback",starterBackgnd.toString());
                }
                else if(selected_course.equals("Desserts")){
                    dessertsBackgnd=position;
                    Log.v("dessertsback",dessertsBackgnd.toString());
                }

               *//*arrayList.add(arrayList.get(position)+"NEW");
                arraylistboolean.add(false);
                arrayList.remove(position);
                arraylistboolean.remove(position);
*//*
              menuAdaptor.notifyDataSetChanged();

            }
        });
*/
///*    mListview.setOnItemClickListener();
// this.mArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,mList);
//     mListView.setAdapter(mArrayAdapter);*/


        drawerLayout =(DrawerLayout)findViewById(R.id.drawer_layout);
        editTextDrawer = (EditText)findViewById(R.id.drawer_edit_text);
        editTextDrawer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String temp= editTextDrawer.getText().toString();
                String variable;
                Log.v("EditText", temp);
                Iterator itr =arrayList.iterator();
                drawerArray.clear();
                while(itr.hasNext())
                {   variable=itr.next().toString();
                    if(variable.toLowerCase().contains(temp.toLowerCase()))
                    {
                        drawerArray.add(variable);
                      //  Log.v("CHANGED",variable);
                    }
                }

              //  Log.v("DRAWERARRAY",drawerArray.toString());

                myAdaptor.notifyDataSetChanged();


            }
        });

        spinnerList = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.array_menu)));
        spinnerMenu = (Spinner)findViewById(R.id.spinner);
        spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,spinnerList);
        spinnerMenu.setAdapter(spinnerAdapter);

        spinnerMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_course = spinnerList.get(position);
                if (selected_course.equals("Main Course")) {
                    // Log.v("spiner", selected_course);
                    countArrayList.clear();
                    countArrayList.addAll(countArrayListMainCourse);
                    menuArrayList.clear();
                    menuArrayList.addAll(main_course);

                } else if (selected_course.equals("Starter")) {
                    // Log.v("spiner", selected_course);
                    countArrayList.clear();
                    countArrayList.addAll(countArrayListStarter);
                    menuArrayList.clear();
                    menuArrayList.addAll(starter);
                } else if (selected_course.equals("Desserts")) {
                    //  Log.v("spiner", selected_course);
                    countArrayList.clear();
                    countArrayList.addAll(countArrayListDesserts);
                    menuArrayList.clear();
                    menuArrayList.addAll(desserts);
                }

                menuAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.v("spiner", "nothing selected");
            }
        });

        orderButton =(Button)findViewById(R.id.order);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(),Image_circle.class);

                intent.putExtra("total",200);
                startActivity(intent);
            }
        });
/*

        listHashmapbutton =(Button)findViewById(R.id.list_hashmap_button);
        listHashmapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentHM = new Intent(getApplicationContext(),ListHashMap.class);
                startActivity(intentHM);
            }
        });
*/

        scrollView =(Button)findViewById(R.id.scrollView);
        scrollView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(getApplicationContext(),ScrollViewActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Log.v("on option selected","SELECTED");
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.v("on setting selecte","SELECTED");
            return true;
        }

        else if(id == R.id.alarm)
        {
            Log.v("ICONqwerty","SELECTED");
            Toast.makeText(getApplicationContext(),"alarm ringing",Toast.LENGTH_SHORT).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class MyAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return drawerArray.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           // Log.v("position getveiw", Integer.toString(position));
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.drawer_list_element, parent, false);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.draw_text);
            textView.setText(drawerArray.get(position));


            /*TextView textViewCopy = (TextView)convertView.findViewById(R.id.list_text_veiw2);
            textViewCopy.setText(menuArrayList.get(position));
*/
           /* Boolean status =arraylistboolean.get(position) ;
            if(status)
            {
                convertView.setBackgroundColor(Color.CYAN);
            }

            else{
                convertView.setBackgroundColor(Color.TRANSPARENT);
            }*/

            return convertView;
        }
    }


        public class MenuAdaptor extends BaseAdapter{

            @Override
            public int getCount() {
                return menuArrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {

                if(convertView == null)
                {
                    convertView=layoutInflater.inflate(R.layout.list_element,parent,false);
                }

                TextView textView = (TextView)convertView.findViewById(R.id.list_text_veiw);
                textView.setText(menuArrayList.get(position));

                TextView textViewCount= (TextView)convertView.findViewById(R.id.list_text_veiw_count);
                textViewCount.setText(Integer.toString(countArrayList.get(position)));


                if(selected_course.equals("Main Course")){

                    if(position== mainCourseBackgnd)
                    {
                        convertView.setBackgroundColor(Color.CYAN);
                       /* textView.setBackgroundColor(Color.RED);
                        textViewCount.setBackgroundColor(Color.RED);*/
                    }
                    else
                    {
                        convertView.setBackgroundColor(Color.TRANSPARENT);
                        /*textView.setBackgroundColor(Color.TRANSPARENT);
                        textViewCount.setBackgroundColor(Color.TRANSPARENT);*/
                    }


                }
                else if (selected_course.equals("Starter")) {
                    if(position== starterBackgnd)
                    {
                        convertView.setBackgroundColor(Color.CYAN);
                        /*textView.setBackgroundColor(Color.RED);
                        textViewCount.setBackgroundColor(Color.RED);*/
                    }
                    else
                    {
                        convertView.setBackgroundColor(Color.TRANSPARENT);
/*                        textView.setBackgroundColor(Color.TRANSPARENT);
                        textViewCount.setBackgroundColor(Color.TRANSPARENT);*/
                    }

                }
                else if(selected_course.equals("Desserts")){
                    if(position== dessertsBackgnd)
                    {
                        convertView.setBackgroundColor(Color.CYAN);
                       /* textView.setBackgroundColor(Color.RED);
                        textViewCount.setBackgroundColor(Color.RED);*/
                    }
                    else
                    {
                        convertView.setBackgroundColor(Color.TRANSPARENT);
                        /*textView.setBackgroundColor(Color.TRANSPARENT);
                        textViewCount.setBackgroundColor(Color.TRANSPARENT);*/
                    }

                }



                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer[] countarray = new Integer[countArrayList.size()];
                        countarray = countArrayList.toArray(countarray);

                        countarray[position] += 1;
                        List<Integer> temp = Arrays.asList(countarray);
                        countArrayList.clear();
                        countArrayList.addAll(temp);
                        if (selected_course.equals("Main Course")) {
                            Log.v("spiner", selected_course);
                            countArrayListMainCourse.clear();
                            countArrayListMainCourse.addAll(temp);
                            mainCourseBackgnd = position;
                            Log.v("Maincback", mainCourseBackgnd.toString());


                        } else if (selected_course.equals("Starter")) {
                            countArrayListStarter.clear();
                            countArrayListStarter.addAll(temp);
                            starterBackgnd = position;
                            Log.v("starterback", starterBackgnd.toString());

                        } else if (selected_course.equals("Desserts")) {
                            countArrayListDesserts.clear();
                            countArrayListDesserts.addAll(temp);
                            dessertsBackgnd = position;
                            Log.v("Dessertsback", dessertsBackgnd.toString());

                        }

                       /* for (int i = 0; i < 10; i++) {
                            Log.v("countarray", Integer.toString(countarray[i]));
                        }
*/
                        temp = null;
                        menuAdaptor.notifyDataSetChanged();
                    }
                });
                convertView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Integer[] countarray = new Integer[countArrayList.size()];
                        countarray = countArrayList.toArray(countarray);
                        if (countarray[position] >= 1) {
                            countarray[position] -= 1;
                        }
                        List<Integer> temp= Arrays.asList(countarray);
                        countArrayList.clear();
                        countArrayList.addAll(temp);
                        if(selected_course.equals("Main Course")){
                            //Log.v("spiner", selected_course);
                            countArrayListMainCourse.clear();
                            countArrayListMainCourse.addAll(temp);

                        }
                        else if (selected_course.equals("Starter")) {
                            countArrayListStarter.clear();
                            countArrayListStarter.addAll(temp);
                        }
                        else if(selected_course.equals("Desserts")){
                            countArrayListDesserts.clear();
                            countArrayListDesserts.addAll(temp);
                        }

                        /*for (int i = 0; i < 10; i++) {
                            Log.v("countarray", Integer.toString(countarray[i]));
                        }*/

                        menuAdaptor.notifyDataSetChanged();
                        temp=null;
                        return true;
                    }
                });




                return convertView;
            }
        }

}
