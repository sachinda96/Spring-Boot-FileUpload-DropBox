1. Create DropBox Account 

2. Create DropBox Developer project 
        https://www.dropbox.com/developers/documentation

3. Generate access token in developer project console

4. Create spring project using spring initializr

5. Add Maven Dependency in Pom.xml

                <dependency>
        			<groupId>com.dropbox.core</groupId>
        			<artifactId>dropbox-core-sdk</artifactId>
        			<version>3.0.6</version>
        		</dependency>

6. Add Access Token and project Name configuration class
        
        public class DropBoxConfig {
            private static final String ACCESS_TOKEN = "YOUR_ACCES_TOKEN";
            public DbxClientV2 getDbxClientV2() {
                try {
        
                    DbxRequestConfig config;
                    config = new DbxRequestConfig("dropbox/YOUR_PROJECT_NAME");
                    DbxClientV2 client;
                    client = new DbxClientV2(config, ACCESS_TOKEN);
            } 
            
            }

6. Run fileupload.html file with spring boot project

7. upload ,download and view files using DbxClientV2 client
