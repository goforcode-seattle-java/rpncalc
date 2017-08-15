package com.theironyard.rpncalc.commands;

import java.util.Stack;

public class NegateCommand implements Undoable {

	private Stack<Double> numberStack;
	private double valuePopped;
	
	public NegateCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
	}
	
	public void execute() {
		valuePopped = numberStack.pop();
		
		if (valuePopped != 0.0) {
			double result = -1 * valuePopped;
			numberStack.push(result);
		} else {
			numberStack.push(valuePopped);
		}
		
	}
	
	public void undo() {
		numberStack.pop();
		numberStack.push(valuePopped);
	}
	
}















