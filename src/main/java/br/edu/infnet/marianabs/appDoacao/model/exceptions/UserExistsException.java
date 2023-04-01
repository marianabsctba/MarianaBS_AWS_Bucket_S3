package br.edu.infnet.marianabs.appDoacao.model.exceptions;

public class UserExistsException extends Exception{
    public UserExistsException(String mensagem) {
        super(mensagem);
    }

}
