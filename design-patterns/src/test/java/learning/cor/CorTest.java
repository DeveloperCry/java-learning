package learning.cor;

import learning.cor.support.*;
import org.junit.Test;

public class CorTest {
    @Test
    public void testCor() {
        Level leader = new Level(1, "组长");
        Level projectManager = new Level(2, "项目经理");
        Level areaManager = new Level(3, "区域经理");
        Level viceGeneralManager = new Level(4, "副总经理");
        Level generalManager = new Level(5, "总经理");

        Handler leaderHandler = new LeaderHandler(leader);
        Handler projectManagerHandler = new ProjectManagerHandler(projectManager);
        Handler areaManagerHandler = new AreaManagerHandler(areaManager);
        Handler viceGeneralManagerHandler = new ViceGeneralManagerHandler(viceGeneralManager);
        Handler generalManagerHandler = new GeneralManagerHandler(generalManager);

        leaderHandler.setNextHandler(projectManagerHandler);
        projectManagerHandler.setNextHandler(areaManagerHandler);
        areaManagerHandler.setNextHandler(viceGeneralManagerHandler);
        viceGeneralManagerHandler.setNextHandler(generalManagerHandler);
        generalManagerHandler.setNextHandler(leaderHandler);

        Request request = new Request("活动报销", 200f);

        Response response = leaderHandler.approve(request);
        System.out.println(response.toString());

        request = new Request("采购报销", 2000000f);

        response = leaderHandler.approve(request);
        System.out.println(response.toString());

        request = new Request("娱乐报销", 20000f);

        response = generalManagerHandler.approve(request);
        System.out.println(response.toString());

        request = new Request("采购报销2", 10000000f);

        response = leaderHandler.approve(request);
        System.out.println(response.toString());
    }
}
