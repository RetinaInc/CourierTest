package com.ACME.Backend;

public class EdgeAlgo implements Comparable<EdgeAlgo> {

    private VertexAlgo one, two;
    private int weight;
    
    public EdgeAlgo(VertexAlgo one, VertexAlgo two){
        this(one, two, 1);
    }
    
    public EdgeAlgo(VertexAlgo one, VertexAlgo two, int weight){
        this.one = (one.getLabel().compareTo(two.getLabel()) <= 0) ? one : two;
        this.two = (this.one == one) ? two : one;
        this.weight = weight;
    }
    
    public VertexAlgo getNeighbor(VertexAlgo current){
        if(!(current.equals(one) || current.equals(two))){
            return null;
        }
        
        return (current.equals(one)) ? two : one;
    }
    
    public VertexAlgo getOne(){
        return this.one;
    }
    
    public VertexAlgo getTwo(){
        return this.two;
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    public int compareTo(EdgeAlgo other){
        return this.weight - other.weight;
    }
    
    public String toString(){
        return "({" + one + ", " + two + "}, " + weight + ")";
    }
    
    public int hashCode(){
        return (one.getLabel() + two.getLabel()).hashCode(); 
    }
    
    public boolean equals(Object other){
        if(!(other instanceof EdgeAlgo)){
            return false;
        }
        
        EdgeAlgo e = (EdgeAlgo)other;
        
        return e.one.equals(this.one) && e.two.equals(this.two);
    }   
}
