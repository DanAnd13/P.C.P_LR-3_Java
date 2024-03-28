public class Producer implements Runnable{
    private final int id;
    private final int itemNumbers;
    private final Manager manager;

    public Producer(int id, int itemNumbers, Manager manager) {
        this.id = id;
        this.itemNumbers = itemNumbers;
        this.manager = manager;

        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < itemNumbers; i++) {
            try {
                manager.full.acquire();
                manager.access.acquire();
                //if(!manager.storage.contains("item " + i)) {
                    manager.storage.add("item " + i);
                    System.out.println("Producer " + id + " added item " + i);
                //}

                manager.access.release();
                manager.empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
