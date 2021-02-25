package weightedunion;

public class WeightedQuickUnionImpl implements WeightedQuickUnion {
    private int[] id;
    private int[] countRoot;
    private int count;

    public WeightedQuickUnionImpl(int n) {
        //Initialisere arrayet med et bestemt antal pladser n
        id = new int[n];

        //Initialisere arrayet med et bestemt antal pladser n
        countRoot = new int[n];

        //Sætter størrelsen på arrayet til count ud fra det angivne n
        count = n;

        //Indsætter værdier i alle pladser af de angivne arrays
        for (int i = 0; i < n; i++) {
            id[i] = i;
            countRoot[i] = 1; //Laver et array til at tælle antal punkter på en root
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

        //Finder antal punkter på sin root ud fra arrayet der styre antallet af punkter på en root - countRoot[].
        int rootPcount = countRoot[rootP];
        int rootQcount = countRoot[rootQ];

        //Tjek om hvilket root som har flest punkter på sig, og dermed skal være øverst og have et mindre træ
        //koblet på sig. Det sker ved at tjekke på hvor mange punkter der er på hver root i arrayet countRoot[],
        //hvorefter man forbinder root på den måde at det største træ er øverst - hvorefter man tager antallet
        //af forbindelser fra undertræet og sætter på sit eget i countRoot arrayet.
        if(countRoot[rootP] > countRoot[rootQ]){
            id[rootQ] = rootP;
            countRoot[rootP] += rootQcount;
        } else {
            id[rootP] = rootQ;
            countRoot[rootQ] += rootPcount;
        }

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
