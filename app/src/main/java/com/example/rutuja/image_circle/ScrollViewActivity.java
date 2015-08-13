package com.example.rutuja.image_circle;

import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;


public class ScrollViewActivity extends AppCompatActivity implements
                                                                     ScrollVeiwHorizontal.OnFragmentInteractionListener,
                                                                     CombineFragment.OnFragmentInteractionListener,
                                                                     ScrollVeiwVertical.OnHorizontalFragmentInteractionListener
{


    public static final String VERTICAL_SCROLL_TAG ="VERTICAL SCROLL TAG";
    public static final String HORIZONTAL_SCROLL_TAG ="HORIZONTAL SCROLL TAG";
    public static final String COMBINE_SCROLL_TAG="COMBINE SCROLL TAG";
    ArrayList<String> fragmentTagList;
    TextView mtitleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        mtitleText =(TextView)findViewById(R.id.textScrollVeiwTitle);
        fragmentTagList = new ArrayList<String>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scroll_view, menu);
        return true;
    }

    public void clearAllFragment()
    {
        Iterator<String> iterator= fragmentTagList.iterator();
        while(iterator.hasNext())
        {
            String tag= iterator.next();
            FragmentManager manger = getSupportFragmentManager();
            Fragment fragment= getSupportFragmentManager().findFragmentByTag(tag);
            FragmentTransaction transaction =manger.beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }
        fragmentTagList.clear();
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

        if( id == R.id.verticalscroll)
        {
            clearAllFragment();
            ScrollVeiwVertical fragment =ScrollVeiwVertical.newInstance("Sample String 1", "Sample String 2");

            FragmentManager manager= getSupportFragmentManager();
            FragmentTransaction transaction =manager.beginTransaction();

            transaction.add(R.id.scrollcontainer, fragment, VERTICAL_SCROLL_TAG);

            transaction.commit();
            fragmentTagList.add(VERTICAL_SCROLL_TAG);



            return true;
        }
        else if(id == R.id.horizontalscroll)
        {
            clearAllFragment();
            ScrollVeiwHorizontal fragment =ScrollVeiwHorizontal.newInstance("Sample String 1","Sample String 2");
             FragmentManager manager =getSupportFragmentManager();
            FragmentTransaction transaction =manager.beginTransaction();

            transaction.add(R.id.scrollcontainer, fragment, HORIZONTAL_SCROLL_TAG);

            transaction.commit();
            fragmentTagList.add(HORIZONTAL_SCROLL_TAG);
            return  true;
        }

        else if(id == R.id.combinedscroll)
        {
            clearAllFragment();
            CombineFragment fragmentCombine =CombineFragment.newInstance("Sample String 1","Sample String 2");
            FragmentManager manager =getSupportFragmentManager();
            FragmentTransaction transaction =manager.beginTransaction();
            transaction.add(R.id.scrollcontainer, fragmentCombine, COMBINE_SCROLL_TAG);
            fragmentTagList.add(COMBINE_SCROLL_TAG);


            transaction.commit();

            return true;


        }

        else if(id ==R.id.combinedscrollHV)
        {
            clearAllFragment();
            ScrollVeiwHorizontal fragmentHorizontal =ScrollVeiwHorizontal.newInstance("Sample String 1","Sample String 2");
            ScrollVeiwVertical fragmentVeretical =ScrollVeiwVertical.newInstance("Sample String 1", "Sample String 2");

            FragmentManager manager =getSupportFragmentManager();
            FragmentTransaction transaction =manager.beginTransaction();
            transaction.add(R.id.containerhorizontal, fragmentHorizontal, HORIZONTAL_SCROLL_TAG);
            transaction.add(R.id.containervertical, fragmentVeretical, VERTICAL_SCROLL_TAG);
            fragmentTagList.add(HORIZONTAL_SCROLL_TAG);
            fragmentTagList.add(VERTICAL_SCROLL_TAG);


            transaction.commit();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void activityTitleChanged(String newtitle) {
        mtitleText.setText(newtitle);
        mtitleText.setTextColor(Color.MAGENTA);



            clearAllFragment();
            ScrollVeiwHorizontal fragmentHorizontalnew =ScrollVeiwHorizontal.newInstance("Sample String 1","Sample String 2");

            FragmentManager manager =getSupportFragmentManager();
            FragmentTransaction transaction =manager.beginTransaction();
            transaction.add(R.id.scrollcontainer, fragmentHorizontalnew, HORIZONTAL_SCROLL_TAG);

            fragmentTagList.add(HORIZONTAL_SCROLL_TAG);
            transaction.commit();
            Log.v("activity", "ELSE");
            fragmentHorizontalnew.textChange("BIRD PICTURE");

    }


}
