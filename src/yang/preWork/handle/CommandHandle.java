package yang.preWork.handle;

import yang.preWork.Command;
import yang.preWork.impl.CatImpl;
import yang.preWork.impl.GrepImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CommandHandle implements InvocationHandler {

    private Command target;

    private static Map<String, Command> commandImpls = new HashMap<>();

    private static Map<String,CommandHandle> handlerHolder = new HashMap<>();

    public static void init() {
        CatImpl cat = new CatImpl();
        commandImpls.put("cat",cat);
        commandImpls.put("grep",new GrepImpl());
    }

    public static CommandHandle getHandle(String key){
        if (handlerHolder.get(key) == null) {
            CommandHandle handle = new CommandHandle(key);
            handlerHolder.put(key,handle);
            return handle;
        } else {
            return handlerHolder.get(key);
        }
    }


    private CommandHandle(String key) {
        if (commandImpls.get(key) != null) {
            this.target = commandImpls.get(key);
        } else {
            System.out.print("no such Command");
        }

    }

    public Command getTarget() {
        return target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return  method.invoke(target,args);
    }
}
