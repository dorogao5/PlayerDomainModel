package ru.lab.characters;

import java.util.Objects;

public abstract class CasinoWorker extends Persona {

    private String post;

    public CasinoWorker(String name, String nationality, String post) {
        super(name, nationality);
        this.post = post;
    }

    @Override
    public String toString() {
        return "CasinoWorker{" +
                "name='" + getName() + '\'' +
                ", nationality='" + getNationality() + '\'' +
                ", post='" + post + '\'' +
                '}';
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CasinoWorker that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), post);
    }
}
