package BS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TC_02 {
    static class Edge implements Comparable<Edge> {
        int u, v;
        int weight;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.weight = w;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    static int[] parent;
    static int[] size;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt();
            edges[i] = new Edge(u, v, w);
        }

        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(edges);

        long answer = 0;
        int i = 0;
        while (i < m) {
            int currentWeight = edges[i].weight;
            List<Edge> sameWeightEdges = new ArrayList<>();
            while (i < m && edges[i].weight == currentWeight) {
                sameWeightEdges.add(edges[i]);
                i++;
            }

            long deltaPairs = 0;

            for (Edge edge : sameWeightEdges) {
                int uRoot = find(edge.u);
                int vRoot = find(edge.v);

                if (uRoot != vRoot) {
                    long pairs = (long) size[uRoot] * size[vRoot];
                    union(uRoot, vRoot);
                    deltaPairs += pairs;
                }
            }

            if (currentWeight == k) {
                answer = deltaPairs;
                break;
            }
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        if (size[x] < size[y]) {
            parent[x] = y;
            size[y] += size[x];
        } else {
            parent[y] = x;
            size[x] += size[y];
        }
    }
}
