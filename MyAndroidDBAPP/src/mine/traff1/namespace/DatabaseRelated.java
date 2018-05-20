package mine.traff1.namespace;
import android.database.sqlite.*;
import android.util.Log;

public class DatabaseRelated 
{
	public static final String CreateDatabaseQry=
			"create table Employee(eno int,ename text)";
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(CreateDatabaseQry);
	}
	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(DatabaseRelated.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");
		database.execSQL("DROP TABLE IF EXISTS Employee");
		onCreate(database);
	}

}
