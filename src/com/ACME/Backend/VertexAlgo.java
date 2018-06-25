package com.ACME.Backend;
import java.util.ArrayList;

public class VertexAlgo {

    private ArrayList<EdgeAlgo> neighborhood;
    private String label;
    
    public VertexAlgo(String label){
        this.label = label;
        this.neighborhood = new ArrayList<EdgeAlgo>();
    }
    
    public void addNeighbor(EdgeAlgo edge){
        if(this.neighborhood.contains(edge)){
            return;
        }
        
        this.neighborhood.add(edge);
    }
    
    public boolean containsNeighbor(EdgeAlgo other){
        return this.neighborhood.contains(other);
    }
    
    public EdgeAlgo getNeighbor(int index){
        return this.neighborhood.get(index);
    }
    
    EdgeAlgo removeNeighbor(int index){
        return this.neighborhood.remove(index);
    }
    
    public void removeNeighbor(EdgeAlgo e){
        this.neighborhood.remove(e);
    }
    
    public int getNeighborCount(){
        return this.neighborhood.size();
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public String toString(){
        return "I" + label;        
    }
    
    public int hashCode(){
        return this.label.hashCode();
    }
    
    public boolean equals(Object other){
        if(!(other instanceof VertexAlgo)){
            return false;
        }
        
        VertexAlgo v = (VertexAlgo)other;
        return this.label.equals(v.label);
    }
    
    public ArrayList<EdgeAlgo> getNeighbors(){
        return new ArrayList<EdgeAlgo>(this.neighborhood);
    }
    
}
