package learning.cor.support;

import learning.cor.*;

public class ViceGeneralManagerHandler extends Handler {
    public ViceGeneralManagerHandler(Level level) {
        super(level);
    }

    @Override
    public Response approve(Request request) {
        Response response = null;
        if (request.getValue() >= 100000 && request.getValue() < 1000000) {
            response = new Response(request.getName(), request.getValue(), super.level.getId(), super.level.getName(), ApproveMessageType.APPROVED.getMessage());
        } else if (super.nextHandler != null) {
            response = super.nextHandler.approve(request);
        }
        return response;
    }
}
