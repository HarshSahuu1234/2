import java.io.*;
import java.util.*;

public class NFA {

    // NFA simulation using set of states
    public static boolean isEvenA(String str) {

        // States: 0 = q0 (even), 1 = q1 (odd)
        Set<Integer> currentStates = new HashSet<>();
        currentStates.add(0); // start state

        for (char ch : str.toCharArray()) {
            Set<Integer> nextStates = new HashSet<>();

            for (int state : currentStates) {

                if (state == 0) {
                    if (ch == 'a') nextStates.add(1);
                    else nextStates.add(0);
                }

                else if (state == 1) {
                    if (ch == 'a') nextStates.add(0);
                    else nextStates.add(1);
                }
            }

            currentStates = nextStates;
        }

        // Accept if q0 (0) is in final states
        return currentStates.contains(0);
    }

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                boolean result = isEvenA(line);

                if (result)
                    System.out.println(line + " -> Even number of a's (Accepted)");
                else
                    System.out.println(line + " -> Odd number of a's (Rejected)");
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
