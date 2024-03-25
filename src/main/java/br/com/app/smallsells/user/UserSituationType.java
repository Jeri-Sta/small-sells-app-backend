package br.com.app.smallsells.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

public enum UserSituationType {

    ACTIVE ("A", "Ativo"),
    INACTIVE ("I", "Inativo"),
    PENDING ("P", "Pendente");

    @Setter
    private String code;
    @Getter
    private String description;

    UserSituationType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public static UserSituationType ofValue(String code) {
        return switch (code) {
            case "A" -> ACTIVE;
            case "I" -> INACTIVE;
            case "P" -> PENDING;
            default -> null;
        };
    }
}
