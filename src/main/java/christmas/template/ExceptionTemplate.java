package christmas.template;

public class ExceptionTemplate {

    public static void execute(Callback callback) {
        while(true) {
            try {
                callback.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
