package com.chengkx.entity;

public class Person {

    private Integer id;
    private String name;
    private idenCard card;

    public Person() {
    }

    public Person(Integer id, String name, idenCard card) {

        this.id = id;
        this.name = name;
        this.card = card;
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

    public idenCard getCard() {
        return card;
    }

    public void setCard(idenCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", card=" + card +
                '}';
    }
}
