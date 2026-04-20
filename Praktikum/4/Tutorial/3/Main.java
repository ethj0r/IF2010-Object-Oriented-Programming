import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Courier[] couriers = new Courier[N];
        String[] items = new String[N];

        for (int i=0; i<N; i++) {
            char type = sc.next().charAt(0);
            String name = sc.next();
            int speed = sc.nextInt();
            String item = sc.next();

            if (type == 'B') {
                couriers[i] = new BikeCourier(name, speed);
            } else if (type == 'C') {
                couriers[i] = new CarCourier(name, speed);
            }
            items[i] = item;
        }

        int totalSpeed = 0;
        boolean isGreaterForty = false;
        for (int i=0; i<N; i++) {
            totalSpeed += couriers[i].getSpeed();
            System.out.println(couriers[i]);
            System.out.println(couriers[i].deliver(items[i]));

            if (couriers[i].getSpeed() > 40) {
                isGreaterForty = true;
            }
        }

        if (N == 0) {
            System.out.println("Average speed: 0.00");
            System.out.println("Fast? false");
            return;
        }

        double averageSpeed = (double)totalSpeed/N;
        System.out.printf("Average speed: %.2f%n", averageSpeed);
        if (isGreaterForty) {
            System.out.println("Fast? true");
        } else {
            System.out.println("Fast? false");
        }
    }
}
