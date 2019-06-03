/**
 * 
 */
package learning.mode.mediator2;

/**
 * @author Xiong.Liu
 *
 */
public abstract class AbstractColleague {

    protected AbstractMediator mediator;
    public AbstractColleague(AbstractMediator _mediator){
        this.mediator = _mediator;
    }

}
