import java.util.*;
class Question 
{
    String question;
    String[] options;
    int correctAnswerIndex;

    public Question(String question, String[] options, int correctAnswerIndex) 
    {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

class QuizData
 {
    public static List<Question> getQuestions() 
    {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of India?", new String[]{"Jaipur", "Chennai", "Mumbai", "New Delhi"}, 3));
        questions.add(new Question("Which language is used for IOS development?", new String[]{"Swift", "Python", "Java", "C++"}, 0));
        questions.add(new Question("Which language is used for Android development?", new String[]{"C++", "Java", "Swift", "Python"}, 1));
        return questions;
    }
}

class QuizTimer
 {
    private Timer timer;
    private boolean timeUp;

    public QuizTimer(int timeLimit)
     {
        this.timeUp = false;
        timer = new Timer();
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
                timeUp = true;
                System.out.println("Time is over!");
            }
        }, timeLimit * 1000);
    }

    public boolean isTimeUp()
     {
        return timeUp;
    }

    public void stopTimer()
     {
        timer.cancel();
    }
}

class QuizSummary 
{
    private List<Boolean> results = new ArrayList<>();

    public void addResult(boolean isCorrect)
     {
        results.add(isCorrect);
    }

    public void displaySummary() 
    {
        int correctAnswers = 0;
        for (boolean result : results)
         {
            if (result) correctAnswers++;
        }
        System.out.println("You answered " + correctAnswers + " out of " + results.size() + " questions correctly.");
        for (int i = 0; i < results.size(); i++) 
        {
            System.out.println("Question " + (i + 1) + ": " + (results.get(i) ? "Correct" : "Incorrect"));
        }
    }
}

public class QuizApplication
 {
    public static void main(String[] args) 
    {
        List<Question> questions = QuizData.getQuestions();
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        QuizSummary summary = new QuizSummary();

        for (Question question : questions)
         {
            System.out.println(question.question);
            for (int i = 0; i < question.options.length; i++) 
            {
                System.out.println((i + 1) + ". " + question.options[i]);
            }

            QuizTimer quizTimer = new QuizTimer(3);
            int userAnswer = -1;
            while (!quizTimer.isTimeUp()) 
            {
                if (scanner.hasNextInt()) 
                {
                    userAnswer = scanner.nextInt();
                    break;
                }
            }
            quizTimer.stopTimer();

            if (userAnswer == -1) 
            {
                System.out.println("You didn't answer in time!");
                summary.addResult(false);
            } else if (userAnswer - 1 == question.correctAnswerIndex)
             {
                System.out.println("Correct!");
                summary.addResult(true);
                score++;
            } else 
            {
                System.out.println("Wrong answer!");
                summary.addResult(false);
            }
        }

        System.out.println("Quiz is completed! this is your score: " + score + "/" + questions.size());
        summary.displaySummary();
    }
}
