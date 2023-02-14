package general;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        Client client = new Client();
        client.init();
    }
}