package com.srcsys.db.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
 
public class SimpleGUI extends Activity 
	{
 
	final Context context = this;
	private Button button;
 
	public void onCreate(Bundle savedInstanceState) 
		{
 		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
 		button = (Button) findViewById(R.id.mybtn);
		// add button listener
		addListenerOnButton();
		}
		
		public void addListenerOnButton() 
		{
		button.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View arg0) {
			
			Connect();
			
 			
			}
		});
	}
	public void Connect()
	{
		SQLiteDatabase myDB= null;
		String TableName = "employee";
		String Data="";
		
		 try {
			 myDB = this.openOrCreateDatabase("DatabaseName", MODE_PRIVATE, null);
			 /* Create a Table in the Database. */
			  // myDB.execSQL("CREATE TABLE IF NOT EXISTS "+ TableName+ " (Field1 varchar,Field2 VARCHAR);");
			   EditText editEno = (EditText)findViewById(R.id.eno);
			   String eno = editEno.getText().toString();
			   EditText editEname = (EditText)findViewById(R.id.ename);
			   String ename = editEname.getText().toString();
			   String query="insert into employee values('"+eno+"','"+ename+"')";
			   //String query="insert into employee values(10,'amit')";
			   myDB.execSQL(query);
			   AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);
		 			// set title
			   alertDialogBuilder.setTitle("Data");
			   String str="Save Successful : ";
			   /*retrieve data from database */
			   Cursor c = myDB.rawQuery("SELECT * FROM " + TableName , null);
			   int Column1 = c.getColumnIndex("Field1");
			   int Column2 = c.getColumnIndex("Field2");
			   // Check if our result was valid.
			   c.moveToFirst();
			   if (c != null) {
			    // Loop through all Results
			    do {
			     String eno1 = c.getString(Column1);
			     String ename1 = c.getString(Column2);
			     Data =Data +eno1+"/"+ename1+"\n";
			    }while(c.moveToNext());
			   }
				// set dialog message
	  		   alertDialogBuilder
						.setMessage(Data)
						.setCancelable(false)
						.setNegativeButton("Ok",new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog,int id) {
			      	dialog.cancel();
							}
				});
		 		// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
				// show it
				alertDialog.show();
			   
			   /*TextView tv = new TextView(this);
			   tv.setText(Data);
			   setContentView(tv);*/
			   
		 	 }  
		 catch(Exception e) {
			 Log.e("Error", "Error", e);
			 }
		 finally {
			if (myDB != null)
			 myDB.close();
			 }  
	}
}