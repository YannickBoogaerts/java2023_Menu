package be.technifutur.menu;

import java.util.Map;
import java.util.Scanner;

public class MenuVueImpl implements MenuVue{

    private Scanner scan =new Scanner(System.in);
    @Override
    public String getchoice(Menu menu) {
        System.out.println("\n"+menu.getLibel()+"\n");
        menu.getItemText().forEach((k,v)-> System.out.println(k+" "+v));
        System.out.print("choix: ");
        return scan.nextLine();
    }
}
