package learning.mediator;

import lombok.Getter;

@Getter
public enum  OptionType {
    OPEN("open"),
    CLOSE("close"),
    ALARM("alarm"),
    ACCEPT_VIDEO("acceptVideo"),
    ACCEPT_MESSAGE("acceptMessage"),
    SHOOT("shoot");

    private String option;

    OptionType(String option) {
        this.option = option;
    }
}
