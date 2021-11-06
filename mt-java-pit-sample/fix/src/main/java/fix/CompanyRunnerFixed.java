package fix;

import fix.domain.CompanyFixed;
import fix.domain.EmployeeFixed;

public final class CompanyRunnerFixed
{
    private static void raiseSalaryAndReadBobs(final CompanyFixed aCompanyFixed, final EmployeeFixed aEmployeeFixed)
    {
	aCompanyFixed.everybodyGetsRaiseBy(0.1);
	System.out.printf("%s's salary after the raise is %,.2f\n", aEmployeeFixed.getName(), aEmployeeFixed.getSalary());
    }

    private static EmployeeFixed noteCurrentSalaryOfBob(final CompanyFixed aCompanyFixed)
    {
	System.out.println("\nTime for a pay raise for everyone!");
	EmployeeFixed bob = aCompanyFixed.findEmployeeById("002");
	System.out.printf("%s's salary before the raise is %,.2f\n", bob.getName(), bob.getSalary());
	return bob;
    }

    private static void addNext2Employees(final CompanyFixed aCompanyFixed)
    {
	aCompanyFixed.addEmployee(new EmployeeFixed("005", "Billy Bob", 70_000.00));
	aCompanyFixed.addEmployee(new EmployeeFixed("006", "Anna Lee", 90_000.00));
	System.out.println("Welcome " + aCompanyFixed.findEmployeeById("005").getName() + " and "
			   + aCompanyFixed.findEmployeeById("006").getName() + " to the company");
	System.out.println("Now there are " + aCompanyFixed.numberOfEmployees() + " employees at the company");
    }

    private static void addFirst4Employees(final CompanyFixed aCompanyFixed)
    {
	aCompanyFixed.addEmployee(new EmployeeFixed("001", " Alice", 100_000.00));
	aCompanyFixed.addEmployee(new EmployeeFixed("002", "Bob", 120_000.00));
	aCompanyFixed.addEmployee(new EmployeeFixed("003", "Carl", 80_000.00));
	aCompanyFixed.addEmployee(new EmployeeFixed("004", "Bob ", 90_000.00));
	System.out.println("\nThere are " + aCompanyFixed.numberOfEmployees() + " employees at the company");
    }

    private static void renameCompanyName(final CompanyFixed aCompanyFixed)
    {
	aCompanyFixed.setName("Bob's Bicycle Repair");
	System.out.println("Renamed the company to " + aCompanyFixed.getName());
    }

    private static CompanyFixed createNewCompany()
    {
	CompanyFixed company = new CompanyFixed("Schnitzels and Bits");
	System.out.println("Welcome to our company, " + company.getName());
	return company;
    }

    public static final void main(final String[] aArgs)
    {
	CompanyFixed company = createNewCompany();
	renameCompanyName(company);

	addFirst4Employees(company);
	addNext2Employees(company);

	EmployeeFixed bob = noteCurrentSalaryOfBob(company);
	raiseSalaryAndReadBobs(company, bob);
    }
}
