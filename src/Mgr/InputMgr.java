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

    public int GetInputInt(int min,int max)
    {
        int a=scanner.nextInt();
        if(!(a<max&&a>=min))
        {
            System.out.println("不在选择范围内，请重选！");
            a=GetInputInt(min,max);
        }
        return a;
    }

    public String GetInputString()
    {
        String a=scanner.next();
        return a;
    }

}
