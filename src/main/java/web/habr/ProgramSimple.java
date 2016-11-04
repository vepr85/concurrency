package web.habr;

class SomeThing implements Runnable {//Нечто, реализующее интерфейс Runnable        //(содержащее метод run())

    public void run()        //Этот метод будет выполняться в побочном потоке
    {
        System.out.println("Привет из побочного потока!");
    }
}

public class ProgramSimple            //Класс с методом main()
{
    static SomeThing mThing;    //mThing - объект класса, реализующего интерфейс Runnable

    public static void main(String[] args) {
        mThing = new SomeThing();

        Thread myThready = new Thread(mThing);    //Создание потока "myThready"
        myThready.start();                //Запуск потока

        System.out.println("Главный поток завершён...");
    }
}