/**
 * Кортеж
 */
public class MyTuple<N,C> {
    private N nameFile;
    private C clss;

    public MyTuple(N nameFile, C clss) {
        this.nameFile = nameFile;
        this.clss = clss;
    }

    public N getNameFile() {
        return nameFile;
    }

    public C getClss() {
        return clss;
    }
}
