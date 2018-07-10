package yang.preWork;

import yang.preWork.handle.CommandHandle;
import yang.preWork.proxy.ProxyWorker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandHandle.init();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            if (command.split("\\|").length > 1) {
                String[] commands = command.split("\\|");
                Piple piple = new Piple();
                for (String single : commands) {
                    single = single.trim();
                    String[] woods = single.split(" ");
                    piple = ProxyWorker.works(woods, piple);
                }
            } else {
                String[] woods = command.split(" ");
                ProxyWorker.work(woods);
            }
        }
    }
}
