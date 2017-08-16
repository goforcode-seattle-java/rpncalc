package com.theironyard.rpncalc.commands;

import java.util.Stack;

public class PushCommand implements Undoable {

	private Stack<Double> numberStack;
	private double valueToPush;

	public PushCommand(double valueToPush, Stack<Double> numberStack) {
		this.numberStack = numberStack;
		this.valueToPush = valueToPush;
	}
	
	public void execute() {
		numberStack.push(valueToPush);
	}

	@Override
	public void undo() {
		numberStack.pop();
	}	
	
}
