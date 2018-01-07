package com.revature.assignforcetrainerms.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Zach Nelson on 2/1/2017.
 */

//@Table(name = "Certifications")
@Document(collection = "certification")
public class Certification {
/*
    @Id
    @Column(name = "ID")
    @SequenceGenerator(allocationSize = 1, name = "certSeq", sequenceName = "CERT_ID_SEQ")
    @GeneratedValue(generator = "certSeq", strategy = GenerationType.SEQUENCE)*/
//
//    @Id
//    private int id;

    //@Column(name = "Cert_URL")
//    @Field
    private String url;

//    @Column(name = "CERT_NAME")
//    @Field("CERT_NAME")
    private String name;

//    @Column(name = "TRAINER")
//    @Field("TRAINER")
    private int trainer;

    public Certification() {
    	//noarg constructor
    }

    public Certification(int id, String url, String name, int trainer) {
        this.url = url;
        this.name = name;
        this.trainer = trainer;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return url;
    }

    public void setFile(String url) {
        this.url = url;
    }

    public int getTrainer() {
        return trainer;
    }

    public void setTrainer(int trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "file='" + url + '\'' +
                ", name='" + name + '\'' +
                ", trainer=" + trainer +
                '}';
    }
}
