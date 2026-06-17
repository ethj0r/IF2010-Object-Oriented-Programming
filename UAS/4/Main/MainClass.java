public class MainClass {

    public static void main(String[] args){

    ClassLoader classLoader = MainClass.class.getClassLoader();
        try {
            Class aClass = classLoader.loadClass("com.Main.SmartFan");
            System.out.println("aClass.getName() = " + aClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
// Class<?> aClass = classLoader.loadClass("com.example.MyClass");
