/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;

/**
 *
 * @author ld_si
 */
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.ASCIIUtility;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.SecretKey;

public class Exemplo3c {

    public static void main(String[] args) throws IOException {

        FileInputStream arq = new FileInputStream("C:\\Users\\ld_si\\OneDrive\\Documentos\\NetBeansProjects\\Criptografia\\src\\criptografia\\texto.txt");
        DataInputStream lerArq = new DataInputStream(arq);
        FileOutputStream arqOutC = new FileOutputStream("C:\\Users\\ld_si\\OneDrive\\Documentos\\NetBeansProjects\\Criptografia\\src\\criptografia\\texto_c.txt");
        FileOutputStream arqOutD = new FileOutputStream("C:\\Users\\ld_si\\OneDrive\\Documentos\\NetBeansProjects\\Criptografia\\src\\criptografia\\texto_d.txt");
        DataOutputStream gravarArqC = new DataOutputStream(arqOutC);
        DataOutputStream gravarArqD = new DataOutputStream(arqOutD);
        File file = new File("C:\\Users\\ld_si\\OneDrive\\Documentos\\NetBeansProjects\\Criptografia\\src\\criptografia\\texto.txt");
        File cfile = new File("C:\\Users\\ld_si\\OneDrive\\Documentos\\NetBeansProjects\\Criptografia\\src\\criptografia\\texto_c.txt");
        SecretKey key = Criptografia.simetricKey();

        gravarArqC.write(Criptografia.simetricCript(getBytes(file), key));

        gravarArqD.write(Criptografia.simetricDecript(getBytes(cfile), key));

        arq.close();
    }

    public static byte[] getBytes(File file) {
        int len = (int) file.length();
        byte[] sendBuf = new byte[len];
        FileInputStream inFile = null;
        try {
            inFile = new FileInputStream(file);
            inFile.read(sendBuf, 0, len);

        } catch (FileNotFoundException fnfex) {

        } catch (IOException ioex) {

        }
        return sendBuf;
    }
}
