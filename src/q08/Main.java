import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 

        int[] stack = new int[n]; 
        int top = -1;             

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.startsWith("PUSH")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                top++;
                stack[top] = x;
            } else if (command.equals("POP")) {
                if (top == -1) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(stack[top]);
                    top--;
                }
            } else if (command.equals("PEEK")) {
                if (top == -1) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(stack[top]);
                }
            } else if (command.equals("SIZE")) {
                System.out.println(top + 1);
            }
        }

        sc.close();
    }
}
