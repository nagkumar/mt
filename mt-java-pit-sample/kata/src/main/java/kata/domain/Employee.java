package kata.domain;

public final class Employee
{
    private final String id;
    private String name;
    private double salary;

    public Employee(final String aId, final String aName, final double aSalary)
    {
	id = aId;
	setName(aName);
	setSalary(aSalary);
    }

    public String getId()
    {
	return id;
    }

    public String getName()
    {
	return name;
    }

    /**
     * Set the employee name after removing leading and trailing spaces, which could be left by upstream system
     *
     * @param aNewName the new name for the employee, possibly with leading and trailing white space to be removed
     */
    public void setName(final String aNewName)
    {
	name = aNewName.replaceAll(" ", "");        //todo: issue - 4
    }

    public double getSalary()
    {
	return salary;
    }

    public void setSalary(final double aNewSalary)
    {
	salary = aNewSalary;
    }
}
