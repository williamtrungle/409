class Star {

    static final int height = 1080;
    static final int width = 1920;
    static int c, m;
    static final double[][] polygon = {
        {-1.0, 5.0},
        {1.0, 2.0},
        {5.0, 0.0}, 
        {1.0, -2.0},
        {-4.0, -4.0},
        {-3.0, -1.0}
    };
    static final int size = polygon.length;

    public static void main(String[] args) {
        try {
            Vertex vertex = constructPolygon();

            if (args.length == 2) {
                m = Integer.parseInt(args[0]);
                c = Integer.parseInt(args[1]);

                if (m > size) {
                    throw new Exception("Error: Invalid first arguments");
                    
                } else if (c < 0) {
                    throw new Exception("Error: Invalid second arguments");
                }
            } else {
                throw new Exception("Error: Invalid arguments");
            }

            Thread[] threads = new Thread[m];

            for (int i = 0; i < m; i++) {
                threads[i] = new Thread(new Modifier(vertex, size, c));
                threads[i].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            // Print out resulting star
            for (int i = 0; i < size; i++) {
                System.out.printf("%f\t%f\n", vertex.x, vertex.y);
                vertex = vertex.next;
            }
        } catch (Exception e) {
            System.err.println("Error: "+e);
            e.printStackTrace();
        }
    }

    // Create polygon
    static Vertex constructPolygon() {
        // Construct hard-coded polygon
        int p = 0;
        Vertex v = new Vertex(polygon[p][0], polygon[p][1]);
        Vertex first = v;
        Vertex prev = v;

        for (p = 1; p < size; p++) {
            v = new Vertex(polygon[p][0], polygon[p][1]);
            v.prev = prev;
            prev.next = v;
            prev = v;
        }
        first.prev = v;
        first.first = true;
        v.next = first;
        return first;
    }
}
