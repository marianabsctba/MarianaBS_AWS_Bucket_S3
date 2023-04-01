package br.edu.infnet.marianabs.appDoacao.model.service;

import br.edu.infnet.marianabs.appDoacao.model.clients.IAddressJava;
import br.edu.infnet.marianabs.appDoacao.model.domain.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private IAddressJava enderecoClient;

    public Address obterCep(String cep){
        return enderecoClient.obterCep(cep);
    }
}
