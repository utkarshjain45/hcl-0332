package com.hcl.library.model;

import java.util.List;

public class Member {
    int id;
    String name;
    String email;
    List<Borrowable> borrowableList;

    public Member(int id, String name, String email) {
        if(!email.contains("@")){
            throw new RuntimeException("Email Not Valid");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
