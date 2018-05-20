package mine.traff1.namespace;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseRelatedDbAdapter
{


	// Database fields
	public static final String KEY_ROWID = "_id";
	public static final String KEY_ENO = "eno";
	public static final String KEY_ENAME = "ENAME";
	private static final String DB_TABLE = "Employee";
	private Context context;
	private SQLiteDatabase db;
	private DatabaseRelatedHelper dbHelper;

	public DatabaseRelatedDbAdapter(Context context) {
		this.context = context;
	}

	public DatabaseRelatedDbAdapter open() throws SQLException {
		dbHelper = new DatabaseRelatedHelper(context);
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	/**
	 * Create a new todo If the todo is successfully created return the new
	 * rowId for that note, otherwise return a -1 to indicate failure.
	 */
	public long createTable(int eno,String Ename) {
		ContentValues values = createContentValues(eno,Ename);

		return db.insert(DB_TABLE, null, values);
	}

	/**
	 * Update the todo
	 */
	public boolean updateTable(long rowId, int Eno,String Ename) {
		ContentValues values = createContentValues(Eno,Ename);

		return db.update(DB_TABLE, values, KEY_ROWID + "=" + rowId, null) > 0;
	}

	/**
	 * Deletes todo
	 */
	public boolean deleteTable(long rowId) {
		return db.delete(DB_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	/**
	 * Return a Cursor over the list of all todo in the database
	 * 
	 * @return Cursor over all notes
	 */
	public Cursor fetchAllRows() {
		return db.query(DB_TABLE, new String[] { KEY_ROWID, KEY_ENO,
				KEY_ENAME }, null, null, null, null, null);
	}

	/**
	 * Return a Cursor positioned at the defined todo
	 */
	public Cursor fetchOneRow(long rowId) throws SQLException {
		Cursor mCursor = db.query(true, DB_TABLE, new String[] {KEY_ENO, KEY_ENAME}, KEY_ENO + "="
				+ rowId, null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	private ContentValues createContentValues(int Eno, String Ename) {
		ContentValues values = new ContentValues();
		values.put(KEY_ENO, Eno);
		values.put(KEY_ENAME, Ename);
		
		return values;
	}

}



