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

    // Select a random vertex
    Vertex random(int length) {
        Vertex v = this;
        int r = ThreadLocalRandom.current().nextInt(length);
        for (int i = 0; i < r; i++) {
            v = v.next;
        }
        return v;
    }

    // Generate a candidate set of coordinates
    double[] candidate() {
        double[] c = new double[2];
        double r1 = Math.sqrt(ThreadLocalRandom.current().nextDouble());
        double r2 = ThreadLocalRandom.current().nextDouble();
        c[0] = (1 - r1) * this.prev.x + (r1 * (1 - r2)) * this.x + (r1 * r2) * this.next.x;
        c[1] = (1 - r1) * this.prev.y + (r1 * (1 - r2)) * this.y + (r1 * r2) * this.next.y;
        return c;
    }

    public void run() {
        //
    }
}
