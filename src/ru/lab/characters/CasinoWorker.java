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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CasinoWorker that = (CasinoWorker) o;
        return Objects.equals(getPost(), that.getPost()) && Objects.equals(getNationality(), that.getNationality()) && Objects.equals(getName(), that.getName());
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

}
