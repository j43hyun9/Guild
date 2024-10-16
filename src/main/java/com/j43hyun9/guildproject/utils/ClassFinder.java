package com.j43hyun9.guildproject.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); 에 대한 자세한 설명
    /**
     * Thread.currentThread(): 현재 실행 중인 스레드를 반환합니다.
     * getContextClassLoader(): 현재 스레드에 설정된 contextClassLoader를 반환합니다.
     * classLoader 변수: 반환된 contextClassLoader를 classLoader 변수에 저장합니다.
     */

// String packagePath = packageName.replace('.', '/');에 대한 설명
    /**
     * 이 코드는 자바 패키지 이름(예: com.example.mypackage)을 파일 시스템에서
     * 사용할 수 있는 경로 형식(예: com/example/mypackage)으로 변환하는 역할을 한다.
     */

public class ClassFinder {
    public static List<Class<?>> findSubclasses(Class<?> parentClass, String packageName, Plugin plugin) throws ClassNotFoundException {
        List<Class<?>> subclasses = new ArrayList<>();

        ClassLoader classLoader = plugin.getClass().getClassLoader();
        if(classLoader == null) {
            Bukkit.getConsoleSender().sendMessage("classLoader is null");
            return subclasses;
        } else {
            Bukkit.getConsoleSender().sendMessage("classLoader is "+classLoader.toString());
        }

        String packagePath = packageName.replace('.', '/');
        String resourcePath = "/com/j43hyun9/guildproject/command/CreateGuildCommandHandler.class"; // 예시
        URL resource = classLoader.getResource(resourcePath);
        //URL resource = classLoader.getResource(packagePath);

        if (resource == null) {
            System.out.println("리소스를 찾을 수 없습니다: " + resourcePath);
            // 에러 처리 (예: 로그 기록, 예외 발생)
        } else {
            // 리소스를 사용하는 코드
            // ...
        }
        Bukkit.getConsoleSender().sendMessage("-- protocol: "+Objects.requireNonNull(resource).getProtocol());
        Bukkit.getConsoleSender().sendMessage("-- Path: "+ resource.getPath());
        if (resource.getProtocol().equals("jar")) {
            String jarFilePath = resource.getPath().substring(5, resource.getPath().indexOf('!')); // JAR 파일 경로 추출
            String entryName = resource.getPath().substring(resource.getPath().indexOf('!') + 1); // 엔트리 이름 추출

            Bukkit.getConsoleSender().sendMessage("-- jarFilePath: "+ jarFilePath);
            Bukkit.getConsoleSender().sendMessage("-- entryName: "+ entryName);
            try (ZipFile zipFile = new ZipFile(jarFilePath)) {
                ZipEntry entry = zipFile.getEntry(entryName);
                if (entry != null) {
                    // 엔트리가 존재하는 경우 처리
                    // ...
                } else {
                    Bukkit.getConsoleSender().sendMessage("엔트리 '" + entryName + "'을 찾을 수 없습니다.");
                }
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage("JAR 파일을 열 수 없습니다: " + e.getMessage());
            }
        }
        if (resource == null) {
            Bukkit.getConsoleSender().sendMessage("resource is null");
            return subclasses;
        }
        File packageDirectory = new File(resource.getFile());
        Bukkit.getConsoleSender().sendMessage("nop");
        if (packageDirectory.isDirectory()) {
            Bukkit.getConsoleSender().sendMessage("what?");
            for (File file : packageDirectory.listFiles()) {
                Bukkit.getConsoleSender().sendMessage("debugging2");
                if (file.isFile() && file.getName().endsWith(".class")) {
                    Bukkit.getConsoleSender().sendMessage("debugging3");
                    String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                    Class<?> clazz = Class.forName(className);
                    if (parentClass.isAssignableFrom(clazz) && !clazz.equals(parentClass)) {
                        Bukkit.getConsoleSender().sendMessage("debugging4");
                        Bukkit.getConsoleSender().sendMessage(clazz.toString());
                        subclasses.add(clazz);
                    }
                }
            }
        }

        return subclasses;
    }
}
