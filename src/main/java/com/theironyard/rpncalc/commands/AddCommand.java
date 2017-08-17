package com.theironyard.rpncalc.commands;

import java.util.Stack;

public class AddCommand extends TwoArgumentCommand {
	
	public AddCommand(Stack<Double> numberStack) {
		super(numberStack);
	}

	@Override
	protected double doMaths() {
		return getSecondPopped() + getFirstPopped();
	}
	
	public void sendEmailAboutTheResult() {
		
	}
	
}













