package com.example.rutuja.image_circle;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Rutuja on 04-08-2015.
 */
public class Image_circle extends AppCompatActivity {

        ResourcesCompat resourcesCompat;
    ImageView mtop,mleft,mright,mbottom;

    Button clock,anticlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //image circle***********************
        this.clock= (Button)findViewById(R.id.clockwise);
        this.anticlock=(Button)findViewById(R.id.anticlockwise);

        this.mtop=(ImageView)findViewById(R.id.top);
        this.mleft=(ImageView)findViewById(R.id.left);
        this.mright=(ImageView)findViewById(R.id.right);
        this.mbottom=(ImageView)findViewById(R.id.bottom);

        Drawable drawTop = ResourcesCompat.getDrawable(getResources(), R.drawable.bird, null);
        Drawable drawLeft = ResourcesCompat.getDrawable(getResources(), R.drawable.cute, null);
        Drawable drawbottom = ResourcesCompat.getDrawable(getResources(), R.drawable.nature, null);
        Drawable drawableRight = ResourcesCompat.getDrawable(getResources(), R.drawable.images, null);

        mtop.setImageDrawable(drawTop);
        mleft.setImageDrawable(drawLeft);
        mright.setImageDrawable(drawableRight);
        mbottom.setImageDrawable(drawbottom);

        this.mtop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "u clicked top image", Toast.LENGTH_SHORT).show();
                Log.v("click", "top image");
            }
        });

        final Integer []images={R.drawable.sunflower,R.drawable.tiger,R.drawable.tree,R.drawable.xyz};
        final Integer []used={R.drawable.bird,R.drawable.images,R.drawable.nature,R.drawable.cute};

        Log.v("image0",Integer.toString(images[0]));
        Log.v("image1",Integer.toString(images[1]));
        Log.v("image2",Integer.toString(images[2]));
        Log.v("image3",Integer.toString(images[3]));

        this.clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int temp=used[3];

                used[3]=used[2];
                used[2]=used[1];
                used[1]=used[0];
                used[0]=images[0];

                mtop.setImageResource(used[0]);
                mleft.setImageResource(used[3]);
                mbottom.setImageResource(used[2]);
                mright.setImageResource(used[1]);


                for(int i=0;i<3;i++)
                {
                    images[i]=images[i+1];
                }

                images[3]=temp;
                Log.v("image0",Integer.toString(images[0]));
                Log.v("image1", Integer.toString(images[1]));
                Log.v("image2", Integer.toString(images[2]));
                Log.v("image3",Integer.toString(images[3]));

            }
        });

        this.anticlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp=used[1];

                used[1]=used[2];
                used[2]=used[3];
                used[3]=used[0];
                used[0]=images[3];

                mtop.setImageResource(used[0]);
                mleft.setImageResource(used[3]);
                mbottom.setImageResource(used[2]);
                mright.setImageResource(used[1]);


                for(int i=3;i>0;i--)
                {
                    images[i]=images[i-1];
                }

                images[0]=temp;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();

        if(id==R.id.alarm_icon)
        {
           Toast.makeText(this,"qwerty",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
