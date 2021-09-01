package retriever;

import java.util.ArrayList;
import java.util.Scanner;

import retriever.task.Task;

/**
 * The class handles the user interaction between the
 * user and the chatbot.
 */
public class Ui {
    private static String retrieverResponse;

    // Predetermined strings.
    private String dashedLine = "_______________________________________________";
    private String welcomeMessage = "Hello, I am Retriever\nHow Can I Help You Today?";
    private String goodByeMessage = "-> Sad To See You Go!";
    private String emptyListMessage = "My Memory Is Empty, Please Feed Items!";
    private String printListMessage = "-> Your Tasks, My Master:";
    private String goodBoyMessage = "Woof! Whose a Good Boy?";
    private String badBoyMessage = "Woof! Whose a Bad Boy?";
    private String logo = "  __      ^\n"
            + "o'')}____//\n"
            + " `_'      )\n"
            + "(_(_/-(_/\n";

    private Scanner scanner;

    /**
     * Sets up the scanner to take in user input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prints the message received as an argument.
     *
     * @param message The message user would like to print.
     */
    public void printMessage(String message) {
        retrieverResponse = message;
        System.out.println(message);
    }

    /**
     * Prints the welcome message.
     */
    public void printWelcomeMessage() {
        System.out.println(dashedLine);
        System.out.println(welcomeMessage);
        System.out.println(logo);
        System.out.println(dashedLine);

        retrieverResponse = welcomeMessage;
    }

    /**
     * Prints the goodbye message.
     */
    public void printGoodByeMessage() {
        // Closing the scanner.
        scanner.close();

        System.out.println(goodByeMessage);
        System.out.println(dashedLine);

        retrieverResponse = goodBoyMessage;
    }

    /**
     * Prints the error message.
     *
     * @param errorMessage The exception message to be printed.
     */
    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        retrieverResponse = errorMessage;
    }

    /**
     * Prints a dashed line.
     */
    public void printDashedLine() {
        System.out.println(dashedLine);
    }

    /**
     * Prints the task added message in a specified format.
     *
     * @param task The task that has been added.
     * @param taskListLength The length of the task list, after adding the task.
     */
    public void printTaskAdded(Task task, int taskListLength) {
        System.out.println("-> Where's My Treat? I Added:\n\t" + task);
        System.out.println("\nYou Owe Me " + taskListLength + " Treat(s), Master!");

        retrieverResponse = "Where's My Treat? I Added:\n"
                + task + "\nYou Owe Me " + taskListLength + " Treat(s), Master!";
    }

    /**
     * Prints the task deleted message in a specified format.
     *
     * @param task The task that has been deleted.
     * @param taskListLength The length of the task list, after deleting the task.
     */
    public void printTaskDeleted(Task task, int taskListLength) {
        System.out.println(badBoyMessage + "\n"
                + "Task Deleted!\n"
                + "\t" + task
                + "\nYou Owe Me " + taskListLength + " Treat(s), Master!");

        retrieverResponse = badBoyMessage + "\n"
                + "Task Deleted!\n"
                + task
                + "\nYou Owe Me " + taskListLength + " Treat(s), Master!";
    }

    /**
     * Prints the task done message in a specified format.
     *
     * @param task The task that has been done.
     */
    public void printTaskMarkedAsDone(Task task) {
        System.out.println(goodBoyMessage + "\n"
                + "Task Done!\n"
                + "\t" + task);

        retrieverResponse = goodBoyMessage + "\n"
                + "Task Done!\n"
                + task;
    }

    /**
     * Prints the tasks with a matching keyword.
     *
     * @param taskList The ArrayList containing tasks with matching keyword.
     */
    public void printTaskFoundByKeyword(ArrayList<Task> taskList) {
        if (taskList.size() == 0) {
            System.out.println("Sorry Master, I Couldn't Smell And Find WHat You Asked For!");
            retrieverResponse = "Sorry Master, I Couldn't Smell And Find WHat You Asked For!"
                    + "\n (Task With the Given Keyword Does Not Exist)\n";
            return;
        }

        retrieverResponse = "Woof! Look What I Found: /n";
        System.out.println("Woof! Look What I Found: ");

        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + taskList.get(i));
            retrieverResponse += (i + 1) + ". " + taskList.get(i) + "\n";
        }

        System.out.println("You Owe Me " + taskList.size() + " Treat(s), Master!");
        retrieverResponse += "You Owe Me " + taskList.size() + " Treat(s), Master!";
    }

    /**
     * Prints the tasks stored in the list.
     *
     * @param taskList The ArrayList containing the tasks to be printed.
     */
    public void printTaskList(ArrayList<Task> taskList) {
        // If the list is empty
        if (taskList.size() == 0) {
            System.out.println("My Memory Is Empty, Please Feed Items!");
            retrieverResponse = "My Memory Is Empty, Please Feed Items!";
        } else {
            retrieverResponse = "Your Tasks, My Master:\n";
            System.out.println("-> Your Tasks, My Master:");
            for (int i = 0; i < taskList.size(); i++) {
                retrieverResponse += ((i + 1) + ". " + taskList.get(i)) + "\n";
                System.out.println("\t" + ((i + 1) + ". " + taskList.get(i)));
            }
        }
    }

    /**
     * Returns the output that the command generated.
     *
     * @return The response to the command entered.
     */
    public String getRetrieverResponse() {
        return retrieverResponse;
    }

    /**
     * Reads the command entered by the user.
     *
     * @return The user input command.
     */
    public String readCommand() {
        // To store the user input string.
        String userInput;

        // Taking input
        userInput = scanner.nextLine();

        return userInput;
    }
}

