import java.util.List;

public class Simulator {

	private SimulatorDefinitions definitions;
	
	public Simulator(SimulatorDefinitions definitions) {
		this.definitions = definitions;
	}
	
	public void run() {
		List<String> tape = definitions.getTape();
		String state = definitions.getStartingState();
		int position = definitions.getStartingHeadPosition();
		
		while (true) {
			Transition transition = getNextTransition(state, tape.get(position));
			if (transition == null) {
				break;
			}
			
			if (position == 0 && transition.getHeadMovement().equals("L")) {
				break;
			}
			
			if (position == 69 && transition.getHeadMovement().equals("R")) {
				break;
			}
			
			tape.set(position, transition.getNewTapeSymbol());
			state = transition.getNewState();
			
			if (transition.getHeadMovement().equals("L")) {
				position--;
			} else {
				position++;
			}
		}
		
		// Print out the result
		boolean isInAcceptableState = definitions.getAcceptableStates().contains(state);
		String result = state + "|" + position + "|";
		for (int i = 0; i < tape.size(); ++i) {
			result += tape.get(i);
		}
		result += "|" + (isInAcceptableState ? "1" : "0");

		System.out.println(result);
	}
	
	private Transition getNextTransition(String state, String tapeSymbol) {
		List<Transition> transitions = definitions.getTransitions();
		
		for(Transition transition : transitions) {
			if(transition.getCurrentState().equals(state) && transition.getCurrentTapeSymbol().equals(tapeSymbol)) {
				return transition;
			}
		}
		
		return null;
	}
	
}