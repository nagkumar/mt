package fix.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public final class CompanyFixed
{
    private final List<EmployeeFixed> employees = new ArrayList<>();
    private String name;

    public CompanyFixed(final String aNewName)
    {
	setName(aNewName);
    }

    public String getName()
    {
	return name;
    }

    public void setName(final String aName)
    {
	name = aName;
    }

    public void addEmployee(final EmployeeFixed aNewEmployee)
    {
	employees.add(aNewEmployee);
    }

    /**
     * Increase every employee's salary by the specified fraction
     *
     * @param aIncrementAsFraction salary increase as a fraction of the original salary. e.g. if the value of the
     *                             parameter is 0.1, everyone at the company gets a 10% raise
     */
    public void everybodyGetsRaiseBy(final double aIncrementAsFraction)
    {
	employees.forEach(e -> e.setSalary(e.getSalary() * (1 + aIncrementAsFraction)));
    }

    /**
     * Finds an employee by their aId
     *
     * @param aId the aId of the employee to be found
     * @return the employee with the aId passed as the parameter or null if no such employee exists
     */
    public EmployeeFixed findEmployeeById(final String aId)
    {
	return employees.stream()
		.filter(e -> e.getId().equals(aId))
		.findFirst()
		.orElse(null);
    }

    public int numberOfEmployees()
    {
	return employees.size();
    }

    /**
     * find the employee with the largest salary
     *
     * @return the employee with the largest salary
     * @throws NoSuchElementException if there are no employees at the company
     */
    public EmployeeFixed employeeWithLargestSalary()
    {
	return employees
		.stream()
		.max(Comparator.comparing(EmployeeFixed::getSalary))
		.orElseThrow(NoSuchElementException::new);
    }
}
