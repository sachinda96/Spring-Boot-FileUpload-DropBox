package com.fileupload;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import org.springframework.stereotype.Component;

@Component
public class DropBoxConfig {

    private static final String ACCESS_TOKEN = "YOUR_ACCES_TOKEN";


    public DbxClientV2 getDbxClientV2() {

        try {

            DbxRequestConfig config;
            config = new DbxRequestConfig("dropbox/YOUR_PROJECT_NAME");
            DbxClientV2 client;
            client = new DbxClientV2(config, ACCESS_TOKEN);
//            FullAccount account;
//            DbxUserUsersRequests r1 = client.users();
//            account = r1.getCurrentAccount();
//            System.out.println(account.getName().getDisplayName());
//
//            // Get files and folder metadata from Dropbox root directory
//            ListFolderResult result = client.files().listFolder("");
//            while (true) {
//                for (Metadata metadata : result.getEntries()) {
//                    System.out.println(metadata.getPathLower());
//                }
//
//                if (!result.getHasMore()) {
//                    break;
//                }
//
//                result = client.files().listFolderContinue(result.getCursor());
//            }


//            // Upload "test.txt" to Dropbox
//            try (InputStream in = new FileInputStream("test.mp4")) {
//                FileMetadata metadata = client.files().uploadBuilder("/test.mp4")
//                        .uploadAndFinish(in);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//            DbxDownloader<FileMetadata> downloader = client.files().download("/test.mp4");
//            try {
//                FileOutputStream out = new FileOutputStream("test.mp4");
//                downloader.download(out);
//                out.close();
//                System.out.println("sucess");
//            } catch (DbxException ex) {
//                System.out.println(ex.getMessage());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            return client;

        } catch (Exception ex1) {
            ex1.printStackTrace();
            throw ex1;
        }
    }
}
