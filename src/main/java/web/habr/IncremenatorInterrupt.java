package web.habr;

/**
 * https://habrahabr.ru/post/164487/
 */
class IncremenatorInterrupt extends Thread {
    private volatile boolean mIsIncrement = true;

    public void changeAction()    //Меняет действие на противоположное
    {
        mIsIncrement = !mIsIncrement;
    }

    @Override
    public void run() {
        do {
            System.out.println(Thread.currentThread().getName());
            if (!Thread.interrupted())    //Проверка прерывания
            {
                if (mIsIncrement) Program.mValue++;    //Инкремент
                else Program.mValue--;            //Декремент

                //Вывод текущего значения переменной
                System.out.print(Program.mValue + " ");
            } else {
                return;        //Завершение потока
            }

            try {
                Thread.sleep(1000);        //Приостановка потока на 1 сек.
            } catch (InterruptedException e) {
                return;    //Завершение потока после прерывания
            }
        }
        while (true);
    }
}