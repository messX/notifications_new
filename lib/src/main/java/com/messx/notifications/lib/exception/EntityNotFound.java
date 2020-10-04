package com.messx.notifications.lib.exception;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EntityNotFound extends RuntimeException {
    public EntityNotFound(Class clazz, String... searchParams){
        super(EntityNotFound.generateMessage(clazz.getSimpleName(), searchParams));
    }

    private static String generateMessage(String className, String... searchParams){
        return className + "was not found for params " + stringArrToMap(searchParams);
    }

    private static Map<String, String> stringArrToMap(String[] searchParams){
        if(searchParams.length % 2 == 1){
            throw new IllegalArgumentException("Invalid arguments");
        }
        else{
            return IntStream.range(0, searchParams.length / 2).map(i -> i * 2)
                    .boxed()
                    .collect(Collectors.toMap(x -> searchParams[x], x -> searchParams[x+1]));
        }
    }
}
