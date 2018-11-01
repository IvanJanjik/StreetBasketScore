package ivanjanjikj.basketscore.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;



public final class  Contract implements BaseColumns {

    // empty constructor
    private Contract (){}


    // URI constants
    public static final String CONTENT_AUTHORITY = "ivanjanjikj.basketscore";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_BASKETSCORE = "basketscore";

     //Inner class that defines constant values for the Street Basket Score database table.

    public static final class BasketScoreDbInnerClass {


        // name of the database table
        public final static String TABLE_NAME = "results";

        // unique ID number for each match
        // type INTEGER
        public final static String _ID = BaseColumns._ID;

        // teams name
        // type TEXT
        public final static String COLUMN_TEAM_A_NAME = "teamA";
        public final static String COLUMN_TEAM_B_NAME = "teamB";


        // teams score (final result)
        // type INTEGER
        public final static String COLUMN_TEAM_A_SCORE = "scoreA";
        public final static String COLUMN_TEAM_B_SCORE = "scoreB";

        // time played
        // type INTEGER
        public final static String COLUMN_PLAYED_TIME = "time";

        // date played
        // type INTEGER
        public final static String COLUMN_PLAYED_DATE = "date";


        // final uri constant
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BASKETSCORE);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of games.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BASKETSCORE;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single game.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BASKETSCORE;




    }
}
