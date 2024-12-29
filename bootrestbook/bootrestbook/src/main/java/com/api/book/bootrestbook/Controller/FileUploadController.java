package com.api.book.bootrestbook.Controller;

import com.api.book.bootrestbook.Helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

@RestController
public class FileUploadController {

    @Autowired
    FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        System.out.println(file.getContentType());
try {
    if (file.isEmpty()) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please select a file to upload");
    }
    if (!Objects.equals(file.getContentType(), "image/png")) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("please upload png file");
    }

    //file upload code
    boolean f = fileUploadHelper.uploadFile(file);

    if(f){
        return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
//        return ResponseEntity.ok("File is successfully uplaoded");
    }


}catch(Exception e){
    System.out.println(e);
}

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong. try again!");
    }
}
