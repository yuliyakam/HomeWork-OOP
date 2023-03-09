package Calc;

public class Operation {
    Logirable logger;
    MainLogger ml = new MainLogger();
    public Operation(Logirable logger){
        this.logger = logger;
    }
    public Operation(){ }
    public void  getAnswer(String str){
        System.out.println(str);
        ml.doLog(new Logger(str));
    }

    }

