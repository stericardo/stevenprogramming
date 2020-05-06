package com.stevenprogramming.challenges.practices;

public class ProductOfRedNodesVisitor extends TreeVis {
    long result =1;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {

        if(node.getColor().equals(Color.RED)){

            result = (result * node.getValue()) % 1000000007;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor().equals(Color.RED)){
            result = (result * leaf.getValue()) % 1000000007 ;
        }
    }
}
