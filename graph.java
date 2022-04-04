package com.mycompany.graph_drawing;

public class graph 
{

    public int INFINITY = Integer.MAX_VALUE;
    private int[] distance = new int[1000];
    public int[] visited = new int[1000];
    private boolean[] spt = new boolean[1000];
    protected static int[][] adj_graph = new int[1000][1000];
    protected static int nodenumber;
    protected int eadges;

    //////--------------------------------- this is constructor for the class  -------------------------------------------
    public graph(int nodenumber, int eadges) {
        graph.nodenumber = nodenumber;
        this.eadges = eadges;
    }
    //----------------------- this method to clear the adj_matrix of graph
    public void clear() {
        for (int i = 0; i < nodenumber; i++) {

            for (int j = 0; j < nodenumber; j++) {
                if (adj_graph[i][j] == -1) {
                    continue;
                } else {
                    adj_graph[i][j] = 0;
                }

            }
        }
    }

    //------------------------------   to display the adj_matrix of the  graph
    public void displaymatrix() {
        for (int i = 0; i < nodenumber; i++) {
            for (int j = 0; j < nodenumber; j++) {
                if (adj_graph[i][j] == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print(adj_graph[i][j] + "  ");
                }
            }
            System.out.println(" ");
        }
     
    }

    //-------------------------   this method to check if the graph is totaly connected or not
    public int dfs(int root) {
        visited[root] = 1;
        for (int i = 0; i < nodenumber; i++) {
            if ((visited[i] == 0)) {
                return dfs(i) + 1;
            }
        }
        return 0;
    }

    // -----------------------------------  minimum node  --------------------------------------------
    public int minimumnode(boolean[] mst, int[] arr) 
    {
        int mini = INFINITY, vertex = 0;
        for (int i = 0; i < nodenumber; i++) {
            if (mst[i] == false && mini > arr[i]) {
                mini = arr[i];
                vertex = i;
            }
        }
        return vertex;
    }

    // -----------------------------------------Dijkstra---------------------------------------
    public void dijkstra(int sourceVertex, int distination) {
        try {
            for (int i = 0; i < nodenumber; i++) 
            {
                distance[i] = INFINITY;
            }
            distance[sourceVertex] = 0;
            for (int i = 0; i < nodenumber; i++) {
                int node1 = minimumnode(spt, distance);
                spt[node1] = true;
                
                for (int node2 = 0; node2 < nodenumber; node2++) {
                    if (adj_graph[node1][node2] > 0 && adj_graph[node1][node2] != INFINITY) {
                        if (spt[node2] == false) {
                            int newKey = adj_graph[node1][node2] + distance[node1];
                            if (newKey < distance[node2]) {
                                distance[node2] = newKey;
                            }
                        }
                    }
                }
            }
            System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
            if (distance[distination - 1] == 2147483647) {
                System.out.println(" Mafe4 Taree2 ya pa4a  ");
                System.out.println("\uD83D\uDE00");
            } else {
                System.out.println("Source Vertex: " + (sourceVertex + 1) + " to vertex " + (distination)
                        + " distance: " + distance[distination - 1]);
            }
        } catch (Exception e) {
            System.out.println("you must enter positive numbers for nodes!!!!!!!!");
        }
    }
}
