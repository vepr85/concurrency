package web.habr;

/**
 * https://habrahabr.ru/post/164487/
 */
public class Program
{
	//Переменая, которой оперирует инкременатор
	public static int mValue = 0;
	//  1 2 1 0 -1 -2 -1 0 1 2 3 4
	static Incremenator mInc;	//Объект побочного потока

	static int twoSeconds = 2 * 1000;

	public static void main(String[] args)
	{
		mInc = new Incremenator();	//Создание потока

		System.out.print("Значение = ");

		mInc.start();	//Запуск потока

		//Троекратное изменение действия инкременатора с интервалом в i*2 секунд
		for(int i = 1; i <= 3; i++)
		{
			try{
				Thread.sleep(i * twoSeconds); //Ожидание в течении i*2 сек.
			}catch(InterruptedException e){}

			mInc.changeAction();	//Переключение действия
		}

		mInc.finish();	//Инициация завершения побочного потока
	}
}

