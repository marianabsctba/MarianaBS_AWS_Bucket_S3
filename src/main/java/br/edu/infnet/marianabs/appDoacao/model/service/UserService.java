package br.edu.infnet.marianabs.appDoacao.model.service;

import br.edu.infnet.marianabs.appDoacao.model.domain.User;
import br.edu.infnet.marianabs.appDoacao.model.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private AWSClient amazonClient;

    public void salvar(User usuario, MultipartFile file) {
        String base64 = amazonClient.uploadFile(file);
        if (base64 != null) {
            usuario.setArquivoUrl(base64);
        }
        usuarioRepository.save(usuario);
    }


    public void incluir(User usuario) {
        usuarioRepository.save(usuario);
    }

    public void alterar(User usuario) {
        usuarioRepository.save(usuario);
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

    public User findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public boolean verficaUsuarioExistente(User usuario) {
        return usuarioRepository.existsByEmail(usuario.getEmail());
    }

    public List<User> findAll() {
        return (List<User>) usuarioRepository.findAll();
    }
}
