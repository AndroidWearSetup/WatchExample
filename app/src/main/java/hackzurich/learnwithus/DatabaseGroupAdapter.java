package hackzurich.learnwithus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hackzurich.learnwithus.model.Database;

public class DatabaseGroupAdapter extends BaseAdapter {

    private final Context context;
    private final List<Database> databaseGroup = new ArrayList<>();

    public DatabaseGroupAdapter(Context context) {
        this.context = context;
    }

    public void addItem(Database database) {
        databaseGroup.add(database);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return databaseGroup.size();
    }

    @Override
    public Database getItem(int position) {
        return databaseGroup.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout databaseLayout = (LinearLayout) LayoutInflater.from(context).inflate(
                R.layout.database_field, parent, false);

        Database database = getItem(position);

        TextView databaseNameTextView = (TextView) databaseLayout.findViewById(R.id.databaseNameTextView);
        databaseNameTextView.setText(database.getName());

        return databaseLayout;
    }
}
