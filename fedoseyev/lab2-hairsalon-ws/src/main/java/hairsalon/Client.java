package hairsalon;

import hairsalon.service.HairSalonServer;
import hairsalon.service.HairSalonServerService;

import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        HairSalonServerService hairSalonServerService = new HairSalonServerService();
        HairSalonServer hairSalonServerProxy = hairSalonServerService.getHairSalonServerPort();

        Scanner scanner = new Scanner(System.in);
        String name;
        int dur;
        int cost;
        int id;
        String date;
        int hour;
        int min;
        while (1 == 1) {
            System.out.println("get, times, make, remove");
            String input = scanner.nextLine();

            if (Objects.equals(input, "get")) {
                String s = hairSalonServerProxy.getServices();
                System.out.println(s);
            }

            if (Objects.equals(input, "times")) {
                date = scanner.nextLine();
                String s = hairSalonServerProxy.getFreeTime(date);
                System.out.println(s);
            }

            if (Objects.equals(input, "make")) {
                date = scanner.nextLine();
                hour = Integer.parseInt(scanner.nextLine());
                min = Integer.parseInt(scanner.nextLine());
                id = Integer.parseInt(scanner.nextLine());
                String s = hairSalonServerProxy.makeAppointment(date, hour, min, id);
                System.out.println(s);
            }

            if (Objects.equals(input, "remove")) {
                id = Integer.parseInt(scanner.nextLine());
                hairSalonServerProxy.removeAppointment(id);
            }
        }
    }
}