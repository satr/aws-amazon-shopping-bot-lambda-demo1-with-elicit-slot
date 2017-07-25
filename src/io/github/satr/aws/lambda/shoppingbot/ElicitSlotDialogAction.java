package io.github.satr.aws.lambda.shoppingbot;
// Copyright © 2017, github.com/satr, MIT License

import java.util.LinkedHashMap;
import java.util.Map;

public class ElicitSlotDialogAction extends DialogAction {
    private String intentName;
    private Map<String, Object> slots = new LinkedHashMap<>();
    private String slotToElicit;

    public ElicitSlotDialogAction(Message message) {
        super("ElicitSlot", message);

    }

    public void setIntentName(String intentName) {
        this.intentName = intentName;
    }

    public String getIntentName() {
        return intentName;
    }

    public Map<String, Object> getSlots() {
        return slots;
    }

    public void setSlotToElicit(String slotToElicit) {
        this.slotToElicit = slotToElicit;
    }

    public String getSlotToElicit() {
        return slotToElicit;
    }
}
