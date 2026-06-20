import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SmartHomeController {

    private SmartHomeController() {
    }

    public static void printStatus(Object device) {
        Field[] fields = device.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                System.out.println(field.getName() + " = " + field.get(device));
            } catch (Exception e) {
                System.out.println("FIELD_ACCESS_ERROR");
            }
        }
    }

    public static void printCommands(Object device) {
        Method[] methods = device.getClass().getDeclaredMethods();
        String[] names = new String[methods.length];

        for (int i = 0; i < methods.length; i++) {
            names[i] = methods[i].getName();
        }

        Arrays.sort(names);

        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void execute(Object device, String command) {
        Method method;

        try {
            method = device.getClass().getDeclaredMethod(command);
        } catch (Exception e) {
            System.out.println("COMMAND_NOT_FOUND");
            return;
        }

        try {
            method.setAccessible(true);
            method.invoke(device);
        } catch (Throwable t) {
            System.out.println("COMMAND_EXECUTION_ERROR");
        }
    }
}
