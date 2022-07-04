package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.util.Arrays;
import java.util.List;

public class UsersUtil {

    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;

    public static final List<User> USERS = Arrays.asList(
            new User(21, "AABC", "mail@mail", "123456", Role.USER),
            new User(1, "ZBC", "mail@mail", "123456", Role.USER),
            new User(15, "ABC", "mail@mail", "123456", Role.USER),
            new User(100, "TBC", "mail@mail", "123456", Role.USER)
    );
}