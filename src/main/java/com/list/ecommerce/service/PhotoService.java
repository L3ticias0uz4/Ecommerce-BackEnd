package com.list.ecommerce.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

    @Service
    public class PhotoService {

        @Value("${upload.dir}")
        private String uploadDir;

        public String salvarFoto(MultipartFile foto) throws IOException {
            String nomeOriginal = foto.getOriginalFilename();
            String extensao = nomeOriginal.substring(nomeOriginal.lastIndexOf("."));
            String novoNome = UUID.randomUUID() + extensao;

            Path diretorio = Path.of(uploadDir);
            Files.createDirectories(diretorio);

            Path caminho = diretorio.resolve(novoNome);
            Files.copy(foto.getInputStream(), caminho);

            return uploadDir + "/" + novoNome;
        }
    }

