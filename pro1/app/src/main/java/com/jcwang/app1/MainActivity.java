package com.jcwang.app1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String tempString = "com.jcwang.app1.tempString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:{

                Log.e("设置","1");

                return true;
            }

            case R.id.action_ser: {

                Log.e("搜索","2");
                sendAction(null);

                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }


    public void sendAction(View view) {

        Intent jump = new Intent(this,SecondActivity.class);
        EditText mainET = findViewById(R.id.eidt_text);
        //获取字符串
        String string = mainET.getText().toString();
        if (string.isEmpty()) {
            string = "空的";
        }
        jump.putExtra(tempString,string);
        Log.e("tag",string);
        startActivity(jump);
    }

    //隐藏或者显示
    public  void actionBar (View view) {

        CheckBox box = (CheckBox)view;
        ActionBar bar = getSupportActionBar();

        if (box.isChecked()) {

            Log.v("","选择了");
            bar.hide();

        }
        else  {
            Log.v("","没选");
            bar.show();
        }
    }

}


