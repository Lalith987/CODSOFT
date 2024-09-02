import java.util.Scanner;
public class GradeCalculator 
{
    public static void main(String[] args) 
     {
        Scanner scanner = new Scanner(System.in);
        int physics, mathematics, chemistry, biology, computerScience;
        int totalMarks;
        double percentage;
        String grade;

        // Input marks for each subject
        System.out.print("Enter the Physics marks: ");
        physics = scanner.nextInt();

        System.out.print("Enter the Mathematics marks: ");
        mathematics = scanner.nextInt();

        System.out.print("Enter the Chemistry marks: ");
        chemistry = scanner.nextInt();

        System.out.print("Enter the Biology marks: ");
        biology = scanner.nextInt();

        System.out.print("Enter the Computer Science marks: ");
        computerScience = scanner.nextInt();

        // Calculate total marks and percentage
        totalMarks = physics + mathematics + chemistry + biology + computerScience;
        percentage = (double) totalMarks / 5;

        // Determine the grade based on the percentage
        if (percentage >= 90) 
        {
            grade = "A+";
        } else if (percentage >= 80) 
        {
            grade = "A";
        } else if (percentage >= 70)
         {
            grade = "B";
        } else if (percentage >= 60) 
        {
            grade = "C";
        } else if (percentage >= 50)
         {
            grade = "D";
        } else
         {
            grade = "Failed";
        }

        // Display the grade report
        System.out.println("\n--- Student Grade Report ---");
        System.out.println("Physics:"+ physics +"/100");
        System.out.println("Mathematics:"+ mathematics +"/100");
        System.out.println("Chemistry:"+ chemistry +"/100");
        System.out.println("Biology:"+ biology +"/100");
        System.out.println("Computer Science:"+ computerScience +"/100");
        System.out.println("Total Marks:"+ totalMarks +"out of 500");
        System.out.println("Percentage:"+ percentage +"%");
        System.out.println("Grade:"+ grade);

        scanner.close();
    }
}

