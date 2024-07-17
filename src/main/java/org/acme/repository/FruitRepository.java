package org.acme.repository;

import java.util.List;

import org.acme.rest.json.Fruit;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class FruitRepository implements PanacheRepository<Fruit> {
    // public List<Fruit> findAllFruits() {
    // return listAll();
    // }
}
