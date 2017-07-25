package io.github.satr.aws.lambda.shoppingbot;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

import static org.apache.http.util.TextUtils.isEmpty;

public class ShoppingBotLambda implements RequestHandler<Map<String, Object>, Object> {

    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {
        context.getLogger().log(input.toString());
        LexRequest lexRequest = LexRequestFactory.createLexRequest(input);
        return isEmpty(lexRequest.getAmount())
                ? createElicitRespond(lexRequest, "Amount", "How much would you like?")
                : createCloseRespond(lexRequest);
    }

    private LexRespond createCloseRespond(LexRequest lexRequest) {
        String content = String.format("Request came from the bot: %s, Department: %s;" +
                        "You ordered: %s %s of %s",
                lexRequest.getBotName(),
                lexRequest.getDepartmentName(),
                lexRequest.getAmount(),
                lexRequest.getUnit(),
                lexRequest.getProduct()
        );
        Message message = new Message("PlainText", content);
        DialogAction dialogAction = new CloseDialogAction("Close", "Fulfilled", message);
        return new LexRespond(dialogAction);
    }

    private LexRespond createElicitRespond(LexRequest lexRequest, String slotToElicit, String messageContent) {
        Message message = new Message("PlainText", messageContent);
        ElicitSlotDialogAction dialogAction = new ElicitSlotDialogAction(message);
        dialogAction.setIntentName(lexRequest.getIntentName());
        dialogAction.setSlotToElicit(slotToElicit);
        dialogAction.getSlots().put("Amount", lexRequest.getAmount());
        dialogAction.getSlots().put("BakeryProduct", lexRequest.getProduct());
        return new LexRespond(dialogAction);
    }

}
