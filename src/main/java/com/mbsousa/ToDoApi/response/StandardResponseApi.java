package com.mbsousa.ToDoApi.response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Resposta padrão da API")
public class StandardResponseApi<T> {

    @Schema(description = "Dados retornados", example = "null")
    private T data;

    @Schema(description = "Mensagem de sucesso", example = "Operação realizada com sucesso")
    private String message;

    @Schema(description = "Mensagem de erro", example = "Recurso não encontrado")
    private String error;

    @Schema(example = "200")
    private int status;

    public StandardResponseApi() {}

    public StandardResponseApi(T data, String message, String error, int status) {
        this.data = data;
        this.message = message;
        this.error = error;
        this.status = status;
    }
}

