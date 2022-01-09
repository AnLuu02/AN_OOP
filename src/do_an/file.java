/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author PC
 */
public  class file {
    public static void ghi_file(Object obj, String link) throws IOException {
        FileOutputStream out = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            out = new FileOutputStream(link);
            objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
        } finally {
            if (out != null) {
                out.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
    }
}
