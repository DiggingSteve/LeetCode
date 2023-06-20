import java.util.*;

public class Graph {
    public Graph(Vertex[] v){
        this.vertices=v;
        int n=v.length;
        adj=new int[n][n];

    }
    // 顶点
    public Vertex[] vertices;




    public int edges;
    //邻接表
    public int[][]adj;

    public void addEdge(Vertex v,Vertex w){
        this.adj[v.index][w.index]=1;
        this.adj[w.index][v.index]=1;

        edges++;
    }

    public void showGraph(){
        for(int i=0;i<this.vertices.length;i++){
            System.out.print(i+"->");
            for(int j=0;j<this.vertices.length;j++){
                if(this.adj[i][j]>0) {
                    System.out.print(j + "  ");
                }


            }
            System.out.println("");
        }
    }
    //v起始遍历顶点
    public void dfs(Vertex v){
        boolean[] marked=new boolean[this.vertices.length];
       d(v,marked);
    }
    private void d(Vertex v,boolean[] marked){
        marked[v.index]=true;
        if(this.adj[v.index].length>0){
            System.out.println("Visited -> "+v.index);
        }
        for (int i=0;i<this.adj[v.index].length;i++){
            boolean isConnect=this.adj[v.index][i]>0;
            if(isConnect && marked[i]==false){
                d(this.vertices[i],marked);
            }
        }
    }

    // bfs寻找最短路径 只适合权值为1或者没有权值的边
    public void bfsFindPath(Vertex start,Vertex end){
       boolean[] marked=new boolean[this.vertices.length];
        Dictionary<Integer,Vertex> parentMap=new Hashtable<>();
        Queue<Vertex>queue=new LinkedList<>();
        Boolean isFind=false;
        queue.add(start);
        while (!queue.isEmpty()){
            Vertex c=queue.poll();
            if(c==null)continue;
            //System.out.println("Visited-> "+c.index);
            marked[c.index]=true;
            for(int i=0;i<this.adj[c.index].length;i++){
                boolean isConnect=this.adj[c.index][i]>0;
                if(isConnect&&marked[i]==false){
                    parentMap.put(this.vertices[i].index,c);//记录父节点
                    queue.add(this.vertices[i]);
                    if(end.index==this.vertices[i].index){
                        isFind=true;
                        break;
                    }
                }
            }
          if(isFind){  break;}
        }
        Stack<Vertex> path=new Stack<>();
        Vertex current=parentMap.get(end.index);;
        while (current.index!= start.index){
            path.add(current);
            current=parentMap.get(current.index);

        }
        path.add(start);
        while (!path.isEmpty()){
            System.out.print(path.pop().index);
            System.out.print("->");
        }
        System.out.println(end.index);
    }

}
