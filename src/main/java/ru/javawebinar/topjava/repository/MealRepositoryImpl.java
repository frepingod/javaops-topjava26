package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealRepositoryImpl implements MealRepository {

    private final Map<Integer, Meal> meals = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (!meal.isIdExist()) {
            meal.setId(counter.incrementAndGet());
        }
        return meals.put(meal.getId(), meal);
    }

    @Override
    public boolean removeById(int id) {
        if (meals.containsKey(id)) {
            meals.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Meal getById(int id) {
        return meals.get(id);
    }

    @Override
    public Collection<Meal> getAll() {
        return meals.values();
    }
}