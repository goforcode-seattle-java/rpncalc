package com.theironyard.rpncalc.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.theironyard.rpncalc.commands.AddCommand;
import com.theironyard.rpncalc.commands.ClearCommand;
import com.theironyard.rpncalc.commands.DivideCommand;
import com.theironyard.rpncalc.commands.MultiplyCommand;
import com.theironyard.rpncalc.commands.NegateCommand;
import com.theironyard.rpncalc.commands.PushCommand;
import com.theironyard.rpncalc.commands.SubtractCommand;
import com.theironyard.rpncalc.commands.SwapCommand;
import com.theironyard.rpncalc.commands.TwoArgumentCommand;
import com.theironyard.rpncalc.commands.Undoable;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
	
	private Stack<Double> numberStack;
	private Stack<Undoable> commandHistory;
	
	public CalculatorController() {
		numberStack = new Stack<Double>();
		commandHistory = new Stack<Undoable>();
	}
	
	@PostMapping("operation/undo")
	public String undoTheLastCommand() {
		if (commandHistory.size() > 0) {
			Undoable command = commandHistory.pop();
			command.undo();
		}
		
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/swap")
	public String swapTheMostRecentNumbers() {
		SwapCommand command  = new SwapCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/negate")
	public String negateTheMostRecentNumber() {
		NegateCommand command  = new NegateCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/divide")
	public String divideTwoMostRecentNumbers() {
		DivideCommand command  = new DivideCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/add")
	public String addTwoMostRecentNumbers() {
		AddCommand command  = new AddCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/subtract")
	public String subtractTwoMostRecentNumbers() {
		SubtractCommand command  = new SubtractCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/multiply")
	public String multiplyTwoMostRecentNumbers() {
		MultiplyCommand command  = new MultiplyCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		
		return "redirect:/calculator";
	}
	
	@PostMapping("operation/clear")
	public String clearValues() {
		ClearCommand command = new ClearCommand(numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}

	@PostMapping("values")
	public String pushValueOntoStack(double theNumber) {
		PushCommand command = new PushCommand(theNumber, numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/calculator";
	}
	
	@GetMapping("")
	public String showDefaultPage(Model model) {
		model.addAttribute("stack", numberStack);
		model.addAttribute("canShowBinaryOperator", numberStack.size() > 1);
		model.addAttribute("canShowUnaryOperator", numberStack.size() > 0);
		model.addAttribute("undoSize", commandHistory.size());
		return "calculator/default";
	}
	
}







