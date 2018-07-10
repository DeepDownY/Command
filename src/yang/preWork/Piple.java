package yang.preWork;

import java.util.concurrent.LinkedBlockingQueue;

public class Piple {

    private LinkedBlockingQueue<String> content = new LinkedBlockingQueue<>();

    public void putOne(String one) {
        try {
            content.put(one);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getOne()  {
        String result = null;
        try {
            result = content.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean isEmpty () {
        return content.isEmpty();
    }
}
