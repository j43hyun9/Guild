package com.j43hyun9.guildproject.save;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class SaveYamlNormal implements AutoSave {
    @Override
    public void save(Object... args) {
        DumperOptions options = new DumperOptions();
        options.setIndent(4); // YAML 파일의 들여쓰기를 4로 설정
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK); // 블록 스타일 사용

        Yaml yaml = new Yaml(options);
    }
}
