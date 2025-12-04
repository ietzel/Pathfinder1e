public class Enchantment extends School {
    public boolean attackrollfearsavebonus;
    public boolean command;
    public boolean sleep;
    public boolean maxtemphpeachcasterlevel;
    public boolean entrance;
    public Enchantment(String name, boolean attackrollfearsavebonus, boolean command, boolean sleep, boolean maxtemphpeachcasterlevel, boolean entrance) {
        super(name);    
        this.attackrollfearsavebonus = attackrollfearsavebonus;
        this.sleep = sleep;
        this.maxtemphpeachcasterlevel = maxtemphpeachcasterlevel;
        this.entrance = entrance;
    }
}