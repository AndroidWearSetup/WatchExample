package hackzurich.learnwithus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import hackzurich.learnwithus.model.Answer;

public class AnswerGroupAdapter extends BaseAdapter {

    private final Context context;
    private final List<AnswerItemAdapter> answerItemAdapterGroup = new ArrayList<>();

    public AnswerGroupAdapter(Context context) {
        this.context = context;
    }

    public AnswerGroupAdapter(Context context, List<Answer> answers) {
        this.context = context;
        for (Answer answer : answers) {
            add(answer);
        }
    }

    public void add(Answer answer) {
        answerItemAdapterGroup.add(new AnswerItemAdapter(answer));
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return answerItemAdapterGroup.size();
    }

    @Override
    public AnswerItemAdapter getItem(int position) {
        return answerItemAdapterGroup.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout answerGroupLayout = (LinearLayout) LayoutInflater.from(context).inflate(
                R.layout.answer_field, parent, false);

        AnswerItemAdapter answerItemAdapter = getItem(position);

        answerItemAdapter.setAnswerView(answerGroupLayout);

        return answerGroupLayout;
    }

    public Boolean wasCorrectAnswerMarked() {
        for (AnswerItemAdapter answerItemAdapter : answerItemAdapterGroup) {
            if (answerItemAdapter.isChoosen() != answerItemAdapter.isCorrect()) {
                return false;
            }
        }
        return true;
    }

    public void colourAnswersField() {
        for (AnswerItemAdapter answerItemAdapter : answerItemAdapterGroup) {
            answerItemAdapter.setSubmitted(true);
        }
        notifyDataSetChanged();
    }
}
