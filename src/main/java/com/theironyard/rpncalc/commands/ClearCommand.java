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
//		int numberOfNumbers = numberStack.size();
		
		while (!numberStack.isEmpty()) {
			Double value = numberStack.pop();
			memory.push(value);
		}
//		for (int i = 0; i < numberOfNumbers; i += 1) {
//			Double value = numberStack.pop();
//			memory.push(value);
//		}
	}

	@Override
	public void undo() {
		int numberOfNumbersInMemory = memory.size();
		
		for (int i = 0; i < numberOfNumbersInMemory; i += 1) {
			Double value = memory.pop();
			numberStack.push(value);
		}
		
		
	}	
	
}












