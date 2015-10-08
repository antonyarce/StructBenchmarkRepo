/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author cristhian
 */
public class SLLNode {
    
    private int node;
        private SLLNode succ;
        SLLNode(int second,SLLNode succ){
            this.node=second;
            this.succ=succ;
        }

    public SLLNode getSucc() {
        return succ;
    }

    public void setSucc(SLLNode succ) {
        this.succ = succ;
    }

    /**
     * @return the node
     */
    public int getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(int node) {
        this.node = node;
    }
    
    
}
