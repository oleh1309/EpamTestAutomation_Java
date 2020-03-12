package com.epam.ViewAndController;

import com.epam.model.*;
import com.epam.service.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyView {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("A", "   A - Select all table");
        menu.put("B", "   B - Select structure of DB");

        menu.put("1", "   1 - Table: Department");
        menu.put("11", "  11 - Create for Department");
        menu.put("12", "  12 - Update Department");
        menu.put("13", "  13 - Delete from Department");
        menu.put("14", "  14 - Select Department");
        menu.put("15", "  15 - Find Department by ID");
        menu.put("16", "  16 - Delete from Department and move all employees to another department");

        menu.put("2", "   2 - Table: Employee");
        menu.put("21", "  21 - Create for Employee");
        menu.put("22", "  22 - Update Employee");
        menu.put("23", "  23 - Delete from Employee");
        menu.put("24", "  24 - Select Employee");
        menu.put("25", "  25 - Find Employee by ID");
        menu.put("26", "  26 - Find Employee by Name");

        menu.put("3", "   3 - Table: Project");
        menu.put("31", "  31 - Create for Project");
        menu.put("32", "  32 - Update Project");
        menu.put("33", "  33 - Delete from Project");
        menu.put("34", "  34 - Select Project");
        menu.put("35", "  35 - Find Project by ID");

        menu.put("4", "   4 - Table: Works_on");
        menu.put("41", "  41 - Create for Works_on");
        menu.put("42", "  42 - Update Works_on");
        menu.put("43", "  43 - Delete from Works_on");
        menu.put("44", "  44 - Select Works_on");
        menu.put("45", "  45 - Find Works_on by ID");

        menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllTable);
        methodsMenu.put("B", this::selectAllTable);
        methodsMenu.put("11", this::createForDepartment);
        methodsMenu.put("12", this::updateDepartment);
        methodsMenu.put("13", this::deleteFromDepartment);
        methodsMenu.put("14", this::selectDepartment);
        methodsMenu.put("15", this::findDepartmentByID);
        methodsMenu.put("16", this::deleteFromDepartmentMoveEmployees);

        methodsMenu.put("21", this::createForEmployee);
        methodsMenu.put("22", this::updateEmployee);
        methodsMenu.put("23", this::deleteFromEmployee);
        methodsMenu.put("24", this::selectEmployee);
        methodsMenu.put("25", this::findEmployeeByID);
        methodsMenu.put("26", this::findEmployeeByName);

        methodsMenu.put("31", this::createForProject);
        methodsMenu.put("32", this::updateProject);
        methodsMenu.put("33", this::deleteFromProject);
        methodsMenu.put("34", this::selectProject);
        methodsMenu.put("35", this::findProjectByID);

        methodsMenu.put("41", this::createForWorksOn);
        methodsMenu.put("42", this::updateWorksOn);
        methodsMenu.put("43", this::deleteFromWorksOn);
        methodsMenu.put("44", this::selectWorksOn);
    }


    private void selectAllTable() throws SQLException {
        selectDepartment();
        selectEmployee();
        selectProject();
        selectWorksOn();
    }


    private void deleteFromDepartment() throws SQLException {
        System.out.println("Input ID(dept_no) for Department: ");
        String id = input.nextLine();
        DepartmentService departmentService = new DepartmentService();
        int count = departmentService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForDepartment() throws SQLException {
        System.out.println("Input ID(dept_no) for Department: ");
        String id = input.nextLine();
        System.out.println("Input dept_name for Department: ");
        String deptName = input.nextLine();
        System.out.println("Input location for Department: ");
        String location = input.nextLine();
        DepartmentEntity entity = new DepartmentEntity(id, deptName, location);

        DepartmentService departmentService = new DepartmentService();
        int count = departmentService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateDepartment() throws SQLException {
        System.out.println("Input ID(dept_no) for Department: ");
        String id = input.next();
        System.out.println("Input dept_name for Department: ");
        String deptName = input.next();
        System.out.println("Input location for Department: ");
        String location = input.next();
        DepartmentEntity entity = new DepartmentEntity(id, deptName, location);

        DepartmentService departmentService = new DepartmentService();
        int count = departmentService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectDepartment() throws SQLException {
        System.out.println("\nTable: Department");
        DepartmentService departmentService = new DepartmentService();
        List<DepartmentEntity> departments = departmentService.findAll();
        for (DepartmentEntity entity : departments) {
            System.out.println(entity);
        }
    }

    private void findDepartmentByID() throws SQLException {
        System.out.println("Input ID(dept_no) for Department: ");
        String id = input.nextLine();
        DepartmentService departmentService = new DepartmentService();
        DepartmentEntity entity = departmentService.findById(id);
        System.out.println(entity);
    }

    private void deleteFromDepartmentMoveEmployees() throws SQLException {
        System.out.println("Input ID(dept_no) for this Department: ");
        String idDeleted = input.nextLine();
        System.out.println("Input ID(dept_no) for another Department (for move employees):");
        String idMoveTo = input.nextLine();

        DepartmentService departmentService = new DepartmentService();
        int count = departmentService.deleteWithMoveOfEmployees(idDeleted, idMoveTo);
        System.out.printf("There are deleted %d rows\n", count);
    }

    //------------------------------------------------------------------------

    private void deleteFromEmployee() throws SQLException {
        System.out.println("Input ID(dept_no) for Employee: ");
        Integer id = input.nextInt();
        input.nextLine();
        EmployeeService employeeService = new EmployeeService();
        int count = employeeService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForEmployee() throws SQLException {
        System.out.println("Input ID(epm_no) for Employee: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input emp_fmane for Employee: ");
        String empFirstName = input.nextLine();
        System.out.println("Input emp_lname for Employee: ");
        String empLastName = input.nextLine();
        System.out.println("Input dept_no for Employee: ");
        String deptNo = input.nextLine();
        EmployeeEntity entity = new EmployeeEntity(id, empFirstName, empLastName, deptNo);
        EmployeeService employeeService = new EmployeeService();

        int count = employeeService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateEmployee() throws SQLException {
        System.out.println("Input ID(epm_no) for Employee: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input emp_fmane for Employee: ");
        String empFirstName = input.nextLine();
        System.out.println("Input emp_lname for Employee: ");
        String empLastName = input.nextLine();
        System.out.println("Input dept_no for Employee: ");
        String deptNo = input.nextLine();
        EmployeeEntity entity = new EmployeeEntity(id, empFirstName, empLastName, deptNo);
        EmployeeService employeeService = new EmployeeService();

        int count = employeeService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectEmployee() throws SQLException {
        System.out.println("\nTable: Employee");
        EmployeeService employeeService = new EmployeeService();
        List<EmployeeEntity> employees = employeeService.findAll();
        for (EmployeeEntity entity : employees) {
            System.out.println(entity);
        }
    }

    private void findEmployeeByID() throws SQLException {
        System.out.println("Input ID(emp_no) for Employee: ");
        Integer id = input.nextInt();
        input.nextLine();
        EmployeeService employeeService = new EmployeeService();
        EmployeeEntity entity = employeeService.findById(id);
        System.out.println(entity);
    }

    private void findEmployeeByName() throws SQLException {
        System.out.println("Input First Name for Employee: ");
        String fname = input.nextLine();
        EmployeeService employeeService = new EmployeeService();
        List<EmployeeEntity> employees = employeeService.findByName(fname);
        for (EmployeeEntity entity : employees) {
            System.out.println(entity);
        }
    }

    //------------------------------------------------------------------------

    private void updateProject() throws SQLException {
        System.out.println("Input ID(project_no) for Project: ");
        String id = input.nextLine();
        System.out.println("Input project_name for Project: ");
        String projectName = input.nextLine();
        System.out.println("Input budget for Project: ");
        Integer budget = input.nextInt();
        input.nextLine();
        ProjectEntity entity = new ProjectEntity(id, projectName, budget);

        ProjectService projectService = new ProjectService();
        int count = projectService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromProject() throws SQLException {
        System.out.println("Input ID(project_no) for Project: ");
        String id = input.nextLine();
        ProjectService projectService = new ProjectService();
        int count = projectService.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForProject() throws SQLException {
        System.out.println("Input ID(project_no) for Project: ");
        String id = input.nextLine();
        System.out.println("Input project_name for Project: ");
        String projectName = input.nextLine();
        System.out.println("Input budget for Project: ");
        Integer budget = input.nextInt();
        input.nextLine();
        ProjectEntity entity = new ProjectEntity(id, projectName, budget);

        ProjectService projectService = new ProjectService();
        int count = projectService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void selectProject() throws SQLException {
        System.out.println("\nTable: Project");
        ProjectService projectService = new ProjectService();
        List<ProjectEntity> projects = projectService.findAll();
        for (ProjectEntity entity : projects) {
            System.out.println(entity);
        }
    }

    private void findProjectByID() throws SQLException {
        System.out.println("Input ID(emp_no) for Employee: ");
        String id = input.nextLine();
        ProjectService projectService = new ProjectService();
        ProjectEntity entity = projectService.findById(id);
        System.out.println(entity);
    }

    //------------------------------------------------------------------------

    private void deleteFromWorksOn() throws SQLException {
        System.out.println("Input ID(emp_no) for Works_on: ");
        Integer id_emp = input.nextInt();
        input.nextLine();
        System.out.println("Input ID(project_no) for Works_on: ");
        String id_project = input.nextLine();
        PK_WorksOn pk = new PK_WorksOn(id_emp, id_project);

        WorkOnService workOnService = new WorkOnService();
        int count = workOnService.delete(pk);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createForWorksOn() throws SQLException {
        System.out.println("Input ID(emp_no) for Works_on: ");
        Integer id_emp = input.nextInt();
        input.nextLine();
        System.out.println("Input ID(project_no) for Works_on: ");
        String id_project = input.nextLine();
        PK_WorksOn pk = new PK_WorksOn(id_emp, id_project);

        System.out.println("Input job for Works_on: ");
        String job = input.nextLine();
        System.out.println("Input enter_date for Works_on (1999-01-23): ");
        String str = input.nextLine();
        Date enterDate = Date.valueOf(str);

        WorksOnEntity entity = new WorksOnEntity(pk, job, enterDate);
        WorkOnService workOnService = new WorkOnService();
        int count = workOnService.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateWorksOn() throws SQLException {
        System.out.println("Input ID(emp_no) for Works_on: ");
        Integer id_emp = input.nextInt();
        input.nextLine();
        System.out.println("Input ID(project_no) for Works_on: ");
        String id_project = input.nextLine();
        PK_WorksOn pk = new PK_WorksOn(id_emp, id_project);

        System.out.println("Input job for Works_on: ");
        String job = input.nextLine();
        System.out.println("Input enter_date for Works_on: ");
        String str = input.nextLine();
        Date enterDate = Date.valueOf(str);

        WorksOnEntity entity = new WorksOnEntity(pk, job, enterDate);
        WorkOnService workOnService = new WorkOnService();
        int count = workOnService.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectWorksOn() throws SQLException {
        System.out.println("\nTable: Works_on");
        WorkOnService workOnService = new WorkOnService();
        List<WorksOnEntity> works = workOnService.findAll();
        for (WorksOnEntity entity : works) {
            System.out.println(entity);
        }
    }

    //-------------------------------------------------------------------------

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
