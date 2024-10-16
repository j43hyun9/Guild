package com.j43hyun9.guildproject.utils;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class MyYaml {
    public static DumperOptions options = new DumperOptions();
    public static Yaml MY_YAML = new Yaml(options);

    public static Yaml getYaml() {
        return MY_YAML;
    }



}
