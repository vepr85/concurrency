package web.habr;

public class ProgramInterrupted {
    //Переменая, которой оперирует инкременатор
    public static int mValue = 0;

    static IncremenatorInterrupt mInc;    //Объект побочного потока

    static int twoSeconds = 2 * 1000;

    public static void main(String[] args) {
        mInc = new IncremenatorInterrupt();    //Создание потока

        System.out.print("Значение = ");

        mInc.start();    //Запуск потока

        //Троекратное изменение действия инкременатора
        //с интервалом в i*2 секунд
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(i * 2 * 1000);        //Ожидание в течении i*2 сек.
            } catch (InterruptedException e) {
            }

            mInc.changeAction();    //Переключение действия
        }

        mInc.interrupt();    //Прерывание побочного потока
//		Как видите, мы избавились от метода finish() и реализовали тот же механизм завершения потока с помощью
//		встроенной системы прерываний. В этой реализации мы получили одно преимущество — метод sleep()
//		вернет управление (сгенерирует исключение) незамедлительно после прерывания потока.
    }
}

