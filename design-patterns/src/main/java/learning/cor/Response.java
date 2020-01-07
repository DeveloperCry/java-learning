package learning.cor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response {
    private String requestName;
    private float requestValue;
    private int levelId;
    private String LevelName;
    private String message;

    @Override
    public String toString() {
        return "当前请求 " + this.requestName +
                "(" + this.requestValue +
                ") 被级别 " + this.levelId +
                "(" + this.LevelName + ") " + message;
    }
}
