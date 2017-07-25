package io.github.satr.aws.lambda.shoppingbot;
// Copyright © 2017, github.com/satr, MIT License

public class CloseDialogAction extends DialogAction {
    private final String fulfillmentState;

    public CloseDialogAction(String type, String fulfillmentState, Message message) {
        super(type, message);
        this.fulfillmentState = fulfillmentState;
    }

    public String getFulfillmentState() {
        return fulfillmentState;
    }
}
