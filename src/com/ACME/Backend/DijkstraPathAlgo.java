package com.ACME.Backend;
import java.util.*;

public class DijkstraPathAlgo {
    private GraphAlgo graph;
    private String initialVertexLabel;
    private HashMap<String, String> predecessors;
    private HashMap<String, Integer> distances;
    private PriorityQueue<VertexAlgo> availableVertices;
    private HashSet<VertexAlgo> visitedVertices;

    public DijkstraPathAlgo(int vertici, int weight){
    	 GraphAlgo graph = new GraphAlgo();
         VertexAlgo[] vertices = new VertexAlgo[49];
         for(int i = 0; i < vertices.length; i++){
             vertices[i] = new VertexAlgo(i + "");
             graph.addVertex(vertices[i], true);
         }
         EdgeAlgo[] route = new EdgeAlgo[78];
         route[0] = new EdgeAlgo(vertices[0], vertices[7], weight);
         route[1] = new EdgeAlgo(vertices[3], vertices[10], weight);
         route[2] = new EdgeAlgo(vertices[3], vertices[2], weight);
         route[3] = new EdgeAlgo(vertices[7], vertices[8], weight);
         route[4] = new EdgeAlgo(vertices[7], vertices[14], weight);
         route[5] = new EdgeAlgo(vertices[8], vertices[1], weight);
         route[6] = new EdgeAlgo(vertices[8], vertices[7], weight);
         route[7] = new EdgeAlgo(vertices[8], vertices[9], weight);
         route[8] = new EdgeAlgo(vertices[9], vertices[8], weight);
         route[9] = new EdgeAlgo(vertices[9], vertices[10], weight);
         route[10] = new EdgeAlgo(vertices[9], vertices[16], weight);
         route[11] = new EdgeAlgo(vertices[10], vertices[9], weight);
         route[12] = new EdgeAlgo(vertices[10], vertices[11], weight);
         route[13] = new EdgeAlgo(vertices[10], vertices[3], weight);
         route[14] = new EdgeAlgo(vertices[10], vertices[17], weight);
         route[15] = new EdgeAlgo(vertices[11], vertices[10], weight);
         route[16] = new EdgeAlgo(vertices[11], vertices[12], weight);
         route[17] = new EdgeAlgo(vertices[11], vertices[18], weight);
         route[18] = new EdgeAlgo(vertices[12], vertices[13], weight);
         route[19] = new EdgeAlgo(vertices[12], vertices[11], weight);
         route[20] = new EdgeAlgo(vertices[12], vertices[5], weight);
         route[21] = new EdgeAlgo(vertices[13], vertices[12], weight);
         route[22] = new EdgeAlgo(vertices[13], vertices[20], weight);
         
         route[23] = new EdgeAlgo(vertices[14], vertices[21], weight);
         route[24] = new EdgeAlgo(vertices[15], vertices[22], weight);
         route[25] = new EdgeAlgo(vertices[16], vertices[23], weight);
         route[26] = new EdgeAlgo(vertices[17], vertices[10], weight);
         route[27] = new EdgeAlgo(vertices[17], vertices[24], weight);
         route[28] = new EdgeAlgo(vertices[18], vertices[25], weight);
         route[29] = new EdgeAlgo(vertices[19], vertices[26], weight);
         route[30] = new EdgeAlgo(vertices[20], vertices[27], weight);
         
         route[31] = new EdgeAlgo(vertices[21], vertices[28], weight);
         route[32] = new EdgeAlgo(vertices[21], vertices[22], weight);
         route[33] = new EdgeAlgo(vertices[22], vertices[23], weight);
         route[34] = new EdgeAlgo(vertices[23], vertices[24], weight);
         route[35] = new EdgeAlgo(vertices[23], vertices[30], weight);
         route[36] = new EdgeAlgo(vertices[24], vertices[25], weight);
         route[37] = new EdgeAlgo(vertices[24], vertices[31], weight);
         route[38] = new EdgeAlgo(vertices[24], vertices[17], weight);
         route[39] = new EdgeAlgo(vertices[25], vertices[26], weight);
         route[40] = new EdgeAlgo(vertices[25], vertices[32], weight);
         route[41] = new EdgeAlgo(vertices[26], vertices[27], weight);
         route[42] = new EdgeAlgo(vertices[27], vertices[34], weight);
         
         route[43] = new EdgeAlgo(vertices[28], vertices[35], weight);
         route[44] = new EdgeAlgo(vertices[29], vertices[36], weight);
         route[45] = new EdgeAlgo(vertices[30], vertices[37], weight);
         route[46] = new EdgeAlgo(vertices[31], vertices[24], weight);
         route[47] = new EdgeAlgo(vertices[31], vertices[38], weight);
         route[48] = new EdgeAlgo(vertices[32], vertices[39], weight);
         route[49] = new EdgeAlgo(vertices[33], vertices[40], weight);
         route[50] = new EdgeAlgo(vertices[34], vertices[41], weight);
         
         route[51] = new EdgeAlgo(vertices[5], vertices[4], weight);
         route[52] = new EdgeAlgo(vertices[30], vertices[29], weight);
         route[53] = new EdgeAlgo(vertices[32], vertices[31], weight);
         route[54] = new EdgeAlgo(vertices[34], vertices[33], weight);
         route[55] = new EdgeAlgo(vertices[16], vertices[15], weight);
         route[57] = new EdgeAlgo(vertices[20], vertices[19], weight);
         
         route[58] = new EdgeAlgo(vertices[35], vertices[42], weight);
         route[56] = new EdgeAlgo(vertices[35], vertices[36], weight);
         route[59] = new EdgeAlgo(vertices[36], vertices[35], weight);
         route[60] = new EdgeAlgo(vertices[36], vertices[37], weight);
         route[61] = new EdgeAlgo(vertices[37], vertices[38], weight);
         route[62] = new EdgeAlgo(vertices[37], vertices[36], weight);
         route[63] = new EdgeAlgo(vertices[37], vertices[44], weight);
         route[64] = new EdgeAlgo(vertices[38], vertices[31], weight);
         route[65] = new EdgeAlgo(vertices[38], vertices[45], weight);
         route[66] = new EdgeAlgo(vertices[38], vertices[37], weight);
         route[67] = new EdgeAlgo(vertices[38], vertices[39], weight);
         route[68] = new EdgeAlgo(vertices[39], vertices[40], weight);
         route[69] = new EdgeAlgo(vertices[39], vertices[38], weight);
         route[70] = new EdgeAlgo(vertices[39], vertices[46], weight);
         route[71] = new EdgeAlgo(vertices[40], vertices[41], weight);
         route[72] = new EdgeAlgo(vertices[40], vertices[39], weight);
         route[73] = new EdgeAlgo(vertices[41], vertices[40], weight);
         route[74] = new EdgeAlgo(vertices[41], vertices[48], weight);
         
         route[75] = new EdgeAlgo(vertices[44], vertices[43], weight);
         route[76] = new EdgeAlgo(vertices[46], vertices[45], weight);
         route[77] = new EdgeAlgo(vertices[48], vertices[47], weight);
         
         for(EdgeAlgo e: route){
             graph.addEdge(e.getOne(), e.getTwo(), e.getWeight());
         }
        String initialVertexLabel = vertices[vertici].getLabel();
        this.graph = graph;
        Set<String> vertexKeys = this.graph.vertexKeys();
        if(!vertexKeys.contains(initialVertexLabel)){
            throw new IllegalArgumentException("The graph must contain the initial vertex.");
        }
        this.initialVertexLabel = initialVertexLabel;
        this.predecessors = new HashMap<String, String>();
        this.distances = new HashMap<String, Integer>();
        this.availableVertices = new PriorityQueue<VertexAlgo>(vertexKeys.size(), new Comparator<VertexAlgo>(){
            public int compare(VertexAlgo one, VertexAlgo two){
                int weightOne = DijkstraPathAlgo.this.distances.get(one.getLabel());
                int weightTwo = DijkstraPathAlgo.this.distances.get(two.getLabel());
                return weightOne - weightTwo;
            }
        });
        this.visitedVertices = new HashSet<VertexAlgo>();
        for(String key: vertexKeys){
            this.predecessors.put(key, null);
            this.distances.put(key, Integer.MAX_VALUE);
        }
        this.distances.put(initialVertexLabel, 0);
        VertexAlgo initialVertex = this.graph.getVertex(initialVertexLabel);
        ArrayList<EdgeAlgo> initialVertexNeighbors = initialVertex.getNeighbors();
        for(EdgeAlgo e : initialVertexNeighbors){
            VertexAlgo other = e.getNeighbor(initialVertex);
            this.predecessors.put(other.getLabel(), initialVertexLabel);
            this.distances.put(other.getLabel(), e.getWeight());
            this.availableVertices.add(other);
        }
        this.visitedVertices.add(initialVertex);
        processGraph();
    }
    private void processGraph(){
        while(this.availableVertices.size() > 0){
            VertexAlgo next = this.availableVertices.poll();
            int distanceToNext = this.distances.get(next.getLabel());
            List<EdgeAlgo> nextNeighbors = next.getNeighbors();
            for(EdgeAlgo e: nextNeighbors){
                VertexAlgo other = e.getNeighbor(next);
                if(this.visitedVertices.contains(other)){
                    continue;
                }
                int currentWeight = this.distances.get(other.getLabel());
                int newWeight = distanceToNext + e.getWeight();
                if(newWeight < currentWeight){
                    this.predecessors.put(other.getLabel(), next.getLabel());
                    this.distances.put(other.getLabel(), newWeight);
                    this.availableVertices.remove(other);
                    this.availableVertices.add(other);
                }
            }
            this.visitedVertices.add(next);
        }
    }
    public List<VertexAlgo> getPathTo(String destinationLabel){
        LinkedList<VertexAlgo> path = new LinkedList<VertexAlgo>();
        path.add(graph.getVertex(destinationLabel));
        while(!destinationLabel.equals(this.initialVertexLabel)){
            VertexAlgo predecessor = graph.getVertex(this.predecessors.get(destinationLabel));
            destinationLabel = predecessor.getLabel();
            path.add(0, predecessor);
        }
        return path;
    }
    public int getDistanceTo(String destinationLabel){
        return this.distances.get(destinationLabel);
    }
    
	public static void main(String[] args){
		String p="I20";
        DijkstraPathAlgo dijkstra = new DijkstraPathAlgo(Integer.parseInt(p.replace("I", "")),1);
        System.out.println(dijkstra.getDistanceTo("6"));
        System.out.println(dijkstra.getPathTo("6"));
        
        
    }
}
