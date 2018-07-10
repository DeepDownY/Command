package yang.preWork.proxy;

import yang.preWork.Command;
import yang.preWork.Piple;
import yang.preWork.handle.CommandHandle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyWorker {
    public static void work(String[] args) {
        try {
            CommandHandle handler = CommandHandle.getHandle(args[0]);
            Command command = (Command) Proxy.newProxyInstance(handler.getClass().getClassLoader()
                    ,handler.getTarget().getClass().getInterfaces()
                    ,handler);
            command.work(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Piple works(String[] args, Piple piple) {
        try {
            CommandHandle handler = CommandHandle.getHandle(args[0]);
            Command command = (Command) Proxy.newProxyInstance(handler.getClass().getClassLoader()
                    ,handler.getTarget().getClass().getInterfaces()
                    ,handler);
            piple = command.workWithPiple(args,piple);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piple;
    }
}
