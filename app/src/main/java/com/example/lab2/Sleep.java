package com.example.lab2;

public class Sleep  extends  Thread{
    MainActivity main_act;


    Sleep (MainActivity main_act){
        this.main_act = main_act;
    }

    public void sleeping() throws Exception{   // trows - защита от исключений. Объявляет о таком
        // поведении, чтобы методы смогли себя защитить
        Thread.sleep(2000);
        main_act.openNewActivity();

    }

    @Override
    public void run(){     //переопределение метода run из Runnable, запуск потока
        super.run();
        try {           // обработка возможных исключений
            sleeping();
        } catch (Exception x){
            return;
        }
    }
}
