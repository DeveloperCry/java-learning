package learning.visitor;

import lombok.Getter;

@Getter
public enum VisitorType {
    POOR_MAN("穷人"),
    MIDDLE_CLASS("中产阶级"),
    RICH_MAN("富人");

    private String label;

    VisitorType(String label) {
        this.label = label;
    }
}
