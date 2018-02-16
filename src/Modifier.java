import java.util.concurrent.ThreadLocalRandom;

class Modifier implements Runnable {

    Vertex vertex;
    int size, counter;

    Modifier(Vertex vertex, int size, int counter) {
        this.vertex = vertex;
        this.size = size;
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < counter; i++) {
            this.vertex = this.vertex.random(this.size);
            this.vertex.move(this.vertex.candidate());
            int duration = ThreadLocalRandom.current().nextInt(30);
            try {
                Thread.sleep(duration);
            } catch(InterruptedException e) {
                System.err.println("Error: Modifier Thread Interrupted");
                e.printStackTrace();
            }
        }
    }
}
