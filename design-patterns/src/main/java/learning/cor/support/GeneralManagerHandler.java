package learning.cor.support;

import learning.cor.*;

public class GeneralManagerHandler extends Handler {
    public GeneralManagerHandler(Level level) {
        super(level);
    }

    @Override
    public Response approve(Request request) {
        Response response = null;
        if (request.getValue() >= 1000000 && request.getValue() < 10000000) {
            response = new Response(request.getName(), request.getValue(), super.level.getId(), super.level.getName(), ApproveMessageType.APPROVED.getMessage());
        } else if (request.getValue() >= 10000000){
            response = new Response(request.getName(), request.getValue(), super.level.getId(), super.level.getName(), ApproveMessageType.REJECT.getMessage());
        } else if (super.nextHandler != null) {
            response = super.nextHandler.approve(request);
        }
        return response;
    }
}
