package hackzurich.learnwithus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class AnswerListAdapter extends BaseAdapter {

    private final Context context;
    private final List<AnswerItemAdapter> answerAdapterList = new ArrayList<>();

    public AnswerListAdapter(Context context) {
        this.context = context;
    }

    public AnswerListAdapter(Context context, List<Answer> answers) {
        this.context = context;
        for (Answer answer : answers) {
            add(answer);
        }
    }

    public void add(Answer answer) {
        answerAdapterList.add(new AnswerItemAdapter(answer));
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return answerAdapterList.size();
    }

    @Override
    public AnswerItemAdapter getItem(int position) {
        return answerAdapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout answerListLayout = (LinearLayout) LayoutInflater.from(context).inflate(
                R.layout.answer_field, parent, false);

        AnswerItemAdapter answerItemAdapter = getItem(position);

        answerItemAdapter.setAnswerView(answerListLayout);

        return answerListLayout;
    }

    public Boolean wasCorrectAnswerMarked() {
        for (AnswerItemAdapter answerItemAdapter : answerAdapterList) {
            if (answerItemAdapter.isChoosen() != answerItemAdapter.isCorrect()) {
                return false;
            }
        }
        return true;
    }

    public void colourAnswersField() {
        for (AnswerItemAdapter answerItemAdapter : answerAdapterList) {
            answerItemAdapter.setSubmitted(true);
//            if (answerItemAdapter.isCorrect()) {
//                //TODO: Paint it green
//            }
//            if (answerItemAdapter.isChoosen() && !answerItemAdapter.isCorrect()) {
//                //TODO: Paint it red
//            }
        }
        notifyDataSetChanged();
    }
}
