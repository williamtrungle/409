import java.util.concurrent.ThreadLocalRandom;

class Vertex implements Runnable {
    
    double x, y;
    Vertex prev, next;

    Vertex(double x, double y) {
        this.x = x;
        this.y = y;
        this.prev = null;
        this.next = null;
    }

    Vertex random(int length) {
        Vertex v = this;
        int r = ThreadLocalRandom.current().nextInt(length);
        for (int i = 0; i < r; i++) {
            v = v.next;
        }
        return v;
    }

    public void run() {
        //
    }
}
