package com.chengkx.entity;

public class Pet {

    private Integer id;
    private String name;
    private User user;

    public Pet() {
    }

    public Pet(Integer id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


//    @Override
//    public String toString() {
//        return "Pet{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", user=" + user +
//                '}';
//    }
}
