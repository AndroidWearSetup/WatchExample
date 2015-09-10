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

public class AnswerListAdapter extends BaseAdapter {

    private final List<Answer> answerList = new ArrayList<Answer>();
    private final Context context;

    AnswerListAdapter(Context context) {
        this.context = context;
    }

    public void add(Answer answer) {
        answerList.add(answer);
        notifyDataSetChanged();
    }

    public void clear() {
        answerList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return answerList.size();
    }

    @Override
    public Answer getItem(int position) {
        return answerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Answer answer = getItem(position);

        LinearLayout answerListLayout = (LinearLayout) LayoutInflater.from(context).inflate(
                R.layout.answer_field, parent, false);

        AnswerItemAdapter answerItemAdapter = new AnswerItemAdapter(answer, answerListLayout);

        answerItemAdapter.setAnswerView();



        return answerListLayout;
    }

    public Boolean checkAnswersCorrectness() {
        for (Answer answer : answerList) {
            if (answer.isChoosen() != answer.isCorrect()) {
                return false;
            }
        }
        return true;
    }

    public void colourAnswersField() {
        for (Answer answer : answerList) {
            if (answer.isCorrect()) {
                //TODO: Paint it green
            }
            if (answer.isChoosen() && !answer.isCorrect()) {
                //TODO: Paint it red
            }
        }
        notifyDataSetChanged();
    }
}
