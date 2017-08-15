package com.theironyard.rpncalc.commands;

import java.util.Stack;

public class AddCommand implements Undoable {
	
	private Stack<Double> numberStack;
	private double firstPopped;
	private double secondPopped;

	public AddCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
	}
	
	public void execute() {
		firstPopped = numberStack.pop();
		secondPopped  = numberStack.pop();
		double result = firstPopped + secondPopped;
		numberStack.push(result);
	}

	public void undo() {
		numberStack.pop();
		numberStack.push(secondPopped);
		numberStack.push(firstPopped);
	}
	
}













