package com.skellas.dsa.graph;

public class WeightedGraphNode extends GraphNode implements Node {
    private int weight;

    public WeightedGraphNode(int vertexId, int weight) {
        super(vertexId);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Integer getWeightedEdge(int v2) {
        WeightedGraphNode transientNode = this;
        while(null != transientNode.getNext()) {
            transientNode = (WeightedGraphNode)transientNode.getNext();
            if (transientNode.getVertexId() == v2)
                return transientNode.getWeight();
        }
        return null;
    }

}
