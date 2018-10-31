package ivanjanjikj.basketscore.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ivanjanjikj.basketscore.data.Contract.BasketScoreDbInnerClass;

public class StreetBasketScoreDbHelper extends SQLiteOpenHelper {

    // If you change the database schema(contract), you MUST increment the DATABASE_VERSION;
    public final static int DATABASE_VERSION = 1;
    public final static String DATABASE_NAME = "StreetBasketScoreDb.db";

    public StreetBasketScoreDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + BasketScoreDbInnerClass.TABLE_NAME + " ("
                + BasketScoreDbInnerClass._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + BasketScoreDbInnerClass.COLUMN_TEAM_A_NAMES + " TEXT, "
                + BasketScoreDbInnerClass.COLUMN_TEAM_B_NAME + " TEXT, "
                + BasketScoreDbInnerClass.COLUMN_TEAM_A_SCORE + " INTEGER, "
                + BasketScoreDbInnerClass.COLUMN_TEAM_B_SCORE + " INTEGER, "
                + BasketScoreDbInnerClass.COLUMN_PLAYED_TIME + " INTEGER, "
                + BasketScoreDbInnerClass.COLUMN_PLAYED_DATE + " INTEGER);";
        // Execute the sql statement form above and create table
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
