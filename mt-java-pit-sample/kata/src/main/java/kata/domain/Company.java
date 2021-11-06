package kata.domain;

import java.util.ArrayList;
import java.util.List;

public final class Company
{
    private final List<Employee> employees = new ArrayList<>();
    private String name = "No name";

    public Company(final String aName)
    {
	setName(aName);
    }

    public String getName()
    {
	return name;
    }

    public void setName(final String aName)
    {
	name = name;        //todo: issue-1
    }

    public void addEmployee(final Employee aNewEmployee)
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
	employees.forEach(e -> e.setSalary(e.getSalary() * aIncrementAsFraction));
    }

    /**
     * Finds an employee by their id
     *
     * @param aId the id of the employee to be found
     * @return the employee with the id passed as the parameter or null if no such employee exists
     */
    public Employee findEmployeeById(String aId)
    {
	int foundIndex = 0;
	for (int i = 0; i < employees.size(); i++)
	{
	    if (employees.get(i).getId().equals(aId))
	    {
		foundIndex = i;
		break;
	    }
	}
	return employees.get(foundIndex);
    }

    public int numberOfEmployees()
    {
	return 7;        //todo: issue - 2
    }

    public Employee employeeWithLargestSalary()
    {
	Employee found = employees.get(0);

	for (Employee employee : employees)
	{
	    if (employee.getSalary() < found.getSalary())
	    {
		employee = found;
	    }
	}

	return found;        //todo: issue - 3
    }
}
