package com.tfliorko.db_lab_4_jdbctemplate.view;

import com.tfliorko.db_lab_4_jdbctemplate.controller.*;
import com.tfliorko.db_lab_4_jdbctemplate.controller.TicketsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tfliorko.db_lab_4_jdbctemplate.model.*;

import java.sql.Date;
import java.util.*;

@Component
public class MyView {

    private TicketsController ticketsController;
    @Autowired
    private AttractionController attractionController;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private DysneyParkController dysneyParkController;
    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private ShowController showController;


    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);

    private final Attraction nullAttraction = new Attraction(null, null,null, null, null);
    private final Customer nullCustomer = new Customer(null, null, null, null);
    private final DysneyPark nullDysneyPark = new DysneyPark(null, null, null, null);
    private final Employee nullEmployee= new Employee(null, null, null, null, null);
    private final Show nullShow = new Show(null, null, null, null, null);
    private final Tickets nullTickets = new Tickets(null, null, null, null, null, null);

    public MyView(){
        menu = new LinkedHashMap<>();

        menu.put("1", "   1 - Table: Attraction");
        menu.put("11", "  11 - Create Attraction");
        menu.put("12", "  12 - Update Attraction");
        menu.put("13", "  13 - Delete from Attraction");
        menu.put("14", "  14 - Find all Attraction");
        menu.put("15", "  15 - Find Attraction by ID");
        menu.put("16", "  16 - Find Attraction by book_name");

        menu.put("2", "   2 - Table: Customer");
        menu.put("21", "  21 - Create Customer");
        menu.put("22", "  22 - Update Customer");
        menu.put("23", "  23 - Delete from Customer");
        menu.put("24", "  24 - Find all Customer");
        menu.put("25", "  25 - Find Customer by ID");
        menu.put("26", "  26 - Find Customer by first_name");
        menu.put("27", "  27 - Find Customer by second_name");

        menu.put("3", "   3 - Table: DysneyPark");
        menu.put("31", "  31 - Create DysneyPark");
        menu.put("32", "  32 - Update DysneyPark");
        menu.put("33", "  33 - Delete from DysneyPark");
        menu.put("34", "  34 - Find all DysneyPark");
        menu.put("35", "  35 - Find DysneyPark by ID");
        menu.put("36", "  36 - find By city");
        menu.put("37", "  37 - find By street");

        menu.put("4", "   4 - Table: Employee");
        menu.put("41", "  41 - Create Employee");
        menu.put("42", "  42 - Update Employee");
        menu.put("43", "  43 - Delete from Employee");
        menu.put("44", "  44 - Find all Employee");
        menu.put("45", "  45 - Find Employee by ID");
        menu.put("46", "  46 - find By type_of_job");

        menu.put("5", "   5 - Table: Show");
        menu.put("51", "  51 - Create Show");
        menu.put("52", "  52 - Update Show");
        menu.put("53", "  53 - Delete from Show");
        menu.put("54", "  54 - Find all Show");
        menu.put("55", "  55 - Find Show by ID");
        menu.put("56", "  56 - find By name");

        menu.put("6", "   6 - Table: Tickets");
        menu.put("61", "  61 - Create Tickets");
        menu.put("62", "  62 - Update Tickets");
        menu.put("63", "  63 - Delete from Tickets");
        menu.put("64", "  64 - Find all Tickets");
        menu.put("65", "  65 - Find Tickets by ID");
        menu.put("66", "  66 - find By priority_pass");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();

        methodsMenu.put("11", this::createAttraction);
        methodsMenu.put("12", this::updateAttraction);
        methodsMenu.put("13", this::deleteFromAttraction);
        methodsMenu.put("14", this::findAllAttractions);
        methodsMenu.put("15", this::findAttractionById);
        methodsMenu.put("16", this::findAttractionByName);

        methodsMenu.put("21", this::createCustomer);
        methodsMenu.put("22", this::updateCustomer);
        methodsMenu.put("23", this::deleteFromCustomer);
        methodsMenu.put("24", this::findAllCustomers);
        methodsMenu.put("25", this::findCustomerById);
        methodsMenu.put("26", this::findCustomerByFirst_name);
        methodsMenu.put("27", this::findCustomerBySecond_name);

        methodsMenu.put("31", this::createDysneyPark);
        methodsMenu.put("32", this::updateDysneyPark);
        methodsMenu.put("33", this::deleteFromDysneyPark);
        methodsMenu.put("34", this::findAllDysneyParks);
        methodsMenu.put("35", this::findDysneyParkById);
        methodsMenu.put("36", this::findDysneyParkByCity);
        methodsMenu.put("37", this::findDysneyParkByStreet);

        methodsMenu.put("41", this::createEmployee);
        methodsMenu.put("42", this::updateEmployee);
        methodsMenu.put("43", this::deleteFromEmployee);
        methodsMenu.put("44", this::findAllEmployees);
        methodsMenu.put("45", this::findEmployeeById);
        methodsMenu.put("46", this::findEmployeeByType_of_job);

        methodsMenu.put("51", this::createShow);
        methodsMenu.put("52", this::updateShow);
        methodsMenu.put("53", this::deleteFromShow);
        methodsMenu.put("54", this::findAllShows);
        methodsMenu.put("55", this::findShowById);
        methodsMenu.put("56", this::findShowByName);

        methodsMenu.put("61", this::createTickets);
        methodsMenu.put("62", this::updateTickets);
        methodsMenu.put("63", this::deleteFromTickets);
        methodsMenu.put("64", this::findAllTickets);
        methodsMenu.put("65", this::findTicketsById);
        methodsMenu.put("66", this::findTicketsByType_of_job);

    }

    private void createAttraction() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'priority_pass': ");
        Boolean priority_pass = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'max_amount_of_visitors': ");
        Integer max_amount_of_visitors = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'dysney_park_id': ");
        Integer dysney_park_id = Integer.valueOf((input.nextLine()));
        Attraction attraction = new Attraction(null, name, priority_pass, max_amount_of_visitors, dysney_park_id);

        int count = attractionController.create(attraction);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateAttraction() {
        System.out.println("Input 'name' to update: ");
        String name = input.nextLine();
        System.out.println("Input 'priority_pass': ");
        Boolean priority_pass = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'max_amount_of_visitors': ");
        Integer max_amount_of_visitors = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'id' to update: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Attraction attraction = new Attraction(null, name, priority_pass, max_amount_of_visitors, null);

        int count = attractionController.update(id, attraction);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromAttraction() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = attractionController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    private void deleteFromCustomer() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = customerController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    private void deleteFromDysneyPark() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = dysneyParkController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    private void deleteFromShow() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = showController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    private void deleteFromTickets() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = ticketsController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    private void deleteFromEmployee() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = employeeController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    private void findAllAttractions() {
        System.out.println("\nTable: Attraction");
        List<Attraction> objs = attractionController.findAll();
        for (Attraction obj : objs) {
            System.out.println(obj);
        }
    }

    private void findAllCustomers() {
        System.out.println("\nTable: Customer");
        List<Customer> objs = customerController.findAll();
        for (Customer obj : objs) {
            System.out.println(obj);
        }
    }
    private void findAllDysneyParks() {
        System.out.println("\nTable: DysneyPark");
        List<DysneyPark> objs = dysneyParkController.findAll();
        for (DysneyPark obj : objs) {
            System.out.println(obj);
        }
    }
    private void findAllEmployees() {
        System.out.println("\nTable: Employee");
        List<Employee> objs = employeeController.findAll();
        for (Employee obj : objs) {
            System.out.println(obj);
        }
    }
    private void findAllShows() {
        System.out.println("\nTable: Show");
        List<Show> objs = showController.findAll();
        for (Show obj : objs) {
            System.out.println(obj);
        }
    }
    private void findAllTickets() {
        System.out.println("\nTable: v");
        List<Tickets> objs = ticketsController.findAll();
        for (Tickets obj : objs) {
            System.out.println(obj);
        }
    }

    private void findAttractionById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Attraction> book = attractionController.findById(id);
        System.out.println(book.orElse(nullAttraction));
    }

    private void findShowById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Show> book = showController.findById(id);
        System.out.println(book.orElse(nullShow));
    }
    private void findCustomerById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Customer> book = customerController.findById(id);
        System.out.println(book.orElse(nullCustomer));
    }
    private void findDysneyParkById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<DysneyPark> book = dysneyParkController.findById(id);
        System.out.println(book.orElse(nullDysneyPark));
    }
    private void findEmployeeById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Employee> book = employeeController.findById(id);
        System.out.println(book.orElse(nullEmployee));
    }
    private void findTicketsById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Tickets> book = ticketsController.findById(id);
        System.out.println(book.orElse(nullTickets));
    }




    private void createCustomer() {
        System.out.println("Input 'first_name': ");
        String first_name = input.nextLine();
        System.out.println("Input 'second_name': ");
        String second_name = input.nextLine();
        System.out.println("Input 'birthday': ");
        Date birthday = Date.valueOf(input.nextLine());
        Customer customer = new Customer(null, first_name, second_name, birthday);

        int count = customerController.create(customer);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCustomer() {
        System.out.println("Input 'first_name': ");
        String first_name = input.nextLine();
        System.out.println("Input 'second_name': ");
        String second_name = input.nextLine();
        System.out.println("Input 'birthday': ");
        Date birthday = Date.valueOf(input.nextLine());
        System.out.println("Input 'id' to update: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Customer customer = new Customer(null, first_name, second_name, birthday);

        int count = customerController.update(id, customer);
        System.out.printf("There are created %d rows\n", count);
    }

    private void createDysneyPark(){
        System.out.println("Input 'city': ");
        String city = input.nextLine();
        System.out.println("Input 'street': ");
        String street = input.nextLine();
        System.out.println("Input 'max_amount_of_visitors': ");
        Integer max_amount_of_visitors = Integer.valueOf((input.nextLine()));
        DysneyPark obj = new DysneyPark(null, city, street, max_amount_of_visitors);

        int count = dysneyParkController.create(obj);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateDysneyPark(){
        System.out.println("Input 'city': ");
        String city = input.nextLine();
        System.out.println("Input 'street': ");
        String street = input.nextLine();
        System.out.println("Input 'max_amount_of_visitors': ");
        Integer max_amount_of_visitors = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'id' to update: ");
        Integer id = Integer.valueOf((input.nextLine()));
        DysneyPark obj = new DysneyPark(null, city, street, max_amount_of_visitors);

        int count = dysneyParkController.update(id, obj);
        System.out.printf("There are created %d rows\n", count);
    }

    private void createEmployee(){
        System.out.println("Input 'first_name': ");
        String first_name = input.nextLine();
        System.out.println("Input 'second_name': ");
        String second_name = input.nextLine();
        System.out.println("Input 'type_of_job': ");
        String type_of_job = input.nextLine();
        System.out.println("Input 'attraction_id': ");
        Integer attraction_id = Integer.valueOf((input.nextLine()));
        Employee obj = new Employee(null, first_name, second_name, type_of_job, attraction_id);

        int count = employeeController.create(obj);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateEmployee(){
        System.out.println("Input 'first_name': ");
        String first_name = input.nextLine();
        System.out.println("Input 'second_name': ");
        String second_name = input.nextLine();
        System.out.println("Input 'type_of_job': ");
        String type_of_job = input.nextLine();
        System.out.println("Input 'id' to update: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Employee obj = new Employee(null, first_name, second_name, type_of_job, null);

        int count = employeeController.update(id, obj);
        System.out.printf("There are created %d rows\n", count);
    }

    private void createShow(){
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'date': ");
        Date date = Date.valueOf(input.nextLine());
        System.out.println("Input 'max_amount_of_visitors': ");
        Integer max_amount_of_visitors = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'dysney_park_id': ");
        Integer dysney_park_id = Integer.valueOf((input.nextLine()));
        Show obj = new Show(null, name, date, max_amount_of_visitors, dysney_park_id);

        int count = showController.create(obj);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateShow(){
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'date': ");
        Date date = Date.valueOf(input.nextLine());
        System.out.println("Input 'max_amount_of_visitors': ");
        Integer max_amount_of_visitors = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'id' to update: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Show obj = new Show(null, name, date, max_amount_of_visitors, null);

        int count = showController.update(id, obj);
        System.out.printf("There are created %d rows\n", count);
    }

    public void createTickets(){
        System.out.println("Input 'price': ");
        Double price = Double.valueOf((input.nextLine()));
        System.out.println("Input 'priority_pass': ");
        Boolean priority_pass = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'use_date': ");
        Date use_date = Date.valueOf(input.nextLine());
        System.out.println("Input 'dysney_park_id': ");
        Integer dysney_park_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'customer_id': ");
        Integer customer_id = Integer.valueOf((input.nextLine()));
        Tickets obj = new Tickets(null, price, priority_pass, use_date, dysney_park_id, customer_id);


        int count = ticketsController.create(obj);
        System.out.printf("There are created %d rows\n", count);
    }

    public void updateTickets(){
        System.out.println("Input 'price': ");
        Double price = Double.valueOf((input.nextLine()));
        System.out.println("Input 'priority_pass': ");
        Boolean priority_pass = Boolean.valueOf(input.nextLine());
        System.out.println("Input 'use_date': ");
        Date use_date = Date.valueOf(input.nextLine());
        System.out.println("Input 'dysney_park_id': ");
        Integer dysney_park_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'customer_id': ");
        Integer customer_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'id' to update: ");
        Integer id = Integer.valueOf((input.nextLine()));
        Tickets obj = new Tickets(null, price, priority_pass, use_date, dysney_park_id, customer_id);


        int count = ticketsController.update(id, obj);
        System.out.printf("There are created %d rows\n", count);
    }

    private void findAttractionByName() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Optional<Attraction> book = attractionController.findByName(name);
        System.out.println(book.orElse(nullAttraction));
    }

    private void findCustomerBySecond_name() {
        System.out.println("Input 'second_name': ");
        String name = input.nextLine();

        Optional<Customer> book = customerController.findBySecond_name(name);
        System.out.println(book.orElse(nullCustomer));
    }

    private void findCustomerByFirst_name() {
        System.out.println("Input 'first_name': ");
        String name = input.nextLine();

        Optional<Customer> book = customerController.findByFirst_name(name);
        System.out.println(book.orElse(nullCustomer));
    }

    private void findDysneyParkByCity() {
        System.out.println("Input 'city': ");
        String var = input.nextLine();

        Optional<DysneyPark> book = dysneyParkController.findByCity(var);
        System.out.println(book.orElse(nullDysneyPark));
    }

    private void findDysneyParkByStreet() {
        System.out.println("Input 'street': ");
        String var = input.nextLine();

        Optional<DysneyPark> book = dysneyParkController.findByStreet(var);
        System.out.println(book.orElse(nullDysneyPark));
    }

    private void findEmployeeByType_of_job() {
        System.out.println("Input 'type_of_job': ");
        String var = input.nextLine();

        Optional<Employee> book = employeeController.findByType_of_job(var);
        System.out.println(book.orElse(nullEmployee));
    }

    private void findShowByName() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Optional<Show> book = showController.findByName(name);
        System.out.println(book.orElse(nullShow));
    }

    private void findTicketsByType_of_job() {
        System.out.println("Input 'priority_pass': ");
        Boolean var = Boolean.valueOf(input.nextLine());

        Optional<Tickets> book = ticketsController.findByPriority_pass(var);
        System.out.println(book.orElse(nullTickets));
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }

}
