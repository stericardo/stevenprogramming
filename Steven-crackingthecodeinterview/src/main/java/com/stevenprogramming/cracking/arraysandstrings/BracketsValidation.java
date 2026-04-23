package com.stevenprogramming.cracking.arraysandstrings;

import java.io.*;
import java.util.*;

/**
 *
 * //A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 *
 * //Two brackets are considered to be a matched pair if an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
 *
 *
 * //A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[]()} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 *
 * //By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 *
 * //It contains no unmatched brackets.
 * //The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 * //Given a strings of brackets, determine whether the sequence of brackets is balanced. If it is balanced, return YES. Otherwise, return NO.
 *
 * // Example
 * // Positive results.
 * // {([])}
 * // {}[][()]{([])}
 * // Negative results.
 * // {{([])}
 * // {{[[])}}

 */
public class BracketsValidation {

    public boolean isBalanced(String sequence){
        Stack<Character> sequenceStack = new Stack<>();
        for(int idx =0; idx < sequence.length(); idx++){
            if(sequence.charAt(idx) == '{' || sequence.charAt(idx) == '[' || sequence.charAt(idx) == '('){
                sequenceStack.push(sequence.charAt(idx));
            } else if(sequence.charAt(idx) == '}' || sequence.charAt(idx) == ']' || sequence.charAt(idx) == ')'){
                char topChar = sequenceStack.peek();
                if(topChar == '{' && sequence.charAt(idx) != '}'){
                    return false;
                } else if(topChar == '[' && sequence.charAt(idx) != ']'){
                    return false;
                } else if(topChar == '(' && sequence.charAt(idx) != ')'){
                    return false;
                }
                sequenceStack.pop();
            }
        }

        return sequenceStack.isEmpty();
    }

    public static void main(String[] args) {
        BracketsValidation solution = new BracketsValidation();
        System.out.println("{[]()} > " + solution.isBalanced("{[]()}"));
        System.out.println("{([])} > " + solution.isBalanced("{([])}"));
        System.out.println("{}[][()]{([])} > " + solution.isBalanced("{}[][()]{([])}"));
        System.out.println("{{[[])}} > " + solution.isBalanced("{{[[])}}"));
        System.out.println("{{([])} > " + solution.isBalanced("{{([])}"));
    }
}
