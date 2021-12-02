package javaFSMonitor;


public class JavaAppFSMonitor {

    public static void main(String[] args) {
        FSServer server = new FSServer(".");
        server.addClient(new FSMonitor() {

            @Override
            public void event(String fName, int kind) {
                switch (kind) {
                    case FSMonitor.CREATE:
                        System.out.println("File created: " + fName);
                        break;
                    case FSMonitor.REMOVE:
                        System.out.println("File remowed: " + fName);
                        break;
                    default:
                        System.out.println("Unknown event!");
                }

            }

        });
        server.start();
    }

}
