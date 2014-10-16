package br.unicesumar.escoladeti.comando;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Jhonatan on 14/10/2014.
 */
public class ComandoUpload {
    public Long identificador;

    public MultipartFile file;

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
