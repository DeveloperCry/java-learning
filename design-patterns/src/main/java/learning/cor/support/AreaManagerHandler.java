package learning.cor.support;

import learning.cor.*;

public class AreaManagerHandler extends Handler {
    public AreaManagerHandler(Level level) {
        super(level);
    }

    @Override
    public Response approve(Request request) {
        Response response = null;
        if (request.getValue() >= 10000 && request.getValue() < 100000) {
            response = new Response(request.getName(), request.getValue(), super.level.getId(), super.level.getName(), ApproveMessageType.APPROVED.getMessage());
        } else if (super.nextHandler != null) {
            response = super.nextHandler.approve(request);
        }
        return response;
    }
}
