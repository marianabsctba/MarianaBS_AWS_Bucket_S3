package br.edu.infnet.marianabs.appDoacao.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import br.edu.infnet.marianabs.appDoacao.model.service.AWSClient;

import java.io.IOException;

@RestController
@RequestMapping("/storage/")
public class S3Controller {
    private AWSClient amazonClient;

    @Autowired
    S3Controller(AWSClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping
    public String uploadFile(@RequestPart(value = "file")MultipartFile file) {
        return this.amazonClient.uploadFile(file);
    }

    @DeleteMapping
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFile(fileUrl);
    }

    @GetMapping
    public String buscarImagem(@RequestParam String fileUrl) throws IOException {
        return this.amazonClient.getFile(fileUrl);
    }

}
