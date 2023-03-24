package be.technifutur.menu;

public abstract class Item {
    private final String libel;
    private boolean actif =true;

    public Item(String libel) {
        if(libel==null || libel.isBlank()) {
            throw new IllegalArgumentException("Libellé non affichable");
        }
        this.libel = libel;
    }

    public String getLibel() {
        return libel;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public abstract void execute();
}
