package be.technifutur.menu;

import java.util.ArrayDeque;
import java.util.Deque;

public class MenuBuilder {
    private MenuVue defaultVue = new MenuVueImpl();
    private Deque<Menu> pileMenu = new ArrayDeque<>();


    public Menu getMenu() {
        return pileMenu.peek();
    }

    public Item addItem(String key , String libel, Runnable action) {
        ItemExecutable itemExecutable = new ItemExecutable(libel, action);
        pileMenu.peek().addItem(key,itemExecutable);
        return itemExecutable;
    }

    public Menu startMenu(String key, String libel) {
        return startMenu(key,libel, defaultVue);
    }
    public Menu startMenu(String key, String libel, MenuVue vue) {
        MenuBase menu = new MenuBase(libel, vue);

        pileMenu.peek().addItem(key,menu);
        pileMenu.push(menu);
        return menu;
    }

    public Menu endMenu() {
        return pileMenu.pop();
    }

    public Menu start(String menuPrincipal) {
        Menu menu = new MenuBase(menuPrincipal, defaultVue);
        pileMenu.push(menu);
        return menu;
    }

    public void end() {
        pileMenu.clear();
    }

}
