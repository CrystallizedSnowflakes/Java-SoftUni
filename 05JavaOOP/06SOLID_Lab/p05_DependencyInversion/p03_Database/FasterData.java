package solidLab.p05_DependencyInversion.p03_Database;

public class FasterData implements Database{
    @Override
    public Iterable<Integer> courseIds() {
        return null;
    }

    @Override
    public Iterable<String> courseNames() {
        return null;
    }

    @Override
    public Iterable<String> search(String substring) {
        return null;
    }

    @Override
    public String getCourseById(int id) {
        return null;
    }
}
