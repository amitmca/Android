package mine.traff1.namespace;


import Traff1.src.mine.traff1.namespace.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Traff1Activity extends Activity {
    /** Called when the activity is first created. */
	private  Long mRowId;
	private  DatabaseRelatedDbAdapter mDbHelper;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button b=(Button)findViewById(R.id.button1);
        final AlertDialog ad=new AlertDialog.Builder(this).create();
        ad.setTitle("HI");
        ad.setMessage("BYE");
        mDbHelper = new DatabaseRelatedDbAdapter(this);
		mDbHelper.open();
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ad.show();
				
			}
		});
        
        Button InsertButton=(Button)findViewById(R.id.button2);
        InsertButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText ed1=(EditText)findViewById(R.id.editText1);
				EditText ed2=(EditText)findViewById(R.id.editText2);
				
			int eno=Integer.parseInt(ed1.getText().toString());
			String Ename=ed2.getText().toString();
			long i=mDbHelper.createTable(eno, Ename);
			
			ad.setMessage("i="+i);
			ad.show();
			
			
			}
		});
        
        Button ViewButton=(Button)findViewById(R.id.button3);
        ViewButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText ed1=(EditText)findViewById(R.id.editText1);
				EditText ed2=(EditText)findViewById(R.id.editText2);
				int eno=Integer.parseInt(ed1.getText().toString());
				String Ename=ed2.getText().toString();
			try
			{
			Cursor c=mDbHelper.fetchOneRow(eno);
			String s=c.getString(1);
			ad.setMessage(s);
			ad.show();
			ed2.setText(s);
			}catch(Exception ex)
			{
				ad.setMessage(ex.toString());
				ad.show();
			}
			}
		});
    }
   
}