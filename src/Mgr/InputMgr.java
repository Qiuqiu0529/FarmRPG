package Mgr;

import java.util.Scanner;

public class InputMgr {
    private static volatile  InputMgr instance;
    private InputMgr() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }
    Scanner scanner = new Scanner(System.in,"gbk");

    public static InputMgr GetInstance() {
        var result = instance;
        if (result == null) {
            synchronized (InputMgr.class) {
                result = instance;
                if (result == null) {
                    instance = result = new InputMgr();
                }
            }
        }
        return result;
    }

    public int GetInputInt(int min,int max)//待定
    {
        Integer i=scanner.nextInt();
        if(i instanceof Integer)
        {
            if(i>=min&&i<max)
            {
                return i;
            }
        }

        return GetInputInt(min,max);
    }

    public String GetInputString()
    {
        String a=scanner.next();
        return a;
    }

}
