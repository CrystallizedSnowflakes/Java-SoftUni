import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import static java.time.ZoneOffset.UTC;

public class Engine implements Runnable{

    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.println("Please select exercise number: ");
        try {
            int exNum = Integer.parseInt(reader.readLine());
            switch (exNum) {
                case 2 -> exTwoChangeCasing();
                case 3 -> exThreeContainsEmployee();
                case 4 -> exFourEmployeesWithSalaryOverFiftyThousand();
                case 5 -> exFiveEmployeesFromDepartment();
                case 6 -> exSixAddingNewAddressAndUpdatingEmployee();
                case 7 -> exSevenAddressesWithEmployeeCount();
                case 8 -> exEightGetEmployeeWithProject();
                case 9 -> exNineFindLatestTenProjects();
                case 10 -> exTenIncreaseSalaries();
                case 11 -> exElevenFindEmployeesByFirstName();
                case 12 -> exTwelveEmployeesMaximumSalaries();
                case 13 -> exThirteenRemoveTowns();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    private void exThirteenRemoveTowns() throws IOException {
        System.out.println("Please enter town name:");
        String townName = reader.readLine();

        Town town = entityManager
                .createQuery("SELECT t FROM Town t " +
                        "WHERE t.name = :t_name",
                        Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        int affectedRows = removeAddressesByTownId(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        System.out.printf("%d address%s in %s deleted",
                affectedRows,
                (affectedRows != 1) ? "es" : "",
                town.getName().charAt(0) + town.getName().substring(1).toLowerCase());
    }

    private int removeAddressesByTownId(Long townId) {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a WHERE a.town.id = :t_id", Address.class)
                .setParameter("t_id", townId)
                .getResultList();

        entityManager.getTransaction().begin();

        addresses.forEach(address -> {
            address.getEmployees().forEach(employee -> employee.setAddress(null));
            address.setTown(null);
            entityManager.remove(address);
        });
        // addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return addresses.size();
    }

    @SuppressWarnings("unchecked")
    private void exTwelveEmployeesMaximumSalaries() {
        List<Object[]> rows = entityManager
                .createNativeQuery("SELECT d.name, MAX(e.salary) AS m_salary FROM departments d " +
                        "JOIN employees e ON d.department_id = e.department_id " +
                        "GROUP BY d.name " +
                        "HAVING m_salary NOT BETWEEN 30000 AND 70000")
                .getResultList();

        rows.forEach(objects -> System.out.printf("%s %s%n", objects[0], objects[1]));
    }

    private void exElevenFindEmployeesByFirstName() throws IOException {
        System.out.println("Please enter the name pattern:");
        String pattern = reader.readLine() + "%";
        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.firstName LIKE :p_like",
                Employee.class)
                .setParameter("p_like", pattern)
                .getResultStream()
                .forEach(employee -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getJobTitle(),
                        employee.getSalary()));
    }

    private void exTenIncreaseSalaries() {
        entityManager.getTransaction().begin();
        int affectedRows = entityManager
                .createQuery("UPDATE Employee e " +
                        "SET e.salary = e.salary * 1.12 " +
                        "WHERE e.department.id IN :ids")
                .setParameter("ids", Set.of(1L,2L,4L,11L))
                .executeUpdate();
        entityManager.getTransaction().commit();
        System.out.println(affectedRows);

        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.id IN :ids", Employee.class)
                .setParameter("ids", Set.of(1L,2L,4L,11L))
                .getResultStream()
                .forEach(employee -> System.out.printf("%s %s ($%.2f)%n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary()));
    }

    private void exNineFindLatestTenProjects() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s").withZone(UTC);
        entityManager
                .createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultStream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf("Project name: %s%n\tProject Description: %s%n" +
                                "\tProject Start Date:%s%n\tProject End Date: %s%n",
                        project.getName(),
                        project.getDescription() == null ? "null" : project.getDescription(),
                        project.getStartDate() == null ? "null" : formatter.format(project.getStartDate().toInstant(ZoneOffset.ofHours(3))),
                        project.getEndDate() == null ? "null" : formatter.format(project.getEndDate().toInstant(ZoneOffset.ofHours(3)))
                        )
                );
    }

    private void exEightGetEmployeeWithProject() throws IOException {
        System.out.println("Please enter employee id:");
        long employeeId = Integer.parseInt(reader.readLine());
        Employee employee = entityManager.find(Employee.class, employeeId);

        System.out.printf("%s %s - %s%n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        employee.getProjects().stream()
                .map(Project::getName)
                .sorted()
                .forEach(project -> System.out.printf("\t%s%n", project));
    }

    private void exSevenAddressesWithEmployeeCount() {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC", // Set<Employee>
                        Address.class)
                .setMaxResults(10) // LIMIT 10
                .getResultList();

        addresses.forEach(address -> {
            System.out.printf("%s, %s - %d employees%n",
                    address.getText(),
                    address.getTown() == null ? "Unknown" : address.getTown().getName(),
                    address.getEmployees().size());
        });
    }

    private void exSixAddingNewAddressAndUpdatingEmployee() throws IOException {
        System.out.println("Please enter employee last name:");
        String lastName = reader.readLine();
        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :l_name",
                        Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();

        Address address = createNewAddressBy("Vitoshka 15");
        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createNewAddressBy(String addressText) {
        Address address = new Address();
        address.setText(addressText);
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private void exFiveEmployeesFromDepartment() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = :d_name " +
                                "ORDER BY e.salary, e.id",
                        Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from %s - $%.2f%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getDepartment().getName(),
                            employee.getSalary());
                });
    }

    private void exFourEmployeesWithSalaryOverFiftyThousand() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                    "WHERE e.salary > :min_salary", Employee.class)
                .setParameter("min_salary", BigDecimal.valueOf(50000L))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private void exThreeContainsEmployee() throws IOException {
        System.out.println("Please enter employee full name:");
        String[] fullName = reader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];
        Long singleResult = entityManager.createQuery("SELECT count(e) FROM Employee e " +
                "WHERE e.firstName = :f_name AND e.lastName = :l_name", Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();
        System.out.println(singleResult == 0 ? "No" : "Yes");
    }

    private void exTwoChangeCasing() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t " +
                "SET t.name = UPPER(t.name) " +
                "WHERE LENGTH(t.name) <= :n_length")
                .setParameter("n_length", 5);
        int updatedRows = query.executeUpdate();
        System.out.println(updatedRows);
        entityManager.getTransaction().commit();
    }
}
