package com.compcorp.commerce.io;
import java.io.*;import java.nio.file.*;import java.util.*;
public final class SafeCsvReader{private SafeCsvReader(){} public static List<String> readLines(Path path)throws IOException{try(BufferedReader reader=Files.newBufferedReader(path)){return reader.lines().toList();}}}
