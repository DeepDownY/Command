package yang.preWork.impl;

import yang.preWork.Command;

import java.io.*;

public class CatImpl implements Command {

    @Override
    public void work(String[] parameters) {
        String source = null;
        String target = null;
        boolean isLineNumber = false;
        boolean isCopy = false;
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].equals(">")) {
                source = parameters[i-1];
                isCopy = true;
                if (i+1<parameters.length) {
                    target = parameters[i+1];
                } else {
                    System.out.print("no target File");
                    return;
                }
            }
            if (parameters[i].equals("-n")) {
                isLineNumber = true;
            }
        }
        if (isCopy) {
            dealWithFileCopy(source,target,isLineNumber);
        } else {
            deal(parameters[parameters.length-1],isLineNumber);
        }

    }

    private void dealWithFileCopy(String source, String target,boolean isLineNumber) {
        File file = new File(source);
        File targetFile = new File(target);
        FileOutputStream outSTr;
        BufferedOutputStream buff;
        BufferedReader reader = null;
        String temp;
        int line=1;

        if (!file.isFile() ) {
            System.out.println("no Such File");
            return;
        }
        try {
            outSTr = new FileOutputStream(targetFile);
            buff = new BufferedOutputStream(outSTr);
            reader = new BufferedReader(new FileReader(file));
            while((temp = reader.readLine())!=null) {
                if (isLineNumber) {
                    temp = line + ":    " + temp;
                    System.out.println(temp);
                    line++;
                } else {
                    System.out.println(temp);
                }

                temp = temp + "\n";
                buff.write(temp.getBytes());
            }
            buff.flush();
            buff.close();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if(reader!=null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private void deal(String source, boolean isLineNumber) {
        BufferedReader reader = null;
        String temp;
        int line=1;
        File file = new File(source);

        if (!file.isFile()) {
            System.out.println("no Such File");
            return;
        }

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((temp = reader.readLine())!=null) {
                if (isLineNumber) {
                    System.out.println(line + ":    " + temp);
                    line++;
                } else {
                    System.out.println(temp);
                }
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
