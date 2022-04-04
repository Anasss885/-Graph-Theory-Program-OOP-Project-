package com.mycompany.graph_drawing;

import static com.mycompany.graph_drawing.graph.nodenumber;
import static com.mycompany.graph_drawing.graph.adj_graph;
import java.util.Scanner;

public class nodeee implements nodee 
{
//public boolean checkofnode[]=new boolean [1000];
//   public boolean checkofdeletednode[]=new boolean [1000];
    Scanner input = new Scanner(System.in);

    @Override
    public void add_node() {
        try {
            //Scanner input = new Scanner(System.in);
            int node_value = input.nextInt();

            if (checkofnode[node_value - 2] == false) {
                System.out.println("The node before this node isn't created yet!! ");
            } else if (checkofnode[node_value - 1] == false) {
                if (checkofdeletednode[node_value - 1] == true) 
                {
                    checkofnode[node_value - 1] = true;
                    checkofdeletednode[node_value - 1] = false;
                    for (int i = 0; i < nodenumber; i++) {
                        adj_graph[i][node_value - 1] = 0;
                        adj_graph[node_value - 1][i] = 0;
                    }
                }
                else 
                {
                    nodenumber++;
                    checkofnode[node_value - 1] = true;
                }
            } else {
                System.out.println("this node is created before");
            }
        } catch (Exception e) {
            System.out.println("you must enter positive numbers for nodes!!!!!!!!");
        }
    }

    @Override
    public void popnode() {
        try {
            int deletednode;
            deletednode = input.nextInt();
            deletednode--;
            checkofnode[deletednode] = false;
            checkofdeletednode[deletednode] = true;
            for (int i = 0; i < nodenumber; i++) {
                adj_graph[i][deletednode] = -1;
                adj_graph[deletednode][i] = -1;
            }
        } catch (Exception e) {
            System.out.println("you must enter positive numbers for nodes!!!!!!!!");
        }
    }

}
