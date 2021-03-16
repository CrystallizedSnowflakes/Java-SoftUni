package solidLab.p05_DependencyInversion.p03_Database;

public class Data implements Database{

    @Override
    public Iterable<Integer> courseIds() {
        // return course ids
        return null;
    }

    @Override
    public Iterable<String> courseNames() {
        // return course names
        return null;
    }

    @Override
    public Iterable<String> search(String substring) {
        // return found results
        return null;
    }

    @Override
    public String getCourseById(int id) {
        // return course by id
        return null;
    }
}
