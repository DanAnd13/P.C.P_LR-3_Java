public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int storageSize = 3;
        int consumers = 2;
        int producers = 4;
        //int itemNumbers = 6;
        int [] itemsConsumer = {3, 8};
        int [] itemsProducer = {3, 3, 3, 2};
        main.starter(consumers, producers, storageSize, itemsConsumer, itemsProducer );
    }

    private void starter(int consumers, int producers, int storageSize, int[] itemsConsumer, int[] itemsProducer) {
        Manager manager = new Manager(storageSize);

        for(int i = 0; i < consumers; i++)
        {
            new Consumer(i, itemsConsumer[i], manager);
        }
        for(int i = 0; i < producers; i++)
        {
            new Producer(i, itemsProducer[i], manager);
        }
    }
}