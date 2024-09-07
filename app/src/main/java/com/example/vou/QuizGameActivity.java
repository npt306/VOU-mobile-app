package com.example.vou;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vou.Adapter.QuizGameCommentAdapter;
import com.example.vou.Model.Event;
import com.example.vou.Model.Question;
import com.example.vou.Model.QuizGameComment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizGameActivity extends AppCompatActivity {
    private RecyclerView commentRecyclerView;
    private QuizGameCommentAdapter quizGameCommentAdapter;
    private List<QuizGameComment> quizGameCommentList;
    Context context;
    ImageView backButton, eventDetail;
    TextView question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_quiz);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quiz_game_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Event event = (Event) getIntent().getSerializableExtra("event_data");
        context = this;

        commentRecyclerView = findViewById(R.id.quiz_game_recycler_view_comment);
        backButton = findViewById(R.id.quiz_game_back_button);
        eventDetail = findViewById(R.id.quiz_game_event_information);
        question = findViewById(R.id.quiz_game_question);

        question.setOnClickListener(v -> showQuestionDialog(new Question("Câu hỏi 1?", Arrays.asList("Đáp án A", "Đáp án B", "Đáp án C"))));

        commentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        quizGameCommentList = new ArrayList<>();
        quizGameCommentAdapter = new QuizGameCommentAdapter(quizGameCommentList);
        commentRecyclerView.setAdapter(quizGameCommentAdapter);

        simulateComments();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        eventDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailActivity.class);
                intent.putExtra("event_detail", event);
                context.startActivity(intent);
            }
        });
    }

    private void simulateComments() {
        quizGameCommentList.add(new QuizGameComment("User1", "Đây là bình luận đầu tiên!"));
        quizGameCommentList.add(new QuizGameComment("User2", "Xin chào mọi người!"));
        quizGameCommentAdapter.notifyDataSetChanged();
    }

    private void showQuestionDialog(Question question) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.quiz_game_question_dialog, null);
        builder.setView(dialogView);

        TextView tvQuestion = dialogView.findViewById(R.id.dialog_quiz_game_question);
        RadioGroup rgAnswers = dialogView.findViewById(R.id.dialog_quiz_game_answers);

        tvQuestion.setText(question.getQuestionText());

        for (String answer : question.getAnswers()) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(answer);
            rgAnswers.addView(radioButton);
        }

        // Thêm nút xác nhận
        builder.setPositiveButton("Xác nhận", (dialog, which) -> {
            int selectedId = rgAnswers.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selectedRadioButton = dialogView.findViewById(selectedId);
                String selectedAnswer = selectedRadioButton.getText().toString();
                // Xử lý câu trả lời của người dùng tại đây
                Toast.makeText(context, "Bạn đã chọn: " + selectedAnswer, Toast.LENGTH_SHORT).show();
            }
        });

        // Hiển thị Dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
