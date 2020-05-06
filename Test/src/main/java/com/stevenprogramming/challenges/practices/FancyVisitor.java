package com.stevenprogramming.challenges.practices;

public class FancyVisitor extends TreeVis {
    int result =0;
    int greenSum = 0;
    public int getResult() {
        return Math.abs(result-greenSum);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth() == 0){
            result+= result + node.getValue();
        } else if(node.getDepth() % 2 == 0){
            result = result + node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {

        if(leaf.getColor().equals(Color.GREEN)){
            greenSum = greenSum + leaf.getValue();
        }
    }
}
