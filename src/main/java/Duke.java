import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        talk("Meow I'm Toto! What can I do for you?");
        ArrayList<Task> arrayList = new ArrayList<>(100);
        echo(arrayList);

    }

    public static void talk(String s) {
        System.out.println(s);
    }

    public static void echo(ArrayList<Task> arrayList) {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.equals("bye")) {
            System.out.println("Byebye CATch you later!");
            return;
        }
        if (answer.equals("list")) {
            list(arrayList);
            return;
        }

        if (answer.startsWith("mark ")) {
            int index = Integer.valueOf(answer.substring(5, answer.length()));
            arrayList.get(index - 1).markAsDone();
            System.out.println("I've marked this task as done: " + arrayList.get(index - 1));
            echo(arrayList);
            return;
        }
        if (answer.startsWith("unmark ")) {
            int index = Integer.valueOf(answer.substring(7, answer.length()));
            arrayList.get(index - 1).markAsUndone();
            System.out.println("I've marked this task as not done yet: " + arrayList.get(index - 1 ));
            echo(arrayList);
            return;
        }
        Task t = null;
        if (answer.startsWith("todo ")) {
            t = new Todo(answer.substring(5, answer.length()));
        }
        if (answer.startsWith("deadline ")) {
            System.out.println("By when?");
            String by = scanner.nextLine();
            t = new Deadline(answer.substring(9, answer.length()), by);
        }
        if (answer.startsWith("event ")) {
            System.out.println("From?");
            String from = scanner.nextLine();
            System.out.println("To?");
            String to = scanner.nextLine();
            t = new Event(answer.substring(6, answer.length()), from, to);
        }
        System.out.println("Meow! Just added: \n" + t);
        arrayList.add(t);


        echo(arrayList);
    }

    public static void list(ArrayList<Task> arrayList) {
        for (int i = 1; i < arrayList.size() + 1; i++) {
            System.out.println(i + ". " + arrayList.get(i - 1));
        }
        echo(arrayList);
    }

}
