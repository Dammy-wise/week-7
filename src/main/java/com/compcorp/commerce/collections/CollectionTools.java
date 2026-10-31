package com.compcorp.commerce.collections;
import java.util.*;import java.util.function.*;
public final class CollectionTools{private CollectionTools(){} public static <T,K> Map<K,List<T>> group(Collection<T> values,Function<T,K> key){Map<K,List<T>> out=new LinkedHashMap<>();for(T v:values)out.computeIfAbsent(key.apply(v),k->new ArrayList<>()).add(v);return out;} public static <T> List<T> safeSorted(Collection<T> values,Comparator<T> comparator){if(values==null)return List.of();return values.stream().filter(Objects::nonNull).sorted(comparator).toList();}}
