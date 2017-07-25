package io.github.satr.aws.lambda.shoppingbot;

public class DialogAction {
    private final String type;
    private final Message message;

    public DialogAction(String type, Message message) {

        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public Message getMessage() {
        return message;
    }

}
