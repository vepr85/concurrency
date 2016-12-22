package web.habr;

class Incremenator extends Thread {
    //О ключевом слове volatile - чуть ниже
    private volatile boolean mIsIncrement = true;
    private volatile boolean mFinish = false;

    public void changeAction()    //Меняет действие на противоположное
    {
        mIsIncrement = !mIsIncrement;
    }

    public void finish()        //Инициирует завершение потока
    {
        mFinish = true;
    }

    @Override
    public void run() {
        do {
//            System.out.println(Thread.currentThread().getName());

            if (!mFinish)    //Проверка на необходимость завершения
            {
                if (mIsIncrement) {
                    Program.mValue++;    //Инкремент
                } else {
                    Program.mValue--;    //Декремент
                }

                //Вывод текущего значения переменной
                System.out.print(Program.mValue + " ");
            } else {
                return;        //Завершение потока
            }

            //Приостановка потока на 1 сек.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        } while (true);
    }
}