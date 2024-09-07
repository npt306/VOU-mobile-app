package com.example.vou.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.vou.Model.QuizGameComment;
import com.example.vou.R;


import java.util.List;


public class QuizGameCommentAdapter extends RecyclerView.Adapter<QuizGameCommentAdapter.QuizGameCommentViewHolder> {
    private List<QuizGameComment> commentList;

    public QuizGameCommentAdapter(List<QuizGameComment> commentList) {
        this.commentList = commentList;
    }

    @NonNull
    @Override
    public QuizGameCommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_game_comment_item, parent, false);
        return new QuizGameCommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizGameCommentViewHolder holder, int position) {
        QuizGameComment comment = commentList.get(position);
        holder.commentUser.setText(comment.getUser_name());
        holder.commentContent.setText(comment.getUser_comment());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    class QuizGameCommentViewHolder extends RecyclerView.ViewHolder {
        TextView commentUser, commentContent;

        QuizGameCommentViewHolder(View itemView) {
            super(itemView);
            commentContent = itemView.findViewById(R.id.item_quiz_game_comment_user_comment);
            commentUser = itemView.findViewById(R.id.item_quiz_game_comment_user_name);
        }
    }
}
