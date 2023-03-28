package be.technifutur.menu;

import java.util.Map;

public interface Menu {
    boolean isFinish();

    void setFinish(boolean finish);

    void execute();

    Map<String, String> getItemText();

    Item addItem(String key, Item item);

    String getLibel();
}
