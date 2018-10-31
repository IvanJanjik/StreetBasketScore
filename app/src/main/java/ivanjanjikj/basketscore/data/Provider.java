package ivanjanjikj.basketscore.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import ivanjanjikj.basketscore.data.Contract.BasketScoreDbInnerClass;

public class Provider extends ContentProvider {

    // Tag for log message
    public static final String LOG_TAG = Provider.class.getSimpleName();

    // URI matcher code for the content URI for the results table
    private static final int GAMES = 100;

    // URI matcher code for single game in results table
    private static final int GAME_ID = 101;

    // UriMatcher object to match a content URI to a corresponding code.
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // Static initializer. This is run the first time anything is called from this class.
    static {
        sUriMatcher.addURI(Contract.CONTENT_AUTHORITY, Contract.PATH_BASKETSCORE, GAMES);
        sUriMatcher.addURI(Contract.CONTENT_AUTHORITY, Contract.PATH_BASKETSCORE + "/#", GAME_ID);
    }

    // db variable
    private StreetBasketScoreDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new StreetBasketScoreDbHelper(getContext());
        return true;
    }


    @Override
    public Cursor query(Uri uri,String[] projection, String selection,String[] selectionArgs, String sortOrder) {

        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        Cursor cursor;

        int match = sUriMatcher.match(uri);
        switch (match){
            case GAMES:
                cursor = database.query(Contract.BasketScoreDbInnerClass.TABLE_NAME,
                        projection,selection,selectionArgs,null,null, sortOrder);
                break;
            case GAME_ID:
                selection = Contract.BasketScoreDbInnerClass._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(Contract.BasketScoreDbInnerClass.TABLE_NAME,
                        projection, selection, selectionArgs, null, null, sortOrder);
                break;
                default:
                    throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }

        return cursor;
    }


    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case GAMES:
                return BasketScoreDbInnerClass.CONTENT_LIST_TYPE;
            case GAME_ID:
                return BasketScoreDbInnerClass.CONTENT_ITEM_TYPE;
                default:
                    throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }


    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        final int match = sUriMatcher.match(uri);
        switch (match){
            case GAMES:
                return insertGame(uri, contentValues);
                default:
                    throw new IllegalArgumentException("Game save not supported for " + uri);
        }
    }

    private Uri insertGame(Uri uri, ContentValues values){
        // NO SANITY CHECKS

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        // insert new game with the given values
        long id = database.insert(BasketScoreDbInnerClass.TABLE_NAME, null, values);
        // If the ID is -1, then the insertion failed. Log an error and return null.
        if (id == -1) {
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }

        // return the new URI with the ID appended to the end of it
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(Uri uri,String selection, String[] selectionArgs) {

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        final int match = sUriMatcher.match(uri);
        switch (match){
            case GAMES:
                // Delete all rows that match the selection and selectionArgs
                return database.delete(BasketScoreDbInnerClass.TABLE_NAME,selection,selectionArgs);
            case GAME_ID:
                selection = BasketScoreDbInnerClass._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return database.delete(BasketScoreDbInnerClass.TABLE_NAME,selection,selectionArgs);
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }

    }

    @Override
    public int update(Uri uri,ContentValues values,String selection,String[] selectionArgs) {
        return 0;
    }
}
