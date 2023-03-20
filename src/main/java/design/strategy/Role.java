package design.strategy;

/**
 * @author Ayuan
 * * 新改进的角色超类:
 * * 遵循设计的原则，找出应用中可能需要变化的部分，把它们独立出来，
 * * 不要和那些不需要变化的代码混在一起。
 * * 我们发现，对于每个角色的display，attack，defend，run都是有可能变化的，于是我们必须把这写独立出来。
 * * 再根据另一个设计原则：针对接口（超类型）编程，而不是针对实现编程，于是我们把代码改造成这样：
 */
public abstract class Role {

    /**
     * 角色姓名
     */
    protected String name;

    protected IDisplayBehavior displayBehavior;

    protected IAttackBehavior attackBehavior;

    protected IDefendBehavior defendBehavior;

    protected IRunBehavior runBehavior;

    /**
     * Getter & Setter
     */

    public Role setDisplayBehavior(IDisplayBehavior displayBehavior) {
        this.displayBehavior = displayBehavior;
        return this;
    }

    public Role setAttackBehavior(IAttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
        return this;
    }

    public Role setDefendBehavior(IDefendBehavior defendBehavior) {
        this.defendBehavior = defendBehavior;
        return this;
    }

    public Role setRunBehavior(IRunBehavior runBehavior) {
        this.defendBehavior = defendBehavior;
        return this;
    }

    protected void display(){
        displayBehavior.display();
    }

    protected void run(){
        runBehavior.run();
    }

    protected void attack(){
        attackBehavior.attack();
    }

    protected void defend(){
        defendBehavior.defend();
    }
}
