package yang.preWork;

import yang.preWork.handle.CommandHandle;
import yang.preWork.proxy.ProxyWorker;

import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandHandle.init();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.nextLine();
            String [] woods = command.split(" ");
            ProxyWorker.work(woods);
        }
    }
}
