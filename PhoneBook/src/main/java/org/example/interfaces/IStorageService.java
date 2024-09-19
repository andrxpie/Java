package org.example.interfaces;

import org.example.dtos.FileFormats;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface IStorageService {
    void init() throws IOException;
    String saveFile(MultipartFile file);
    void deleteFile(String fileName);
    String saveImage(MultipartFile file, FileFormats format) throws IOException;
    String saveImage(String fileUrl, FileFormats format) throws IOException;
    String saveBufferedImage(BufferedImage bufferedImage, FileFormats format) throws IOException;
    void deleteImage(String imageName) throws IOException;
    void deleteImages(Iterable<String> imageNames) throws IOException;
}