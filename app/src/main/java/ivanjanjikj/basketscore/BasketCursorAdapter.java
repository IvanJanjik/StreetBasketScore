package ivanjanjikj.basketscore;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import ivanjanjikj.basketscore.data.Contract.BasketScoreDbInnerClass;

public class BasketCursorAdapter extends CursorAdapter {


    public BasketCursorAdapter (Context context, Cursor c){
        super(context,c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.results_list,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        // Find individual views that we want to modify in the list item layout
        TextView nameAtextView = (TextView) view.findViewById(R.id.teamA_name);
        TextView resultAtextView = (TextView) view.findViewById(R.id.teamA_result);
        TextView nameBtextView = (TextView) view.findViewById(R.id.teamB_name);
        TextView resultBtextView = (TextView) view.findViewById(R.id.teamB_result);

        // find the columns that we're interested in
        int nameAColumnIndex = cursor.getColumnIndex(BasketScoreDbInnerClass.COLUMN_TEAM_A_NAME);
        int resultsAColumnIndex = cursor.getColumnIndex(BasketScoreDbInnerClass.COLUMN_TEAM_A_SCORE);
        int nameBColumnIndex = cursor.getColumnIndex(BasketScoreDbInnerClass.COLUMN_TEAM_B_NAME);
        int resultBColumnIndex = cursor.getColumnIndex(BasketScoreDbInnerClass.COLUMN_TEAM_B_SCORE);

        // read the attributes from the Cursor
        String teamAname = cursor.getString(nameAColumnIndex);
        String teamAresult = cursor.getString(resultsAColumnIndex);
        String teamBresult = cursor.getString(resultBColumnIndex);
        String teamBname = cursor.getString(nameBColumnIndex);

        // Update the TextViews with the attributes for the current pet
         nameAtextView.setText(teamAname);
         resultAtextView.setText(teamAresult);
         nameBtextView.setText(teamBname);
         resultBtextView.setText(teamBresult);

    }
}
