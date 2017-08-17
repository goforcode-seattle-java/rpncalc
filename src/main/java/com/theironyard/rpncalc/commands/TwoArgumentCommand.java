package com.theironyard.rpncalc.commands;

import java.util.Stack;

public abstract class TwoArgumentCommand implements Undoable {

	private Stack<Double> numberStack;
	private double firstPopped;
	private double secondPopped;
	
	public TwoArgumentCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
	}
	
	public void execute() {
		firstPopped = numberStack.pop();
		secondPopped  = numberStack.pop();
		double result = doMaths();
		numberStack.push(result);
	}
	
	protected abstract double doMaths();
	
	@Override
	public void undo() {
		numberStack.pop();
		numberStack.push(secondPopped);
		numberStack.push(firstPopped);
	}

	protected double getFirstPopped() {
		return firstPopped;
	}

	protected double getSecondPopped() {
		return secondPopped;
	}	
	
}









