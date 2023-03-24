package be.technifutur.menu;

public class ItemExecutable extends Item{

    private Runnable action;
    public ItemExecutable(String libel, Runnable action) {
        super(libel);
        this.action = action;
    }

    @Override
    public void execute() {
        if(isActif())
        this.action.run();
    }
}
