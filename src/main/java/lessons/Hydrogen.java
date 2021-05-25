package lessons;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Hydrogen extends Thread{
    //private static final CyclicBarrier BARRIER = new CyclicBarrier(3);

    Semaphore sem; // семафор. ограничивающий число философов
        int num = 0; // кол-во приемов пищи
        String id; // условный номер философа
        // в качестве параметров конструктора передаем идентификатор философа и семафор
        Hydrogen(Semaphore sem, String id)
        {
            this.sem=sem;
            this.id=id;
        }
        @Override
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
                    //BARRIER.await();
                    System.out.print (id);
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
