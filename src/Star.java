class Star {

    static final double[][] polygon = {
        {-1.0, 5.0},
        {1.0, 2.0},
        {5.0, 0.0}, 
        {1.0, -2.0},
        {-4.0, -4.0},
        {-3.0, -1.0}
    };

    public static void main(String[] args) {
        Vertex vertex = constructPolygon();
        int size = polygon.length;

        if (args.length >= 1) System.out.println(args[0]);
        if (args.length >= 2) System.out.println(args[1]);
        System.out.println("Polygon:");
        for (int i = 0; i < size; i++) {
            System.out.printf("(%f, %f)\n", vertex.x, vertex.y);
            vertex = vertex.next;
        }

        System.out.printf("\nRandom vertex: ");
        vertex = vertex.random(size);
        System.out.printf("(%f, %f)\n", vertex.x, vertex.y);

        System.out.printf("\nGenerate candidate: ");
        double[] c = vertex.candidate();
        System.out.printf("(%f, %f)\n", c[0], c[1]);
    }

    // Create polygon
    static Vertex constructPolygon() {
        // Construct hard-coded polygon
        int p = 0;
        Vertex v = new Vertex(polygon[p][0], polygon[p][1]);
        Vertex first = v;
        Vertex prev = v;

        for (p = 1; p < polygon.length; p++) {
            v = new Vertex(polygon[p][0], polygon[p][1]);
            v.prev = prev;
            prev.next = v;
            prev = v;
        }
        first.prev = v;
        v.next = first;
        return first;
    }
}
