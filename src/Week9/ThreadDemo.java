class MyRunnable implements Runnable {
    String threadName;
    MyRunnable(String name) {
        threadName = name;
    }

    @Override
    // Entry point of runnable.
    public void run() {
        System.out.println(threadName + " starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + threadName +

                        ", count is " + count);

            }
        } catch (InterruptedException exc) {
            System.out.println(threadName + " interrupted.");
        }
        System.out.println(threadName + " terminating.");
    }
}

class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("Main thread starting.");

        MyRunnable mr = new MyRunnable("Child #1");

        Thread newThread = new Thread(mr);

        newThread.start();
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}