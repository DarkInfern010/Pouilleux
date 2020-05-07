public class PileTab {

    private int[] tab = {};

    public boolean EstVide()
    {
        return this.tab == null || this.tab.length == 0;
    }

    public void Empiler(int v)
    {
        int[] tempTab = new int [this.tab.length + 1];
        for(int i = 0; i < this.tab.length; i++)
            tempTab[i] = this.tab[i];
        tempTab[this.tab.length] = v;
        this.tab = tempTab;
    }

    public int Depiler()
    {
        int dernierElement = this.tab[this.tab.length - 1];
        int[] tempTab =  new int [this.tab.length - 1];
        for(int i = 0; i < this.tab.length - 1; i++)
            tempTab[i] = this.tab[i];
        this.tab = tempTab;
        return dernierElement;
    }

    public void Afficher()
    {
        for(int i = 0; i < this.tab.length; i++)
            System.out.print(this.tab[i] + "-");
        System.out.println("\n");
    }
}
