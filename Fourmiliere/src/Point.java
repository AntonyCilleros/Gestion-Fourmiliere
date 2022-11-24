import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public enum Point implements Collection<Point> {
    UN((int) (30 + (Math.random() * (50 - 30))), 0),
    DEUX((int) (50 + (Math.random() * (150 - 50))), 10),
    TROIS((int) (150 + (Math.random() * (300 - 150))), 23),
    QUATRE((int) (300 + (Math.random() * (500 - 300))), 40),
    CINQ((int) (500 + (Math.random() * (1000 - 500))), 70),;

    int nbNourriture;
    int dangerosite;

    Point(int nbNourriture, int dangerosite) {
        this.nbNourriture = nbNourriture;
        this.dangerosite = dangerosite;
    }

    public int getNbNourriture() {
        return nbNourriture;
    }

    public int getDangerosite() {
        return dangerosite;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Point> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Point point) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Point> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
