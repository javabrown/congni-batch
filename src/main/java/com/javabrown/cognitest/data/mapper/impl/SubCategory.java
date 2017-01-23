package com.javabrown.cognitest.data.mapper.impl;

import java.util.Objects;

public class SubCategory {
    private String name;
    private String pt001;
    private String pt002;
    private String pt003;

    public SubCategory(String name, String pt001, String pt002, String pt003) {
        this.name = name;
        this.pt001 = pt001;
        this.pt002 = pt002;
        this.pt003 = pt003;
    }

    public String getName() {
        return name;
    }

    public String getPt001() {
        return pt001;
    }

    public String getPt002() {
        return pt002;
    }

    public String getPt003() {
        return pt003;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(pt001, that.pt001) &&
                Objects.equals(pt002, that.pt002) &&
                Objects.equals(pt003, that.pt003);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pt001, pt002, pt003);
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "name='" + name + '\'' +
                ", pt001='" + pt001 + '\'' +
                ", pt002='" + pt002 + '\'' +
                ", pt003='" + pt003 + '\'' +
                '}';
    }
}