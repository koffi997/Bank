package fr.koffi.kata.Bank.Framework;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class FonctionnalException extends RuntimeException {

    private String ressourceName;
    private String field;
    private Object value;

    public FonctionnalException(String ressourceName, String field, Object value) {
        super(String.format("%s not found with %s: %s",ressourceName,field,value));
        this.ressourceName = ressourceName;
        this.field = field;
        this.value = value;
    }
}
