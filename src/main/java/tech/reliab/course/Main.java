package tech.reliab.course.farhanham;

import tech.reliab.course.farhanham.bank.entity.*;
import tech.reliab.course.farhanham.bank.service.*;
import tech.reliab.course.farhanham.bank.service.impl.*;

import java.time.Instant;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Сервисы
        BankService bankService = new BankServiceImpl();
        BankOfficeServiceImpl officeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        BankAtmService atmService = new BankAtmServiceImpl();
        UserService userService = new UserServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();

        //Объекты

        //создаем банк
        Bank bank = bankService.create("MyBank");
        //создаем офис
        BankOffice office = officeService.create("MyOffice", bank, "MyAddress", 1000.);
        //создаем сотрудника
        Employee employee = employeeService.create(
                "hesham",
                "farhan",
                LocalDate.now(),
                "job",
                bank,
                office,
                15000.
        );
        //создаем банкомат
        BankAtm atm = atmService.create("atm", bank, office, employee, 1000.);
        //создаем клиента
        User user = userService.create("hesham", "farhan", LocalDate.now(),"job",bank);
        //создаем платежный счет
        PaymentAccount paymentAccount = paymentAccountService.create(user, bank.getName());
        //создаем кредитный счет
        CreditAccount creditAccount = creditAccountService.create(
                user,
                bank,
                LocalDate.now(),
                LocalDate.now(),
                15,
                15,
                1,
                employee,
                paymentAccount
        );
        System.out.println(bank);
        System.out.println(office);
        System.out.println(employee);
        System.out.println(atm);
        System.out.println(user);
        System.out.println(paymentAccount);
        System.out.println(creditAccount);

        bankService.delete(bank);
        officeService.delete(office);
        employeeService.delete(employee);
        atmService.delete(atm);
        userService.delete(user);
        paymentAccountService.delete(paymentAccount);
        creditAccountService.delete(creditAccount);
    }
}