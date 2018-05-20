package mine.traff1.namespace;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseRelatedHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "applicationdata";

	private static final int DATABASE_VERSION = 1;

	public DatabaseRelatedHelper(Context context) {
	super(context, DATABASE_NAME, null, DATABASE_VERSION);
	//	super();
	}

	// Method is called during creation of the database
	public void onCreate(SQLiteDatabase database) {
		DatabaseRelated.onCreate(database);
	}

	// Method is called during an upgrade of the database,
	// e.g. if you increase the database version
	public void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) 
	{
		DatabaseRelated.onUpgrade(database, oldVersion, newVersion);
	}
}




