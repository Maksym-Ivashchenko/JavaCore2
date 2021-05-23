package lessons;

import java.util.concurrent.Semaphore;

public class Hidrogen extends Thread{
        Semaphore sem; // семафор. ограничивающий число философов
        // кол-во приемов пищи
        int num = 0;
        // условный номер философа
        String id = "H";
        // в качестве параметров конструктора передаем идентификатор философа и семафор
        Hidrogen(Semaphore sem)
        {
            this.sem=sem;
            //this.id=id;
        }

        public void run()
        {
            try
            {
                while(num<2)// пока количество приемов пищи не достигнет 3
                {
                    //Запрашиваем у семафора разрешение на выполнение
                    sem.acquire();
                    //System.out.println (id);
                    // философ ест
                    sleep(500);
                    num++;

                    System.out.println (id);
                    sem.release();

                    // философ гуляет
                    sleep(500);
                }
            }
            catch(InterruptedException e)
            {
                System.out.println ("у " + id + " проблемы");
            }
        }
}
