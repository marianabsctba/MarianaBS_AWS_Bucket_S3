package br.edu.infnet.marianabs.appDoacao.model.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.marianabs.appDoacao.model.domain.Address;

@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface IAddressJava {
    @GetMapping(value = "/{cep}/json")
    public Address obterCep(@PathVariable String cep);

}
