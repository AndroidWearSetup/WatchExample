package hackzurich.learnwithus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import hackzurich.learnwithus.model.Database;

public class DatabaseGroupAdapter extends BaseAdapter {

    private final Context context;
    private final List<Database> databaseGroup = new ArrayList<>();

    public DatabaseGroupAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return databaseGroup.size();
    }

    @Override
    public Object getItem(int position) {
        return databaseGroup.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
