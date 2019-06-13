/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;

import java.io.File;
import javax.crypto.SecretKey;

/**
 *
 * @author Aluno
 */
public class Teste {
    public static void main(String[] args) {
        SecretKey key = CriptSim.simetricKey();
        CriptSim.simetricCript(new File("C:\\Users\\Aluno\\Desktop\\teste.txt"), key, "C:\\Users\\Aluno\\Desktop\\testeC.txt");
        CriptSim.simetricDecript(new File("C:\\Users\\Aluno\\Desktop\\testeC.txt"), key, "C:\\Users\\Aluno\\Desktop\\testeD.txt");
    }
}
