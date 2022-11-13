package com.example.mindsparkdemo.App.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mindsparkdemo.App.MyRoom.ScoreTable;
import com.example.mindsparkdemo.R;
import com.example.mindsparkdemo.View.DashboardScreen.Dashboard;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ScoreDataAdapter extends RecyclerView.Adapter<ScoreDataAdapter.ViewHolder> {

    Context context;
    ArrayList<ScoreTable> arr;
    public ScoreDataAdapter(Dashboard dashboard, ArrayList<ScoreTable> arr){
        this.context = dashboard;
        this.arr = arr;
    }


    @NonNull
    @Override
    public ScoreDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.useritem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreDataAdapter.ViewHolder holder, int position) {
        ScoreTable scoreTable = arr.get(position);
        holder.stuId.setText("Student Id : "+scoreTable.getUsername());
        holder.testAttempted.setText("Test Attempted : Yes");
        holder.score.setText("Score : " + scoreTable.getCorrect());
        holder.correctQuestion.setText("Correct Question : " + scoreTable.getCorrect());
        holder.incorrectQuestion.setText("InCorrect Question : " + scoreTable.getIncorrect());
        holder.timeTaken.setText("Time Taken : " + scoreTable.getTimeTaken());
        holder.totalQuestion.setText("Total Question : 10");
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView stuId;
        TextView testAttempted;
        TextView score;
        TextView correctQuestion;
        TextView incorrectQuestion;
        TextView timeTaken;
        TextView totalQuestion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stuId = itemView.findViewById(R.id.stuId);
            testAttempted = itemView.findViewById(R.id.testAttempted);
            score = itemView.findViewById(R.id.Iscore);
            correctQuestion = itemView.findViewById(R.id.correctQuestion);
            incorrectQuestion = itemView.findViewById(R.id.incorrectQuestion);
            timeTaken = itemView.findViewById(R.id.ItimeTaken);
            totalQuestion = itemView.findViewById(R.id.totalQuestion);
        }
    }
}
