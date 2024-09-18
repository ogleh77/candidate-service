package org.ogleh.candinatesservices.utility;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class Storage {
    String filePath = FilePath.CANDIDATE_FILE_PATH.getFilePath();

    private static final List<String> ALLOWED_IMAGE_TYPES = Arrays.asList("image/png", "image/jpeg", "image/jpg");

    public String createImage(MultipartFile multipartFile) throws IOException {

        // Check if the uploaded file is an image
        String contentType = multipartFile.getContentType();
        if (contentType == null || !ALLOWED_IMAGE_TYPES.contains(contentType.toLowerCase())) {
            throw new ResponseStatusException(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "Only image files are allowed.");
        }

        // Save the file if it's a valid image type
        multipartFile.transferTo(new File(filePath + multipartFile.getOriginalFilename()));

        return filePath + "/" + multipartFile.getOriginalFilename();
    }
}



