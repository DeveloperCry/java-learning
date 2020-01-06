package learning.state;

import lombok.Getter;

@Getter
public class Context {
    private State state;

    private State draft = new DraftState(this);
    private State moderation = new ModerationState(this);
    private State published = new PublishedState(this);

    public void setState(State state) {
        this.state = state;
    }

    public void render() {
        this.state.render();
    }

    public void publish() {
        if (this.state.review()) {
            this.state.publish();
        }
    }
}
