package yang.preWork.impl;

import yang.preWork.Command;
import yang.preWork.Piple;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class WcImpl implements Command {

    @Override
    public void work(String[] parameters) {
        try {
            String path = parameters[1];
            int countChar = 0;
            int countWord = 0;
            int countLine = 0;

            InputStreamReader isr = new InputStreamReader(new FileInputStream(path));
            BufferedReader br = new BufferedReader(isr);

            while (br.read() != -1) {
                String s = br.readLine();
                countChar += s.length();
                countWord += s.split(" ").length;
                countLine++;
            }
            isr.close();//关闭文件

            System.out.printf("%s\t%s\t%s\t%s\n",countLine,countWord,countChar,path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Piple workWithPiple(String[] parameters, Piple piple) {
        String path = parameters[1];
        int countChar = 0;
        int countWord = 0;
        int countLine = 0;
        while (!piple.isEmpty()) {
            String s = piple.getOne();
            countChar += s.length();
            countWord += s.split(" ").length;
            countLine++;
        }
        System.out.printf("%s\t%s\t%s\t%s\n",countLine,countWord,countChar,path);
        return null;
    }
}
