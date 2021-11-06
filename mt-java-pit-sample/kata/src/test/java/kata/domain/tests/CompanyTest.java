package kata.domain.tests;

import kata.domain.Company;
import kata.domain.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public final class CompanyTest
{
    private Company company;

    @Before
    public void setUp()
    {
	company = new Company("MegaDyne, Inc.");
    }

    @After
    public void tearDown()
    {
	company = null;
    }

    @Test
    public void companyRenamed()
    {
	String proposedName = "CyberTron Unlimited, Ltd.";
	Company aCompany = Mockito.spy(company);
	aCompany.setName(proposedName);
	verify(aCompany).setName(proposedName);
	Assert.assertNotNull(aCompany.getName());
    }

    @Test
    public void leadingTrailingSpacesRemovedFromEmployeeName()
    {
	Employee employee1 = new Employee("001", " Bob", 100_000.00);
	Assert.assertEquals("Bob", employee1.getName());
	Employee employee2 = new Employee("002", "Alice  ", 100_000.00);
	Assert.assertEquals("Alice", employee2.getName());
    }

    @Test
    public void employeeWithLargestSalary()
    {
	company.addEmployee(new Employee("001", "Alice", 120_000.00));
	company.addEmployee(new Employee("002", "Bob", 115_000.00));
	company.addEmployee(new Employee("003", "Carl", 110_000.00));

	Employee highestEarner = company.employeeWithLargestSalary();
	Assert.assertEquals("Alice", highestEarner.getName());
    }

    @Test
    public void employeeAdded()
    {
	company.addEmployee(new Employee("123", "Dave", 100_000.00));
	Assert.assertTrue(company.numberOfEmployees() > 0);

	company.addEmployee(new Employee("456", "Bob", 50_000.00));
	Assert.assertTrue(company.numberOfEmployees() > 0);
    }

    @Test
    public void everybodyGetsRaise()
    {
	double increaseBy = 0.1; // everybody's salary should go up by this fraction
	double lDaveOriginalSalary = 100_000.00;

	company.addEmployee(new Employee("123", "Dave", lDaveOriginalSalary));
	company.addEmployee(new Employee("456", "Alice", 120_000.00));
	company.addEmployee(new Employee("789", "Bob", 110_000.00));

	company.everybodyGetsRaiseBy(increaseBy);
	Employee dave = company.findEmployeeById("123");
	Assert.assertEquals(lDaveOriginalSalary * increaseBy, dave.getSalary(), 0.0001);
    }

    @Test
    public void findEmployeeById()
    {
	company.addEmployee(new Employee("123", "Dave", 100_000.00));
	company.addEmployee(new Employee("456", "Alice", 100_000.00));
	company.addEmployee(new Employee("789", "Bob", 100_000.00));

	Employee hopefullyDave = company.findEmployeeById("123");
	Employee hopefullyNoOne = company.findEmployeeById("999");
    }

    @Test
    public void employeeNameChanged()
    {
	company.addEmployee(new Employee("123", "Dave", 100_000.00));
	company.addEmployee(new Employee("456", "Alice", 100_000.00));
	company.addEmployee(new Employee("789", "Bob", 100_000.00));

	Employee employee = company.findEmployeeById("123");
	employee.setName("Tommy Lee");
	employee = company.findEmployeeById("123");
	System.out.println(employee.getName().equals("Tommy Lee") ? "PASSED" : "FAILED");
    }
}
