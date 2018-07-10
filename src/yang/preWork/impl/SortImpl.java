package yang.preWork.impl;

import yang.preWork.Command;
import yang.preWork.Piple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SortImpl implements Command {

    @Override
    public void work(String[] parameters) {
        deal(parameters[1]);
    }

    @Override
    public Piple workWithPiple(String[] parameters, Piple piple) {
        Piple result = new Piple();
        ArrayList<String> list = new ArrayList<>();
        while (!piple.isEmpty()) {
            list.add(piple.getOne());
        }
        String[] word = new String[list.size()];
        list.toArray(word);
        Arrays.sort(word);
        for(String temp_1 : word) {
            System.out.println(temp_1);
            piple.putOne(temp_1);
        }
        return piple;
    }

    private void deal(String source) {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = null;
        String temp;
        File file = new File(source);

        if (!file.isFile()) {
            System.out.println("no Such File");
            return;
        }

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine()) != null) {
                list.add(temp);
            }
            String[] word = new String[list.size()];
            list.toArray(word);
            Arrays.sort(word);
            for(String temp_1 : word) {
                System.out.println(temp_1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(reader!=null) {
                try {
                    reader.close();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
