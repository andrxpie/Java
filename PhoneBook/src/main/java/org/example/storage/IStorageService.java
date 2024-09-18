package org.example.storage;

import org.example.DTOs.FileFormats;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IStorageService {
    void init() throws IOException;
    String saveFile(MultipartFile file) throws IOException;
    String saveImage(MultipartFile file, FileFormats format) throws IOException;
    void deleteImage(String imageName) throws IOException;
}