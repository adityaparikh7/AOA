import java.util.*;

public class GraphColoring {
    private int numOfVertices;
    private int numOfColors;
    private int[] colors;
    private int[][] graph;

    public GraphColoring(int numOfVertices, int numOfColors) {
        this.numOfVertices = numOfVertices;
        this.numOfColors = numOfColors;
        this.colors = new int[numOfVertices];
        this.graph = new int[numOfVertices][numOfVertices];
        generateGraph();
    }

    private void generateGraph() {
        Random random = new Random();
        for (int i = 0; i < numOfVertices; i++) {
            for (int j = i + 1; j < numOfVertices; j++) {
                int randInt = random.nextInt(2);
                graph[i][j] = randInt;
                graph[j][i] = randInt;
            }
        }
    }

    public void solve() {
        if (colorGraph(0)) {
            printColors();
        } else {
            System.out.println("No solution exists.");
        }
    }

    private boolean colorGraph(int nodeIndex) {
        if (nodeIndex == numOfVertices) {
            return true;
        }

        for (int colorIndex = 1; colorIndex <= numOfColors; colorIndex++) {
            if (isColorValid(nodeIndex, colorIndex)) {
                colors[nodeIndex] = colorIndex;

                if (colorGraph(nodeIndex + 1)) {
                    return true;
                }

                colors[nodeIndex] = 0;
            }
        }

        return false;
    }

    private boolean isColorValid(int nodeIndex, int colorIndex) {
        for (int i = 0; i < numOfVertices; i++) {
            if (graph[nodeIndex][i] == 1 && colorIndex == colors[i]) {
                return false;
            }
        }

        return true;
    }

    private void printColors() {
        System.out.println("Solution exists: ");
        for (int i = 0; i < numOfVertices; i++) {
            System.out.println("Node " + (i + 1) + " has color index: " + colors[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        int numOfVertices = sc.nextInt();
        System.out.println("Enter number of colors: ");
        int numOfColors = sc.nextInt();
        GraphColoring graphColoring = new GraphColoring(numOfVertices, numOfColors);
        graphColoring.solve();
    }
}
