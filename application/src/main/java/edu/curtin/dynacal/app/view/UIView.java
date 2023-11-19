package edu.curtin.dynacal.app.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UIView {
    private final Map<String, String> navigation;
    public UIView() {
        navigation = new HashMap<>();
        navigation.put("+d", "Move Forwards a Day.");
        navigation.put("+w", "Move Forwards a Week.");
        navigation.put("+m", "Move Forwards a Month.");
        navigation.put("+y", "Move Forwards an Year.");
        navigation.put("-d", "Move Backwards a Day.");
        navigation.put("-w", "Move Backwards a Week.");
        navigation.put("-m", "Move Backwards a Month.");
        navigation.put("-y", "Move Backwards an Year.");
        navigation.put("t", "Move to Today.");
        navigation.put("quit", "Quit");
    }

    public void move(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (navigation.containsKey(input)) {
            String location = navigation.get(input);
            System.out.println(location);
        }
        else {
            System.out.println("Not a valid input.");
        }
    }
}
