package practice;

class Reordering {

    int x = 0,
        y = 0;

    public void writer() {
        x = 1;
        y = 2;
        System.out.println(Thread.currentThread().getName() + " WRITER: " + x + " " + y);
    }

    public void reader() {
        System.out.println(Thread.currentThread().getName() + " READER: " + x + " " + y);
    }
}