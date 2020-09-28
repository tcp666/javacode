package com.tcp.datafind.id3;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {

    private String nodeName;
    private Map<String,Attributes> attributes;
    private double gain;
    
    public double getGain() {
        return gain;
    }
    public void setGain(double gain) {
        this.gain = gain;
    }
    public String getNodeName() {
        
        return nodeName;
    }
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }
    public Map<String, Attributes> getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, Attributes> attributes) {
        
        this.attributes = attributes;
    }
    
    @Override
    public String toString() {
        return "TreeNode [nodeName=" + nodeName + ", attributes=" + attributes
                + ", gain=" + gain + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((attributes == null) ? 0 : attributes.hashCode());
        long temp;
        temp = Double.doubleToLongBits(gain);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result
                + ((nodeName == null) ? 0 : nodeName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TreeNode other = (TreeNode) obj;
        if (attributes == null) {
            if (other.attributes != null)
                return false;
        } else if (!attributes.equals(other.attributes))
            return false;
        if (Double.doubleToLongBits(gain) != Double
                .doubleToLongBits(other.gain))
            return false;
        if (nodeName == null) {
            if (other.nodeName != null)
                return false;
        } else if (!nodeName.equals(other.nodeName))
            return false;
        return true;
    }
    
    
    
    
}


