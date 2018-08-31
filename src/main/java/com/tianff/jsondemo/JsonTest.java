package com.tianff.jsondemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tianff.jsondemo.entity.Dog;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonTest {

    private static int seed = 10;

    public static void main(String[] args) {

        List<Dog> dogs = Arrays.asList(buildDog(), buildDog(), buildDog());

        Dog singleDog = buildDog();

        Map<String, Dog> id2Dog = dogs.stream()
                .collect(Collectors.toMap(Dog::getName, v -> v));

        System.out.println("Dogs JSON: \n " + JSON.toJSONString(dogs));
        System.out.println("Single Dog JSON: \n " + JSON.toJSONString(singleDog));
        System.out.println("DogMap JSON: \n " + JSON.toJSONString(id2Dog));

        List<Dog> fromJsonDogs = JSON.parseArray(JSON.toJSONString(dogs), Dog.class);
        Dog fromJSONDog = JSON.parseObject(JSON.toJSONString(singleDog), Dog.class);
        Map<String, Dog> fromJSONDogMap = JSON.parseObject(JSON.toJSONString(id2Dog), new TypeReference<Map<String, Dog>>() {
        });
    }

    private static Dog buildDog() {
        Dog d = new Dog();
        d.setId(100008 + seed++);
        d.setName("ZZZ" + seed++);
        d.setSlogan("风一样的zzz");
        return d;
    }
}
