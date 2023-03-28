import be.technifutur.menu.Menu;
import be.technifutur.menu.MenuBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class  ListControler<E> implements Runnable{
    private  List<E> list;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("toto", "dede", "lucas", "bill"));
        ListControler<String> exempleControler = new ListControler<String>(list) {
            @Override
            protected String getLibel(List<String> liste, int pos) {
                return liste.get(pos);
            }

            @Override
            public void action(List<String> liste, int pos) {
                System.out.println( liste.get(pos));
            }
        };
        exempleControler.run();
    }
    public ListControler(List<E> list) {
        this.list = list;
    }
    @Override
    public void run() {
        MenuBuilder menuBuilder = new MenuBuilder();
        Menu actionSurX = menuBuilder.start("Action sur X");
        for (int i = 0; i < list.size(); i++) {
            int pos = i;
            menuBuilder.addItem(pos+1+"", getLibel(list,pos),()-> action(list,pos) );
        }
        actionSurX.execute();
    }
    protected abstract String getLibel(List<E> liste, int pos) ;

    public abstract void action(List<E> liste, int pos);
}
