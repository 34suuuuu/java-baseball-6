package player;

import view.Input;

import static constants.MessageConstants.*;
import static constants.NumConstants.*;


public class Player {

    public Player(){}

    public String getInputString(){
        String inputString = Input.readInput();
        chkInputString(inputString);
        return inputString;
    }

    private void chkInputString(String inputString){
        if (inputString.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_LENGTH_ERROR_MESSAGE);
        }

        String tmp = "";
        for (char c : inputString.toCharArray()) {
            if (c <= '0' || c > '9') {
                throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_ONLY_INTEGER_ERROR_MESSAGE);
            }
            if (tmp.contains(String.valueOf(c))) {
                throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_SAME_NUMBER_ERROR_MESSAGE);
            }
            tmp += String.valueOf(c);
        }
    }

}
