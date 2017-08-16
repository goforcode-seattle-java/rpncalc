package com.theironyard.rpncalc.commands;

import java.util.Stack;

public class ClearCommand implements Undoable {

	private Stack<Double> numberStack;
	private Stack<Double> memory;

	public ClearCommand(Stack<Double> numberStack) {
		this.numberStack = numberStack;
		memory = new Stack<Double>();
	}
	
	public void execute() {
		numberStack.clear();
	}

	@Override
	public void undo() {
		
	}	
	
}
