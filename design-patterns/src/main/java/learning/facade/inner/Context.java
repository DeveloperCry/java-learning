package learning.facade.inner;

public class Context {
    private Project project = new Project();
    private TechnicalDivision technicalDivision = new TechnicalDivision();

    public void doContext() {
        this.project.project();
        this.technicalDivision.maintain();
    }
}
