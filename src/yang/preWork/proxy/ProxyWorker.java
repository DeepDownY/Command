package yang.preWork.proxy;

import yang.preWork.Command;
import yang.preWork.handle.CommandHandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyWorker {
    public static void work(String[] args) {
        try {
            CommandHandle handler = CommandHandle.getHandle(args[0]);
            Command command = (Command) Proxy.newProxyInstance(handler.getClass().getClassLoader(),handler.getTarget().getClass().getInterfaces(),handler);
            command.work(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
