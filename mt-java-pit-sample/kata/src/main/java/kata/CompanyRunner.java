package kata;

import kata.domain.Company;
import kata.domain.Employee;

public final class CompanyRunner
{
    private static void raiseSalaryAndReadBobs(final Company aNewCompany, final Employee aEmployeeBob)
    {
	aNewCompany.everybodyGetsRaiseBy(0.1);
	System.out.printf("%s's salary after the raise is %,.2f\n", aEmployeeBob.getName(), aEmployeeBob.getSalary());
    }

    private static Employee noteCurrentSalaryOfBob(final Company aNewCompany)
    {
	System.out.println("\nTime for a pay raise for everyone!");
	Employee bob = aNewCompany.findEmployeeById("002");
	System.out.printf("%s's salary before the raise is %,.2f\n", bob.getName(), bob.getSalary());
	return bob;
    }

    private static void addNext2Employees(final Company aNewCompany)
    {
	aNewCompany.addEmployee(new Employee("005", "Billy Bob", 70_000.00));
	aNewCompany.addEmployee(new Employee("006", "Anna Lee", 90_000.00));
	System.out.println("Welcome " + aNewCompany.findEmployeeById("005").getName() + " and "
			   + aNewCompany.findEmployeeById("006").getName() + " to the company");
	System.out.println("Now there are " + aNewCompany.numberOfEmployees() + " employees at the company");
    }

    private static void addFirst4Employees(final Company aNewCompany)
    {
	aNewCompany.addEmployee(new Employee("001", " Alice", 100_000.00));
	aNewCompany.addEmployee(new Employee("002", "Bob", 120_000.00));
	aNewCompany.addEmployee(new Employee("003", "Carl", 80_000.00));
	aNewCompany.addEmployee(new Employee("004", "Bob ", 90_000.00));
	System.out.println("\nThere are " + aNewCompany.numberOfEmployees() + " employees at the company");
    }

    private static void renameCompanyName(final Company aNewCompany)
    {
	aNewCompany.setName("Bob's Bicycle Repair");
	System.out.println("Renamed the company to " + aNewCompany.getName());
    }

    private static Company createNewCompany()
    {
	Company company = new Company("Schnitzels and Bits");
	System.out.println("Welcome to our company, " + company.getName());
	return company;
    }

    public static final void main(final String[] aArgs)
    {
	Company lNewCompany = createNewCompany();
	renameCompanyName(lNewCompany);

	addFirst4Employees(lNewCompany);
	addNext2Employees(lNewCompany);

	Employee lEmployeeBob = noteCurrentSalaryOfBob(lNewCompany);
	raiseSalaryAndReadBobs(lNewCompany, lEmployeeBob);
    }
}
