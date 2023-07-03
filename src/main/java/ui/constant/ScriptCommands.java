package ui.constant;

import lombok.Getter;

public enum ScriptCommands {
    CLOSE_WINDOW("window.close();");

    @Getter
    private final String script;

    ScriptCommands(String script) {
        this.script = script;
    }
}