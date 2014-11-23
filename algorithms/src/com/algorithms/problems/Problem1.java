package com.algorithms.problems;

import java.util.Stack;

public class Problem1 {

// Problem -  Find duplicate paranthasis in a expression
	public static void main(String[] args) {
		String s= "(a+((b+c))+d)";
		findDuplicateparenthesis(s);

	}
	
	public static void findDuplicateparenthesis(String input)
    {
        Stack<Character> inputStack = new Stack<Character>();
        for(char inputChar : input.toCharArray())
        {
            if (inputChar != ')')
            {
                inputStack.push(inputChar);
            }
            else
            {
                char popChar = inputStack.pop();
                if (popChar == '(')
                   {
                	System.out.println("Duplicate Find ");
                	return;
                	}
                else
                {
                    while (popChar != '(')
                    {
                        popChar = inputStack.pop();
                    }
                }
            }
        }
        System.out.println("no duplicate");
    }

}
