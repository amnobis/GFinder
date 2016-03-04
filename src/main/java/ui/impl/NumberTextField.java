package ui.impl;

import javafx.scene.control.TextField;

/**
 * 3/3/16
 *
 * @author {anobis}
 */
public class NumberTextField extends TextField
{

    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text) {
        if (validate(text)) {
            super.replaceSelection(text);
        }
    }

    private boolean validate(String text)
    {
        return text.matches("[0-9]*");
    }
}
