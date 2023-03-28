import be.technifutur.menu.*;

public class Main {
    public static void main(String[] args) {

        //Menu menuPrincipal = getMenu();
        MenuBuilder menuBuilder = new MenuBuilder();
        Menu menuPrincipal = getMenu();

        while ( ! menuPrincipal.isFinish()) {
            menuPrincipal.execute();
        }

    }

    private static Menu getMenu(MenuBuilder menuBuilder) {
        Menu menuPrincipal = menuBuilder.start("Menu Principal");
        {
            menuBuilder.addItem("a", "Option1", getOption1());
            menuBuilder.startMenu("b", "Menu Secondaire");
            {
                menuBuilder.addItem("c", "Option2", getOption2());
                Menu menu3 = menuBuilder.startMenu("d", "Menu 3", new VueInLine());
                {
                    menuBuilder.addItem("e", "Option3", getOption3());
                    menuBuilder.addItem("q", "Quitter", () -> menu3.setFinish(true));
                }
                menuBuilder.endMenu();
            }
            menuBuilder.endMenu();
            menuBuilder.addItem("q", "quitter", () -> menuPrincipal.setFinish(true));
        }
        menuBuilder.end();
        return menuPrincipal;
    }

    private static Menu getMenu() {
        MenuBase menuPrincipal = new MenuBase("Menu Principal", new MenuVueImpl());
        MenuBase menuSecondaire = new MenuBase("Menu secondaire", new MenuVueImpl());
        ItemExecutable option1 = new ItemExecutable("Option 1", getOption1());
        ItemExecutable option2 = new ItemExecutable("Option 2", getOption2());
        ItemExecutable option3 = new ItemExecutable("Option 3", getOption3());
        ItemExecutable option4 = new ItemExecutable("Option 4", getOption4());
        ItemExecutable option5 = new ItemExecutable("Option 5", getOption5());
        ItemExecutable test = new ItemExecutable(
                "Menu secondaire",
                getLoopMenu(menuSecondaire));

        menuSecondaire.addItem( "a", option3);
        menuSecondaire.addItem( "b", option4);
        menuSecondaire.addItem("q",new ItemExecutable("quitter",()->menuSecondaire.setFinish(true)));
        menuPrincipal.addItem("i",option1);
        menuPrincipal.addItem("s",test);
        menuPrincipal.addItem("j",option2);
        menuPrincipal.addItem("k",option5);
        menuPrincipal.addItem("q",new ItemExecutable("quitter",()->menuPrincipal.setFinish(true)));
        return menuPrincipal;
    }

    private static Runnable getLoopMenu(MenuBase menuSecondaire) {
        return () -> {
            menuSecondaire.setFinish(false);
            while (!menuSecondaire.isFinish()) menuSecondaire.execute();
        };
    }

    private static Runnable getOption5() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("vous avez choisi l'otion 5");
            }
        };
    }

    private static Runnable getOption4() {
        return ()->System.out.println("vous avez choisi l'otion 4");
    }

    private static Runnable getOption3() {
        return ()->System.out.println("vous avez choisi l'otion 3");
    }

    private static Runnable getOption2() {
        return ()->System.out.println("vous avez choisi l'otion 2");
    }

    private static Runnable getOption1() {
        return ()->System.out.println("vous avez choisi l'otion 1");
    }
}