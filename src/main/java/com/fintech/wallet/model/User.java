package com.fintech.wallet.model;

public class User {
    private long id;
    private String name;
    private String email;
    private int age;
    private boolean active = true;

    public User(long id, int age, String name, String email) {
        this.id = id;
        this.age = age;
        this.email = email;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void deactivate() {
        active = false;
    }

    public void activate() {
        active = true;
    }

    public boolean isAdult() {
        return this.age >= 18;
    }
    public void changeEmail(String newEmail) {
        if (newEmail == null || newEmail.isBlank()) {
            return;
        }
        this.email = newEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}

