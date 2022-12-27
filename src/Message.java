import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Message {
    static Queue queue = new Queue();
    static Stack stack = new Stack();

    public void InputMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("You have entered: " + str);
        //nested method
        CheckMessage(str);
        Process(str);
    }

    public void CheckMessage(String str) {
        try {
            if (str == null || str.length() == 0) {
                throw new NullPointerException("String is empty, please re-enter!");

            } else if (str.length() > 250) {
                throw new NullPointerException("Strings greater than 250 characters! Please re-enter!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            InputMessage();
            Process(str);
        }
    }

    public void Process(String str){
        try {
            String[] arr = str.split("\\.");
            for (int i = 0; i < arr.length; i++) {
                queue.add(arr[i].trim());
            }
            while (!queue.isEmpty()){
                stack.push(queue.pop());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Message ms = new Message();
        long startTime = System.currentTimeMillis();
        ms.InputMessage();
        long endTime = System.currentTimeMillis();
        stack.print();
        double timeElapsed = (endTime - startTime)/10000.0;
        System.out.println("Execution time when run: " + timeElapsed + " second") ;
    }
}
