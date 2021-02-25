package quickunion;

public class QuickUnionImpl implements QuickUnion{
    private int[] id;
    private int count;

    public QuickUnionImpl(int n) {
        //Initialisere arrayet med et bestemt antal pladser n
        id = new int[n];

        //Sætter størrelsen på arrayet til count ud fra det angivne n
        count = n;

        //Indsætter værdier i alle pladser af det angivne array
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        //Tjek om to angivne punkter er connected - hvis de er så skal der ikke gøres noget
        if(connected(p,q)) {
            System.err.println("Punkterne " + p + " og " + q + " er allerede forbundet!");
            return;
        }

        //Finder root for begge punkter for at forbinde punkterne
        int rootP = find(p);
        int rootQ = find(q);

        //Sætter root fra punkt p til root for punkt q - f.eks. laves der ikke en direkte union mellem root 1 og root 8
        //Men i stedet sættes denne automatisk, hvis der laves en union for hvert træ - f.eks. punkt 9 til punkt 7
        //Så laves automatisk en union mellem root 1 og root 8.
        id[rootP] = rootQ;

        //Tæller mulige kombinationer ned med 1
        count--;
    }

    @Override
    public int find(int p) {
        //Tjekker og returnerer top punktet (root) som er forbundet - dette er lavet ud illustrationen i pdf for ugen
        //Hvis der søges efter punkt 5 - så fortsætter while løkken med at søge indtil den finder det øverste punkt (root)
        //i dette tilfælde 1 - den stopper og returnerer når man når samme værdi i id[?] som værdien på pladsen.
        //Altså fortsætter denne algoritme med at søge indtil den finder 1 - fordi der står 1 i værdien id[1]
        //Dette kan ses på illustrationen i pdf for ugen under Quick-union eller i mappen images.
        while(id[p] != p){
            p = id[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        //Finder ud af om to punkter er forbundet
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
