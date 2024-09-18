package org.ogleh.candinatesservices.controllers;

import lombok.RequiredArgsConstructor;
import org.ogleh.candinatesservices.utility.Storage;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final Storage storage;

    @PostMapping("/image")
    public String saveImage(@RequestParam MultipartFile file) throws IOException {
        return storage. createImage(file);
    }
}
