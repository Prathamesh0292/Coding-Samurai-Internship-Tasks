import java.util.ArrayList;
import java.util.Scanner;

class Task {
    //Declare a Variable for  list
    private String title;
    private String desc;
    private String date;
    private boolean isComplete;

    //create a constructor
    public Task(String title,String desc,String date) {
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.isComplete = false;
    }
//create a gettitle method which is retrun the title;
    public String gettitle() {
        return title;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markComplete() {
        isComplete = true;
    }

    //ovverride to string method for formating our values
    @Override
    public String toString() {
        return "Title:"+title+"\n"+  "Description:" + desc+"\n" + "Date:" + date+"\n"+
                "Status:"+ (isComplete ? "Complete"  : "Incomplete" );
    }
}

public class ToDOApp {
    //Create Arryalist for store Value in List
    private static ArrayList<Task> tasks = new ArrayList<>();
    //Call Scanner Class Which is take input from user
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n------Welcome to Todo List Application------");
            System.out.println("  =============================================");
            System.out.println("Select Number Form Menu to perform below Option");
            System.out.println("1 - Add Task");
            System.out.println("2 - List Tasks");
            System.out.println("3 - Mark Task as Complete");
            System.out.println("4 - Remove Task");
            System.out.println("0 - Exit");
            System.out.print("Enter a Number: ");

            int choice = sc.nextInt();
            sc.nextLine(); //

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markAsComplete();
                    break;
                case 4:
                    removeTask();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //function or method for add task
    private static void addTask() {
        System.out.print("Enter task Title: ");
        String title = sc.nextLine();
        System.out.print("Enter task Description: ");
        String desc = sc.nextLine();
        System.out.print("Enter task Date: ");
        String date = sc.nextLine();

        Task task = new Task(title,desc,date);tasks.add(task);

        System.out.println("Task added: " + task.gettitle());
    }
    //function or method for view task
    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    //function or method for mark task as complete
    private static void markAsComplete() {
        viewTasks();
        System.out.print("Enter the task number to mark as complete: ");
        int taskNumber = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.markComplete();
            System.out.println("Task marked as complete: " + task.gettitle());
        } else {
            System.out.println("Invalid task number.");
        }
    }
    //function or method for remove task
    private static void removeTask()   {
        viewTasks();
        System.out.print("Enter the task number to remove: ");
        int taskNumber = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task removed: " + removedTask.gettitle());
        } else {
            System.out.println("Invalid task number.");

        }
    }
}