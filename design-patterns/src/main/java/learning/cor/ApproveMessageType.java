package learning.cor;

import lombok.Getter;

@Getter
public enum ApproveMessageType {
    APPROVED("审批通过"),
    REJECT("审批未通过");

    private String message;

    ApproveMessageType(String message) {
        this.message = message;
    }
}
