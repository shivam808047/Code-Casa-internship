public class QuizActivity extends AppCompatActivity {

    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questions = new ArrayList<>();
        // Initialize questions and add them to the list

        showQuestion();
    }

    private void showQuestion() {
        Question question = questions.get(currentQuestionIndex);

        // Update UI to display the question and options
        TextView questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(question.getQuestionText());

        // Add click listeners to option buttons
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            Button optionButton = findViewById(getResources().getIdentifier("optionButton" + (i + 1), "id", getPackageName()));
            optionButton.setText(options.get(i));
            optionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswer(i);
                }
            });
        }
    }

    private void checkAnswer(int selectedOptionIndex) {
        Question question = questions.get(currentQuestionIndex);
        if (selectedOptionIndex == question.getCorrectOptionIndex()) {
            score++;
        }

        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            showQuestion();
        } else {
            // Transition to ResultActivity with the score
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }
}
