package yang.preWork;

public interface Command {

    void work(String [] parameters);

    Piple workWithPiple(String [] parameters, Piple piple);

}
