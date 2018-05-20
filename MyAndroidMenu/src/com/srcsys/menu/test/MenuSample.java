package com.srcsys.menu.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuSample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);         
       
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menus, menu);
        return true;
    } 
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
       
        switch (item.getItemId())
        {
        case R.id.menu_about:
        	Intent i = new Intent(this, TestActivity.class);
        	startActivity(i);
           // Toast.makeText(MenuSample.this, "You Clicked About", 3000).show();
            return true;
        case R.id.menu_help:
            Toast.makeText(MenuSample.this, "You Clicked Help", 3000).show();
            return true;
        case R.id.menu_new:
            Toast.makeText(MenuSample.this, "You Clicked New", 3000).show();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}