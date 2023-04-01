package br.edu.infnet.marianabs.appDoacao.model.service;


import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Objects;

@Service
public class AWSClient {
    private AmazonS3 s3Client;

    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    @Value("${amazonProperties.directory}")
    private String directory;

    @PostConstruct
    private void initializeAmazon() {
        s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new EnvironmentVariableCredentialsProvider())
                .withRegion("sa-east-1")
                .build();
    }

    public String uploadFile(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            String fileUrl = "";
            try {
                File file = convertMultiPartToFile(multipartFile);
                String fileName = generateFileName(multipartFile);
                fileUrl = directory + "/" + fileName;
                s3Client.putObject(bucketName, fileUrl, file);
                file.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return fileUrl;
        }
        return null;
    }

    public String deleteFile(String fileUrl) {
        s3Client.deleteObject(new DeleteObjectRequest(bucketName, fileUrl));
        return "Successfully deleted";
    }

    public String getFile(String fileUrl) throws IOException {
        if (fileUrl != null && !fileUrl.isEmpty()) {
            File file = new File("images/imagem.jpg");
            s3Client.getObject(new GetObjectRequest(bucketName, fileUrl), file);
            byte[] bytes = loadFile(file);
            byte[] encoded = Base64.encodeBase64(bytes);
            return new String(encoded, StandardCharsets.US_ASCII);
        }
        return "";
    }

    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        is.close();
        return bytes;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String generateFileName (MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename();
    }

}
