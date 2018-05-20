package com.srcsys.menu.test;

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
 
public class TestActivity extends Activity 
	{
 
	final Context context = this;
	private Button button;
 
	public void onCreate(Bundle savedInstanceState) 
		{
 		super.onCreate(savedInstanceState);
		setContentView(R.layout.insert);
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
		String TableName = "friends";
		String Data="";
		
		 try {
			 myDB = this.openOrCreateDatabase("amit.db", MODE_PRIVATE, null);
			   EditText editId = (EditText)findViewById(R.id.id);
			   String id = editId.getText().toString();
			   
			   EditText editName = (EditText)findViewById(R.id.name);
			  
			   String name = editName.getText().toString();
			   
			   EditText editContact = (EditText)findViewById(R.id.contact);
			   
			   String contact = editContact.getText().toString();
			   		   
			   EditText editDOB = (EditText)findViewById(R.id.dob);
			   
			   String dob = editDOB.getText().toString();
			   String query="insert into friends values('"+id+"','"+name+"','"+contact+"','"+dob+"')";
			   
			   AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);
		 			// set title
			   alertDialogBuilder.setTitle("Data");
			   String str="Save Successful : ";
			   /*retrieve data from database */
			   Cursor c = myDB.rawQuery("SELECT * FROM " + TableName , null);
			   int Column2 = c.getColumnIndex("name");
			   int Column3 = c.getColumnIndex("contact");
			   int Column4 = c.getColumnIndex("dob");
			 
			   // Check if our result was valid.
			   c.moveToFirst();
			   if (c != null) {
			    // Loop through all Results
			    do {
			     String name1 = c.getString(Column2);
			     String contact1 = c.getString(Column3);
			     String dob1 = c.getString(Column4);
			     
			     Data =Data +name1+"    "+contact1+"     "+dob1+"\n";
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
			   
			   if(editId.getText().toString().length() <= 0 )
				   editId.setError("Id is Required !");
			   else if(editName.getText().toString().length() == 0 )
				   editName.setError("Name is Required !");
			   else if(editContact.getText().toString().length() == 0 )
				   editContact.setError("Contact is Required !");
			   else if(editDOB.getText().toString().length() == 0 )
				   editDOB.setError("DOB is Required !");
			   else	
			   	   {
				   myDB.execSQL(query);
				   alertDialog.show();
			   	   }
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