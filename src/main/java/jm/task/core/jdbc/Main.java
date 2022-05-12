package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        UserServiceImpl persons = new UserServiceImpl();
        persons.createUsersTable();

        List<User> user = new ArrayList<>();
        user.add(new User("Leonard", "Hofstadter", (byte) 24));
        user.add(new User("Sheldon", "Cooper", (byte) 25));
        user.add(new User("Howard", "Wolowitz", (byte) 25));
        user.add(new User("Raj", "Koothrappali", (byte) 28));

        for (int i = 0; i < 4; i++) {
            persons.saveUser(user.get(i).getName(), user.get(i).getLastName(), user.get(i).getAge());
            System.out.printf("User с именем – %s добавлен в базу данных\n", persons.getAllUsers().get(i).getName());
        }

        System.out.printf(persons.getAllUsers().toString());

        persons.cleanUsersTable();
        persons.dropUsersTable();
    }
}
