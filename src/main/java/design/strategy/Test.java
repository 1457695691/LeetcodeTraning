package design.strategy;

public class Test {
    public static void main(String[] args) {

        RoleA roleA = new RoleA("A");
        roleA.setDisplayBehavior(new DisplayA())
                .setAttackBehavior(new AttackJY())
                .setDefendBehavior(new DefendTBS())
                .setRunBehavior(new RunJCTQ());

        System.out.println(roleA.name + ":");
        roleA.run();
        roleA.attack();
        roleA.display();
        roleA.defend();

    }
}
