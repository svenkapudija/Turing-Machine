import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class SimTSInputReader {

	private List<String> states;
	private List<String> inputSymbols;
	private List<String> tapeSymbols;
	private String emptyCellSymbol;
	
	private List<String> tape;
	private List<String> acceptableStates;
	
	private String startingState;
	private int startingHeadPosition;
	
	private List<Transition> transitions;

	public void readInput(InputStream is) throws SimTSInputReaderException {
		List<String> inputLines = readInputLines(is);
		if(inputLines.size() < 8) {
			throw new SimTSInputReaderException();
		}

		states = new ArrayList<String>();
		inputSymbols = new ArrayList<String>();
		tapeSymbols = new ArrayList<String>();
		tape = new ArrayList<String>();
		acceptableStates = new ArrayList<String>();
		transitions = new ArrayList<Transition>();
		
		states.addAll(Arrays.asList(inputLines.get(0).split(",")));
		inputSymbols.addAll(Arrays.asList(inputLines.get(1).split(",")));
		tapeSymbols.addAll(Arrays.asList(inputLines.get(2).split(",")));
		emptyCellSymbol = inputLines.get(3).trim();
		
		String tapeString = inputLines.get(4);
		for (int i = 0; i < tapeString.length(); ++i) {
			tape.add(Character.toString(tapeString.charAt(i)));
		}
		
		acceptableStates.addAll(Arrays.asList(inputLines.get(5).split(",")));
		startingState = inputLines.get(6).trim();
		startingHeadPosition = Integer.parseInt(inputLines.get(7).trim());
		
		for(int i = 8; i < inputLines.size(); i++) {
			String transitionString = inputLines.get(i).trim();
			String[] parts = transitionString.split("->");
			
			String[] leftParts = parts[0].split(",");
			String[] rightParts = parts[1].split(",");
			
			Transition transition = new Transition();
			transition.setCurrentState(leftParts[0]);
			transition.setCurrentTapeSymbol(leftParts[1]);			
			transition.setNewState(rightParts[0]);
			transition.setNewTapeSymbol(rightParts[1]);
			transition.setHeadMovement(rightParts[2]);
			
			transitions.add(transition);
		}
	}
	
	private List<String> readInputLines(InputStream is) {
		Scanner s = new Scanner(is);
		List<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();

		return list;
	}
	
	public SimulatorDefinitions generateSimulatorDefinitions() {
		SimulatorDefinitions definitions = new SimulatorDefinitions();
		
		definitions.setStates(states);
		definitions.setInputSymbols(inputSymbols);
		definitions.setTapeSymbols(tapeSymbols);
		definitions.setEmptyCellSymbol(emptyCellSymbol);
		definitions.setTape(tape);
		definitions.setAcceptableStates(acceptableStates);
		definitions.setStartingState(startingState);
		definitions.setStartingHeadPosition(startingHeadPosition);
		definitions.setTransitions(transitions);
		
		return definitions;
	}

}
