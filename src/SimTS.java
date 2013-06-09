import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class SimTS {

	private final static boolean DEBUG = true;

	public static void main(String[] args) {
		if(DEBUG) {
			simPa("sampleInput.txt");			
		} else {
			simPa(System.in);
		}
	}

	public static void simPa(String fileName) {
		try {
			simPa(new FileInputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void simPa(InputStream is) {
		SimTSInputReader inputReader = new SimTSInputReader();
		try {
			inputReader.readInput(is);
		} catch (SimTSInputReaderException e) {
			return;
		}

		SimulatorDefinitions simulatorDefinitions = inputReader.generateSimulatorDefinitions();

		if(DEBUG) {
			simulatorDefinitions.print();
			System.out.println();
		}

		long start = System.currentTimeMillis();

		Simulator simulator = new Simulator(simulatorDefinitions);
		simulator.run();

		if(DEBUG) {
			System.out.println();
			System.out.println((System.currentTimeMillis()-start)/1000.0);
		}
	}
	
}
