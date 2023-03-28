package be.technifutur.menu;

import java.util.Scanner;
import java.util.stream.Collectors;

public class VueInLine implements MenuVue{
    private Scanner scan = new Scanner(System.in);

    @Override
    public String getchoice(Menu menu) {
        System.out.print(
                menu.getItemText()
                .entrySet()
                .stream()
                .map(e-> e.getKey() + ": "+e.getValue())
                .collect(Collectors.joining(" | ","(",") choix: "))
        );
        return scan.nextLine();
    }
}
