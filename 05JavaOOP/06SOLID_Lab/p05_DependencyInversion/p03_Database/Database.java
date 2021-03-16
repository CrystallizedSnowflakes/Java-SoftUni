package solidLab.p05_DependencyInversion.p03_Database;

public interface Database {
    public Iterable<Integer> courseIds();

    public Iterable<String> courseNames();

    public Iterable<String> search(String substring);

    public String getCourseById(int id);

}
