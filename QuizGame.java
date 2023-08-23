import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Question[] questions = {
            new Question("What is the capital of France?", new String[]{"London", "Berlin", "Paris", "Madrid"}, 2),
            new Question("Which planet is known as the 'Red Planet'?", new String[]{"Mars", "Venus", "Jupiter", "Saturn"}, 0),
            new Question("What is the largest mammal?", new String[]{"Elephant", "Blue Whale", "Giraffe", "Hippopotamus"}, 1)
        };

        int score = 0;

        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Answer the following questions:\n");

        for (int i = 0; i < questions.length; i++) {
            Question q = questions[i];

            System.out.println("Question " + (i + 1) + ": " + q.question);
            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.print("Enter your choice (1-" + q.options.length + "): ");
            int userChoice = scanner.nextInt();

            if (userChoice == q.correctOption + 1) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + q.options[q.correctOption] + "\n");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.length);

        scanner.close();
    }
}

