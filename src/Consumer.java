public class Consumer implements Runnable {
    private  final int id;
    private final int itemNumbers;
    private final Manager manager;

    public Consumer(int id, int itemNumbers, Manager manager) {
        this.id = id;
        this.itemNumbers = itemNumbers;
        this.manager = manager;

        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < itemNumbers; i++) {
            String item;
            try {
                manager.empty.acquire();
                Thread.sleep(1000);
                manager.access.acquire();
                //if(manager.storage.contains("item " + i)) {
                    item = manager.storage.get(0);
                    manager.storage.remove(0);
                    System.out.println("Consumer " + id + " took " + item);
                //}

                manager.access.release();
                manager.full.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
