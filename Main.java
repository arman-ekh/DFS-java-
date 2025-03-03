import java.util.*;
class GFG
{
    static Vector<Vector<Integer>> v = new Vector<Vector<Integer>>();

    static void addEdge(int x, int y){
        v.get(x).add(y);
        v.get(y).add(x);
        //2 way vector
    }

    static void printPath(Vector<Integer> stack)
    {
        for(int i = 0; i < stack.size() - 1; i++)
        {
            System.out.print(stack.get(i) + " -> ");
        }
        System.out.println(stack.get(stack.size() - 1));
    }

    static void DFS(boolean vis[], int x, int y, Vector<Integer> stack)
    {
        stack.add(x);
        if (x == y)
        {
            printPath(stack);
            return;
        }


        vis[x] = true;

        if (v.get(x).size() > 0)
        {
            for(int j = 0; j < v.get(x).size(); j++)
            {
                if (vis[v.get(x).get(j)] == false)// if the node is not visited
                {
                    DFS(vis, v.get(x).get(j), y, stack);
                }
            }
        }

        stack.remove(stack.size() - 1);
    }


    static void DFSCall(int x, int y, int n, Vector<Integer> stack) {

        boolean vis[] = new boolean[n + 1];
        Arrays.fill(vis, false);

        //this array is to prevent visiting a node twice

        DFS(vis, x, y, stack);
    }

    public static void main(String[] args)
    {
        for(int i = 0; i < 100; i++)
        {
            v.add(new Vector<Integer>());
        }

        int n = 20;
        Vector<Integer> stack = new Vector<Integer>();

        addEdge(1, 2);          //              1
        addEdge(1, 3);          //            /    \
        addEdge(2, 4);          //           2      3
        addEdge(2, 5);          //         / | \   / | \
        addEdge(2, 6);          //        4  5  6  7 8  9
        addEdge(3, 7);
        addEdge(3, 8);
        addEdge(3, 9);

        int start , goal ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your starting node: ");
        start = scanner.nextInt();
        System.out.println("please enter your goal node: ");
        goal = scanner.nextInt();



        DFSCall(start, goal, n, stack);
    }
}

