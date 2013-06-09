import java.util.List;



public class SimulatorDefinitions {

	private List<String> states;
	private List<String> inputSymbols;
	private List<String> tapeSymbols;
	private String emptyCellSymbol;
	
	private List<String> tape;
	private List<String> acceptableStates;
	
	private String startingState;
	private int startingHeadPosition;
	
	private List<Transition> transitions;
	
	public List<String> getStates() {
		return states;
	}

	public void setStates(List<String> states) {
		this.states = states;
	}

	public List<String> getInputSymbols() {
		return inputSymbols;
	}

	public void setInputSymbols(List<String> inputSymbols) {
		this.inputSymbols = inputSymbols;
	}

	public List<String> getTapeSymbols() {
		return tapeSymbols;
	}

	public void setTapeSymbols(List<String> tapeSymbols) {
		this.tapeSymbols = tapeSymbols;
	}

	public String getEmptyCellSymbol() {
		return emptyCellSymbol;
	}

	public void setEmptyCellSymbol(String emptyCellSymbol) {
		this.emptyCellSymbol = emptyCellSymbol;
	}

	public List<String> getTape() {
		return tape;
	}

	public void setTape(List<String> tape) {
		this.tape = tape;
	}

	public List<String> getAcceptableStates() {
		return acceptableStates;
	}

	public void setAcceptableStates(List<String> acceptableStates) {
		this.acceptableStates = acceptableStates;
	}

	public String getStartingState() {
		return startingState;
	}

	public void setStartingState(String startingState) {
		this.startingState = startingState;
	}

	public int getStartingHeadPosition() {
		return startingHeadPosition;
	}

	public void setStartingHeadPosition(int startingHeadPosition) {
		this.startingHeadPosition = startingHeadPosition;
	}
	
	public List<Transition> getTransitions() {
		return transitions;
	}
	
	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public void print() {
		System.out.println("========================");
		System.out.println("States");
		for(String state : states) {
			System.out.println(state);
		}
		
		System.out.println("========================");
		System.out.println("Input Symbols");
		for(String state : inputSymbols) {
			System.out.println(state);
		}
		
		System.out.println("========================");
		System.out.println("Tape Symbols");
		for(String state : tapeSymbols) {
			System.out.println(state);
		}
		
		System.out.println("========================");
		System.out.println("Empty cell symbol");
		System.out.println(emptyCellSymbol);
		
		System.out.println("========================");
		System.out.println("Tape");
		for(String state : tape) {
			System.out.println(state);
		}
		
		System.out.println("========================");
		System.out.println("Acceptable states");
		for(String state : acceptableStates) {
			System.out.println(state);
		}
		
		System.out.println("========================");
		System.out.println("Starting state");
		System.out.println(startingState);
		
		System.out.println("========================");
		System.out.println("Starting head position");
		System.out.println(startingHeadPosition + "");
		
		System.out.println("========================");
		System.out.println("Transitions");
		for(Transition transition : transitions) {
			System.out.println(transition);
		}
	}
	
}
