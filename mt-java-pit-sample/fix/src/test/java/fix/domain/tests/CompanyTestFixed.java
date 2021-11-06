package fix.domain.tests;

import fix.domain.CompanyFixed;
import fix.domain.EmployeeFixed;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public final class CompanyTestFixed
{
    private CompanyFixed company;

    @Before
    public void setUp()
    {
	company = new CompanyFixed("MegaDyne, Inc.");
    }

    @After
    public void tearDown()
    {
	company = null;
    }

    @Test
    public void companyRenamed()
    {
	/*
	 * TEST SMELL: Mocks are used unnecessarily and validate behavior rather than outcome
	 * Added assertion of the initial state - it is set outside the test method, and we want to confirm that our
	 * assumption about the initial state is correct
	 */
	Assert.assertEquals("MegaDyne, Inc.", company.getName());

	String proposedName = "CyberTron Unlimited, Ltd.";
	company.setName(proposedName);

	Assert.assertEquals(proposedName, company.getName());
    }

    @Test
    public void leadingTrailingSpacesRemovedFromEmployeeName()
    {
	/*
	 * TEST SMELL: Not testing all distinct scenarios (e.g., no spaces, spaces in the middle)
	 */
	EmployeeFixed employee1 = new EmployeeFixed("001", " Bob", 100_000.00);
	Assert.assertEquals("Bob", employee1.getName());

	EmployeeFixed employee2 = new EmployeeFixed("002", "Alice  ", 100_000.00);
	Assert.assertEquals("Alice", employee2.getName());

	EmployeeFixed employee3 = new EmployeeFixed("003", "Jimmy Don", 100_000.00);
	Assert.assertEquals("Jimmy Don", employee3.getName());
    }

    @Test
    public void employeeWithLargestSalary()
    {
	/*
	 * TEST SMELL: does not cover all scenarios
	 */
	company.addEmployee(new EmployeeFixed("002", "Bob", 115_000.00));
	company.addEmployee(new EmployeeFixed("001", "Alice", 120_000.00));
	company.addEmployee(new EmployeeFixed("003", "Carl", 110_000.00));

	EmployeeFixed highestEarner = company.employeeWithLargestSalary();
	Assert.assertEquals("Alice", highestEarner.getName());
    }

    @Test
    public void largestSalaryThrowsWhenNoEmployees()
    {
	Assert.assertThrows(NoSuchElementException.class, () -> company.employeeWithLargestSalary());
    }

    @Test
    public void employeeAdded()
    {
	/*
	 * TEST SMELL: Irrelevant assertions
	 */
	company.addEmployee(new EmployeeFixed("123", "Dave", 100_000.00));
	Assert.assertEquals(1, company.numberOfEmployees());

	company.addEmployee(new EmployeeFixed("456", "Bob", 50_000.00));
	Assert.assertEquals(2, company.numberOfEmployees());

	Assert.assertEquals("Dave", company.findEmployeeById("123").getName());
	Assert.assertEquals("Bob", company.findEmployeeById("456").getName());
    }

    @Test
    public void everybodyGetsRaise()
    {
	/*
	 * TEST SMELL: Calculated expected value duplicates [incorrect] logic in the code under test
	 */
	double increaseBy = 0.1; // everybody's salary should go up by this fraction

	company.addEmployee(new EmployeeFixed("123", "Dave", 100_000.00));
	company.addEmployee(new EmployeeFixed("456", "Alice", 120_000.00));
	company.addEmployee(new EmployeeFixed("789", "Bob", 110_000.00));

	company.everybodyGetsRaiseBy(increaseBy);

	EmployeeFixed dave = company.findEmployeeById("123");

	Assert.assertEquals(110_000.00, dave.getSalary(), 0.0001);
    }

    @Test
    public void findEmployeeById()
    {
	/*
	 * TEST SMELL: No assertions
	 */
	company.addEmployee(new EmployeeFixed("123", "Dave", 100_000.00));
	company.addEmployee(new EmployeeFixed("456", "Alice", 100_000.00));
	company.addEmployee(new EmployeeFixed("789", "Bob", 100_000.00));

	EmployeeFixed hopefullyDave = company.findEmployeeById("123");
	Assert.assertEquals("123", hopefullyDave.getId());
	Assert.assertEquals("Dave", hopefullyDave.getName());
	Assert.assertEquals(100_000.00, hopefullyDave.getSalary(), 0.00001);

	EmployeeFixed hopefullyNoOne = company.findEmployeeById("999");
	Assert.assertNull(hopefullyNoOne);
    }

    @Test
    public void employeeNameChanged()
    {
	/*
	 * TEST SMELL: using a print/log statement, requires reading the output to determine the outcome of the test
	 */
	company.addEmployee(new EmployeeFixed("123", "Dave", 100_000.00));
	company.addEmployee(new EmployeeFixed("456", "Alice", 100_000.00));
	company.addEmployee(new EmployeeFixed("789", "Bob", 100_000.00));

	EmployeeFixed employee = company.findEmployeeById("123");
	employee.setName("Tommy Lee");
	Assert.assertEquals("Tommy Lee", company.findEmployeeById("123").getName());
    }
}
