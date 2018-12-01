package com.sjsu.cmpe.sstreet.mirroringserver.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EntityUtils {


    public static HashMap<Method,Method> getGettersToSettersMap(Class result){
        List<Method> gettersAndSetters = Arrays.asList(org.springframework.util.ReflectionUtils.getAllDeclaredMethods(result));
        return (HashMap<Method, Method>) gettersAndSetters.stream()
                .filter(method -> method.getName().startsWith("get"))
                .collect(Collectors.toMap((Method key) -> key,
                        (Method value) -> gettersAndSetters.stream()
                                .filter(method -> method.getName().endsWith(value.getName().replaceAll("get","")))
                                .filter(method -> method.getName().startsWith("set"))
                                .findFirst()
                                .get()));

    }

    public static <T> void setUnsetValues(T objectToSet, T objectToGet){

        HashMap<Method,Method> gettersToSettersMap = getGettersToSettersMap(objectToGet.getClass());

        gettersToSettersMap.keySet()
                .stream()
                .filter(getMethod ->
                {
                    try {
                        return (Objects.isNull(getMethod.invoke(objectToSet)));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        return true;
                    }
                })
                .forEach(getMethod ->
                {
                    try{
                        gettersToSettersMap.get(getMethod)
                                .invoke(objectToSet,
                                        getMethod.invoke(objectToGet));

                    }catch(IllegalAccessException | InvocationTargetException e){
                        e.printStackTrace();
                    }
                });
    }

    public static <T> void copy(T sourceObject, T destinationObject){


        HashMap<Method,Method> gettersToSettersMap = getGettersToSettersMap(sourceObject.getClass());

        gettersToSettersMap.keySet()
                .stream()
                .forEach(getMethod ->
                {
                    try{
                        gettersToSettersMap.get(getMethod)
                                .invoke(destinationObject,
                                        getMethod.invoke(sourceObject));

                    }catch(IllegalAccessException | InvocationTargetException e){
                        e.printStackTrace();
                    }
                });

    }

}
