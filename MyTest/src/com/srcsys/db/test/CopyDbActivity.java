package com.srcsys.db.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CopyDbActivity extends Activity {
    /** Called when the activity is first created. */
	Cursor c=null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ((Button)findViewById(R.id.button01)).setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				
		         
		         DatabaseHelper myDbHelper = new DatabaseHelper(CopyDbActivity.this);
		         try {
		  
		         	myDbHelper.createDataBase();
		  
		  	} catch (IOException ioe) {
		  
		  		throw new Error("Unable to create database");
		  
		  	}
		  
		  	try {
		  
		  		myDbHelper.openDataBase();
		  
		  	}catch(SQLException sqle){
		  
		  		throw sqle;
		  
		  	}
		  	Toast.makeText(CopyDbActivity.this, "Success", Toast.LENGTH_SHORT).show();
		  
		  	
		 	
		  	c=myDbHelper.query("EMP_TABLE", null, null, null, null,null, null);
		  	if(c.moveToFirst())
            {
                do {
             
                	Toast.makeText(CopyDbActivity.this,
                            "_id: " + c.getString(0) + "\n" +
                            "E_NAME: " + c.getString(1) + "\n" +
                            "E_AGE: " + c.getString(2) + "\n" +
                            "E_DEPT:  " + c.getString(3),
                            Toast.LENGTH_LONG).show();
                	
                } while (c.moveToNext());
            }
			}
		});
        
               
        
    }
}



