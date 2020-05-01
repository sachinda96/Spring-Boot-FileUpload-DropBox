package com.fileupload.controller;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.UploadErrorException;
import com.fileupload.DropBoxConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
@RequestMapping(value = "/multipartfile")
public class MultipartController {


    @Autowired
    private DropBoxConfig dropBoxConfig;


    @PostMapping
    public ResponseEntity<?> saveFile(@RequestParam(name = "file") MultipartFile multipartFile){

        try (InputStream in = new ByteArrayInputStream(multipartFile.getBytes())) {
            FileMetadata metadata = dropBoxConfig.getDbxClientV2().files().uploadBuilder("/"+multipartFile.getOriginalFilename())
                    .uploadAndFinish(in);
            return  new ResponseEntity<>("200",HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
