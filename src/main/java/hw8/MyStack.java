package hw8;

import java.util.Arrays;

public class MyStack<T> {
   // push(Object value); // добавляет элемент в конец
    //remove(int index); // удаляет элемент под индексом
   // clear(); // очищает коллекцию
   // size(); // возвращает размер коллекции
   // peek(); // возвращает первый элемент в стеке (LIFO)
   // pop(); // возвращает первый элемент в стеке и удаляет его из коллекции

   private Object[] myStackArray;
   private int size;

        public MyStack() {
            myStackArray = new Object[10];
            size = 0;
        }

        public int getSize() {
            return size;
        }

        public void push(T value) {
            if (size == myStackArray.length) {
                Object[] newArray = new Object[myStackArray.length*2];
                System.arraycopy(myStackArray, 0, newArray, 0, myStackArray.length);
                myStackArray = newArray;
            }
            myStackArray[myStackArray.length - 1 - size++] = value;
        }

        public void remove(int index) {
            Object[] newArray = new Object[myStackArray.length-1];
            System.arraycopy(myStackArray, 0, newArray, 0, index);
            System.arraycopy(myStackArray, index + 1, newArray, index, myStackArray.length-1-index);
            myStackArray = newArray;
            size--;
        }

        public void clear() {
            size = 0;
            myStackArray = new Object[10];
        }

        public int size() {
            return getSize();
        }

        public T get(int index) {
            return (T) myStackArray[index];
        }

        public T peek() {
            return (T) myStackArray[0];
        }

        public T pop() {
            Object[] newArray = new Object[myStackArray.length-1];
            T firstElement = (T) myStackArray[0];
            System.arraycopy(myStackArray, 1, newArray, 0, myStackArray.length-1);
            myStackArray = newArray;
            size--;
            return firstElement;

        }

        public static void main(String[] args) {
            MyStack<Integer> myStack = new MyStack<>();

            myStack.push(10);
            myStack.push(20);
            myStack.push(30);

            //  myQueue.clear();

            myStack.push(40);
            myStack.push(50);
            myStack.push(60);
            myStack.push(70);
            myStack.push(80);
            myStack.push(90);
            myStack.push(100);

            myStack.remove(4);

            System.out.println(Arrays.toString(myStack.myStackArray));
            System.out.println(myStack.getSize());
            System.out.println(myStack.get(1));
            System.out.println(myStack.peek());
            System.out.println(myStack.pop());
            System.out.println(myStack.pop());
        }

    }
