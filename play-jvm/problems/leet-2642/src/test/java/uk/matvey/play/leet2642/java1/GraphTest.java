package uk.matvey.play.leet2642.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTest {

    @Test
    public void case1() {
        var edges = new int[][]{{0, 2, 5}, {0, 1, 2}, {1, 2, 1}, {3, 0, 3}};
        Graph graph = new Graph(4, edges);

        assertThat(graph.shortestPath(3, 2)).isEqualTo(6);
        assertThat(graph.shortestPath(0, 3)).isEqualTo(-1);

        graph.addEdge(new int[]{1, 3, 4});

        assertThat(graph.shortestPath(0, 3)).isEqualTo(6);
    }
}
