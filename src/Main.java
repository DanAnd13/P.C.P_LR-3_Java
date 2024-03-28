public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int storageSize = 3;
        int itemNumbers = 6;
        int consumers = 2;
        int producers = 2;
        main.starter(consumers, producers, storageSize, itemNumbers);
    }

    private void starter(int consumers, int producers, int storageSize, int itemNumbers) {
        Manager manager = new Manager(storageSize);
        for(int i = 0; i < consumers; i++)
        {
            new Consumer(i, itemNumbers, manager);
        }
        for(int i = 0; i < producers; i++)
        {
            new Producer(i, itemNumbers, manager);
        }
    }
}