/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.security.Key;
import java.util.Date;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Scanner;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author lenovo
 */
public class ImportantFunctions {
    
    public static String encryptEmail(String email) throws Exception{
        Key key = generateKey();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal = c.doFinal(email.getBytes());
        String encrypted = new BASE64Encoder().encode(encVal);
        return encrypted;
    }
    
    public static String decryptEmail(String emailEncrypt) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE,key);
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(emailEncrypt);
        byte[] decValue = c.doFinal(decodedValue);
        String decrypted = new String(decValue);
        return decrypted;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec("lv54ssA887e8s8r6".getBytes(), "AES");
        return key;
    }
    public static boolean sendConfirmationEmail(String email) throws Exception{
        boolean result = false;
        final String username = "youremail@gmail.com";
	final String password = "yourpassword";
        String from = "emailsource@gmail.com";
        // Set properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
        String encryptEmail = encryptEmail(email);
        String link = "http://localhost:8080/Supermarket/UserControl?verif=true&code="+encryptEmail;
        // Get session
        javax.mail.Session session = javax.mail.Session.getInstance(props,new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
		}
        });
        
        try{
            // Instantiate a message
            Message msg = new MimeMessage(session);
 
            // Set the FROM message
            msg.setFrom(new InternetAddress(from));
 
            // The recipients can be more than one so we use an array but you can
            // use 'new InternetAddress(to)' for only one address.
            InternetAddress[] address = {new InternetAddress(email)};
            msg.setRecipients(Message.RecipientType.TO, address);
 
            // Set the message subject and date we sent it.
            msg.setSubject("Confirmation compte - Supermarket WebApp -");
            StringBuilder builder = new StringBuilder("<h2>Bienvenue</h2>");
            builder.append("<br><br> <p>Pour pouvoir utiliser les services de notre application qui se différent de :"
                    + "<br> 1- Gestion des produits des supérmarchés que vous possédez"
                    + "<br> 2- Gestions des livraisons des clients avec un meilleur délai et prix"
                    + "<br> 3- Tracker les livraisons en cours et visualisation des factures"
                    + "<br> Vous devez valider votre compte que vous l'avez créer en suivant ce lien : </p>"
                    + "<br> <a href="+link+">Cliquer ici</a>"
                    + "<hr> <br> <h6> L'équipe vous souhaite une bonne utilisation </h6>");
            String message = builder.toString();
            msg.setContent(message,"text/html; charset=utf-8");
            msg.setSentDate(new Date());
            Transport.send(msg);
            result = true;
        }catch(Exception ex){
            ex.printStackTrace();
            return result;
        }
        return result;
    }
    
    public static String sendMessageToPhone(String number,String theMessage){
        try {
            // Construct data
            String apiKey = "apikey=" + "LQyejOzFCws-vje9rd9MfWTc75Sjdvo7lzYsFJixYF";
            String message = "&message=" + theMessage;
            String sender = "&sender=" + "Supermarché Informations";
            String numbers = "&numbers=" + number;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
		stringBuffer.append(line);
            }
            rd.close();

	return stringBuffer.toString();
	
        } catch (Exception e) {
            System.out.println("Error SMS "+e);
            return "Error "+e;
	}
    }
    
    public static String dataToJson(String urlApi) {
		String html_output="";
                System.out.println("URL API : "+urlApi);
		try {
			URL url = new URL(urlApi);
                        doTrustToCertificates();
			Scanner scan = new Scanner(url.openStream());
			while(scan.hasNext()) {
				html_output += scan.nextLine();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return html_output;
    }
    
     // trusting all certificate 
 public static void doTrustToCertificates() throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                        return;
                    }
                }
        };

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }
 
    public static String generateMessageConfirmation(int idVisiteur,double priceProduit,double priceLivraison, double priceTotal){
        StringBuilder message = new StringBuilder();
        String nom = VisiteurFunction.getVisiteurById(idVisiteur).getNom();
        String prenom = VisiteurFunction.getVisiteurById(idVisiteur).getPrenom();
        String fullName = nom + " " + prenom;
        message.append("Bienvenue Mr(Mme)").append(fullName).append("\n");
        message.append("Votre commande a été approuvé et elle est en chemin vers votre maison").append("\n");
        message.append("Les détails relatives a votre commandes sont :").append("\n");
        message.append("Prix totale des produits commandés : ").append(priceProduit).append("\n");
        message.append("Prix de livraison : ").append(priceLivraison).append("\n");
        message.append("Montant totale est : ").append(priceTotal).append("\n");
        message.append("Nous vous souhaitons une bonne consommation et on vous remercie d'avoir utiliser nos services");
        return message.toString();
    }
}
