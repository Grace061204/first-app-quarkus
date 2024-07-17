package org.acme.rest.json;

import jakarta.transaction.Transactional;

// import jakarta.enterprise.context.ApplicationScoped;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.*;

import org.acme.repository.FruitRepository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Path("/fruits")
// @ApplicationScoped
public class FruitResource {

    List<Fruit> fruits = new ArrayList<>();
    FruitRepository fruitRepository = new FruitRepository();

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    @Path("/all")
    public List<Fruit> get() {
        return Fruit.listAll();
        // return fruitRepository.findAll().list();

    }

    @GET
    @Path("/{id}")
    public Fruit getSingle(Long id) {
        return Fruit.findById(id);
        // return fruitRepository.findById(id);
    }

    // @POST
    // public Fruit create(Fruit fruit) {
    // return
    // Panache.withTransaction(fruit::persist).replaceWith(RestResponse.status(CREATED,
    // fruit));
    // }
    // public List<Fruit> list() {
    // return fruits;
    // }

    @POST
    public List<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        // fruitRepository.
        return fruits;
    }

    @POST
    @Path("/new")
    @Transactional
    public Fruit create(Fruit fruit) {
        fruit.persist();
        // return Response.created(URI.create("/fruits/" + fruit.id)).build();
        return fruit;
    }

    // @DELETE
    // public Set<Fruit> delete(Fruit fruit) {
    // fruits.removeIf(existingFruit ->
    // existingFruit.name.contentEquals(fruit.name));
    // return fruits;
    // }
}